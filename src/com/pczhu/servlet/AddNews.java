package com.pczhu.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pczhu.bean.NewsBean;
import com.pczhu.bean.UserBean;
import com.pczhu.dao.UserDaoInterface;
import com.pczhu.dao.impl.UserDaoImpl;
import com.pczhu.service.NewsDataControl;
import com.pczhu.utils.IPUtils;
import com.pczhu.utils.MD5Utils;
import com.pczhu.utils.TimeUtils;

/**
 * Servlet implementation class AddNews
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDataControl newsdatacontrol;
	private boolean flag = true;
	private UserBean userbean;
	private String filePathsource; // 文件存放目录
	private String tempPathsource; // 临时文件目录
	private String filePath; // 文件存放目录
	private String tempPath; // 临时文件目录
	private String filename;
	private NewsBean news;
	private String userPassword;
	
	private String newsuserid;
	private String webname;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setContentType("text/plain;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		 
		//FileItem.getString("utf-8");
		webname = request.getContextPath();
		news = new NewsBean();
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
		if(flag != false){
			UserDaoInterface userDaoInterface = new UserDaoImpl();
			userbean = userDaoInterface.getVaildUser(news.getNewsuserName(), userPassword);
			newsuserid = userbean.getUserid()+"";
			news.setNewsUserID(newsuserid);
			news.setNewsdateTime(TimeUtils.getFormatTime("yyyy-MM-dd HH:mm:ss", new Date()));
		}
		//NewsBean news = receivedata(request, response);
		if (userbean != null) {
			flag = newsdatacontrol.addNews(news);
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
	private void processFormField(FileItem item)
			throws Exception {
		String name = item.getFieldName();
		String value = item.getString("utf-8");
		
		if("newstitle".equals(name)){
			news.setNewstitle(value);
		}else if("newsdesc".equals(name)){
			news.setNewsdesc(value);
		}else if("newscontent".equals(name)){
			news.setNewscontent(value);
		}else if("newsclasstag".equals(name)){
			news.setClassTag(value);
		}else if("newswriter".equals(name)){
			news.setNewswriter(value);
		}else if("newsusername".equals(name)){
			news.setNewsuserName(value);
		}else if("userpassword".equals(name)){
			userPassword = value;
		}else if("newssource".equals(name)){
			news.setNewssource(value);
		}

		System.out.println(name + " : " + value + "\r\n");
	}

	// 处理上传的文件
	private void processUploadFile(FileItem item)
			throws Exception {
		filename = item.getName();
		System.out.println("完整的文件名：" + filename);
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index + 1, filename.length());
		String endstr = filename.substring(filename.indexOf("."));
		filename = MD5Utils.toMD5(filename+new Date().getTime())+endstr;
		long fileSize = item.getSize();

		if ("".equals(filename) && fileSize == 0) {
			System.out.println("文件名为空 ...");
			return;
		}
		if(item.getFieldName().equals("newsimgurl")){
			news.setNewsimgurl("http://"+IPUtils.getLocalIP()+webname+"/"+filePathsource+"/"+filename);
		}else if(item.getFieldName().equals("newscontentimgurl")){
			news.setNewscontentimgurl("http://"+IPUtils.getLocalIP()+webname+"/"+filePathsource+"/"+filename);
		}
		File file = new File(filePath);
		if(file.exists()){
			
		}else{
			file.createNewFile();
		}
		File uploadFile = new File(filePath + "/" + filename);
		System.out.println("相对路径http://"+IPUtils.getLocalIP()+webname+"/"+filePathsource+"/"+filename);
		item.write(uploadFile);

		// pw.println(filename + " 文件保存完毕 ...");
		// pw.println("文件大小为 ：" + fileSize + "\r\n");
	}

}
