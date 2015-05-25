package com.pczhu.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pczhu.bean.ImageInfo;
import com.pczhu.bean.NewsBean;
import com.pczhu.bean.UserBean;
import com.pczhu.dao.UserDaoInterface;
import com.pczhu.dao.impl.UserDaoImpl;
import com.pczhu.service.PicControl;
import com.pczhu.service.NewsDataControl;
import com.pczhu.utils.IPUtils;
import com.pczhu.utils.MD5Utils;
import com.pczhu.utils.TimeUtils;

/**
 * Servlet implementation class AddPics
 */
public class AddPics extends HttpServlet {
	private boolean flag = true;
	private String filePathsource; // 文件存放目录
	private String tempPathsource; // 临时文件目录
	private String filePath; // 文件存放目录
	private String tempPath; // 临时文件目录
	private String filename;
	private String username;
	private String userPassword;
	private NewsDataControl newsdatacontrol;
	private PicControl imageControl;
	private String webname;
	private UserBean userbean;
	private ImageInfo imageinfo;
	private static final long serialVersionUID = 1L;

	private String uid;
	private int width;
	private int height;
	private String picurl;
	private String pictitle;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPics() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 从配置文件中获得初始化参数
		filePathsource = config.getInitParameter("filepath");
		tempPathsource = config.getInitParameter("temppath");

		ServletContext context = getServletContext();

		filePath = context.getRealPath(filePathsource);
		tempPath = context.getRealPath(tempPathsource);
		System.out.println("文件存放目录、临时文件目录准备完毕 ...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
		// response.setContentType("text/plain;charset=utf-8");
		// response.setCharacterEncoding("utf-8");

		// FileItem.getString("utf-8");
		webname = request.getContextPath();
		imageinfo = new ImageInfo();
		imageinfo.setCheckok("0");
		imageinfo.setPictime(TimeUtils.getFormatTime("yyyy-MM-dd HH:mm:ss"));
		try {
			DiskFileItemFactory diskFactory = new DiskFileItemFactory();
			// threshold 极限、临界值，即硬盘缓存 1M
			diskFactory.setSizeThreshold(4 * 1024);
			// repository 贮藏室，即临时文件目录
			diskFactory.setRepository(new File(tempPath));

			ServletFileUpload upload = new ServletFileUpload(diskFactory);
			// 设置允许上传的最大文件大小 4M
			upload.setSizeMax(4 * 1024 * 1024);
			// 解析HTTP请求消息头
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (item.isFormField()) {
					System.out.println("处理表单内容 ...");
					processFormField(item);
				} else {
					System.out.println("处理上传的文件 ...");
					processUploadFile(item);
				}
			}// end while()

		} catch (Exception e) {
			System.out.println("使用 fileupload 包时发生异常 ...");
			e.printStackTrace();
			flag = false;
		}// end try ... catch ...

		newsdatacontrol = new NewsDataControl();
		if (flag != false) {
			UserDaoInterface userDaoInterface = new UserDaoImpl();
			userbean = userDaoInterface.getVaildUser(username, userPassword);
			uid = userbean.getUserid() + "";
			
		}
		// NewsBean news = receivedata(request, response);
		if (userbean != null) {
			imageControl = new PicControl();
			imageinfo.setUid(uid);
			imageinfo.setPicname(pictitle);
			imageinfo.setPicurl(picurl);
			imageinfo.setHeight(height);
			imageinfo.setWidth(width);
			int i = imageControl.addPic(imageinfo);
			flag = (i == 0 ? false : true);
		} else {
			flag = false;
		}
		if (!flag) {
			response.sendRedirect("failed.jsp");
		} else {
			response.sendRedirect("success.jsp");
		}
		return;

	}

	// 处理表单内容
	private void processFormField(FileItem item) throws Exception {
		String name = item.getFieldName();
		String value = item.getString("utf-8");

		if ("pictitle".equals(name)) {
			pictitle = value;
		} else if ("picusername".equals(name)) {
			username = value;
		} else if ("userpassword".equals(name)) {
			userPassword = value;
		}
		System.out.println(name + " : " + value + "\r\n");
	}

	// 处理上传的文件
	private void processUploadFile(FileItem item) throws Exception {
		filename = item.getName();
		System.out.println("完整的文件名：" + filename);
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index + 1, filename.length());
		String endstr = filename.substring(filename.indexOf("."));
		filename = MD5Utils.toMD5(filename + new Date().getTime()) + endstr;
		long fileSize = item.getSize();

		if ("".equals(filename) && fileSize == 0) {
			System.out.println("文件名为空 ...");
			return;
		}

		picurl = "http://" + IPUtils.getLocalIP() + webname+ "/" + filePathsource + "/" + filename;
		imageinfo.setPicurl(picurl);
		
		File file = new File(filePath);
		if (file.exists()) {

		} else {
			file.createNewFile();
		}
		File uploadFile = new File(filePath + "/" + filename);
		System.out.println("相对路径http://" + IPUtils.getLocalIP() + webname + "/"
				+ filePathsource + "/" + filename);
		item.write(uploadFile);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(uploadFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		width = bi.getWidth(); // 像素
		height = bi.getHeight(); // 像素

		System.out.println("width=" + width + ",height=" + height + "." + "title="+pictitle+".");

	}

}
