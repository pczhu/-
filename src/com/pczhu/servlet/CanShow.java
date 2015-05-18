package com.pczhu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.service.NewsDataControl;

/**
 * Servlet implementation class CanShow
 */
public class CanShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CanShow() {
        super();
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
		String newsid = request.getParameter("newsID");
		NewsDataControl newsDataControl = new NewsDataControl();
		Map<String,String> tag = new HashMap<String,String>();
		tag.put("newscheckup", "1");
		tag.put("newsshow", "1");
		newsDataControl.canshow(tag, newsid);
		request.getRequestDispatcher("shownews").forward(request, response);
		
	}

}
