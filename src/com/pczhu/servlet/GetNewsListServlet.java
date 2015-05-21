package com.pczhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.pczhu.bean.NewsBean;
import com.pczhu.bean.NewsListResult;
import com.pczhu.service.NewsDataControl;

/**
 * Servlet implementation class GetNewsListServlet
 */
public class GetNewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out = null;
	private NewsDataControl newsdatacontrol;
	private JSONArray newslist;
	private int pagecount = 10;
	private int pagenum = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNewsListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    //response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    newsdatacontrol = new NewsDataControl();
	    String pageSize = request.getParameter("pageSize");
	    String toPageNo = request.getParameter("toPageNo");
	    String tag = request.getParameter("tag");
	    
	    if(StringUtils.isEmpty(tag)){
	    	tag = "0";
	    }
	    System.out.println("第一步：页"+toPageNo+"每页大小:"+pageSize+"tag:"+tag);
	    if(!StringUtils.isEmpty(pageSize) && !StringUtils.isEmpty(toPageNo)){
	    	pagecount = Integer.parseInt(pageSize);
	    	pagenum = (Integer.parseInt(toPageNo)-1)* pagecount;
			newslist = getData(pagenum,pagecount,tag);
			System.out.println("第二部第一个");
			System.out.println(pagenum+":"+pagecount+":"+tag);
	    }else{
	    	System.out.println("第二部第二个");
	    	newslist = getData(0,10,tag);
	    }
	    
	    
		out = response.getWriter();

		
		JSONObject jsonObject = new JSONObject();  
		if(newslist!=null && newslist.size() != 0){
			jsonObject.put("status", 200); 
			jsonObject.put("msg", "成功"); 
			jsonObject.put("data", newslist); 
		}else{
			jsonObject.put("status", -103); 
			jsonObject.put("msg", "没有更多数据"); 
			jsonObject.put("data", ""); 
			
		}

		

        PrintWriter out = response.getWriter(); 
        String result = jsonObject.toString();
        out.write(result); 
	}

	private JSONArray getData(int i,int j,String tag) {
		JSONArray jsonArray = new JSONArray(); 
		List<NewsBean> newsDataList = newsdatacontrol.getAllNews(i,j,tag);
		System.out.println("拿到数据");
		for (NewsBean newsBean : newsDataList) {
			jsonArray.add(newsBean);  
		}
		System.out.println("返回数据");
		return jsonArray;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
