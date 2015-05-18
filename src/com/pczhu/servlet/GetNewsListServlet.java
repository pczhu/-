package com.pczhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	    response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		newsdatacontrol = new NewsDataControl();
		
		JSONArray newslist = getData();
		
		
		JSONObject jsonObject = new JSONObject();  
		jsonObject.put("resultCode", 200); 
        jsonObject.put("resultMessage", "成功"); 
        jsonObject.put("items", newslist); 
		

        PrintWriter out = response.getWriter();  
        out.write(jsonObject.toString()); 
	}

	private JSONArray getData() {
		JSONArray jsonArray = new JSONArray(); 
		List<NewsBean> newsDataList = newsdatacontrol.getNewsDataList(null);

		for (NewsBean newsBean : newsDataList) {
			jsonArray.add(newsBean);  
		}
		return jsonArray;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
