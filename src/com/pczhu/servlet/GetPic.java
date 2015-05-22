package com.pczhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.pczhu.bean.ImageInfo;
import com.pczhu.bean.NewsBean;
import com.pczhu.service.ImageControl;
import com.pczhu.service.NewsDataControl;

/**
 * Servlet implementation class GetPic
 */
public class GetPic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JSONArray imageinfolist;
	private ImageControl imageControl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getData(request,response);
	}

	private void getData(HttpServletRequest request,HttpServletResponse response) {
		 	response.setCharacterEncoding("utf-8");
		    imageControl = new ImageControl();
		    String pageSize = request.getParameter("pageSize");
		    String toPageNo = request.getParameter("toPageNo");

		    System.out.println("第一步：页"+toPageNo+"每页大小:"+pageSize);
		    if(!StringUtils.isEmpty(pageSize) && !StringUtils.isEmpty(toPageNo)){
		    	int pagecount = Integer.parseInt(pageSize);
		    	int pagenum = (Integer.parseInt(toPageNo)-1)* pagecount;
		    	imageinfolist = getDataArray(pagenum,pagecount);
				System.out.println("第二部第一个");

		    }else{
		    	System.out.println("第二部第二个");
		    	imageinfolist = getDataArray(0,10);
		    }

			JSONObject jsonObject = new JSONObject();  
			if(imageinfolist!=null && imageinfolist.size() != 0){
				jsonObject.put("status", 200); 
				jsonObject.put("msg", "成功"); 
				jsonObject.put("data", imageinfolist); 
			}else{
				jsonObject.put("status", -103); 
				jsonObject.put("msg", "没有更多数据"); 
				jsonObject.put("data", ""); 
			}

	        PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	        String result = jsonObject.toString();
	        out.write(result); 
		
	}
	private JSONArray getDataArray(int i,int j) {
		JSONArray jsonArray = new JSONArray(); 
		List<ImageInfo> imageinfolist = imageControl.getPicList(i, j);
		System.out.println("拿到数据");
		for (ImageInfo imageinfo : imageinfolist) {
			jsonArray.add(imageinfo);  
		}
		System.out.println("返回数据");
		return jsonArray;
	}
}
