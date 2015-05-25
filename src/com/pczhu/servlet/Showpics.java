package com.pczhu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.ImageInfo;
import com.pczhu.dao.PicDaoInterface;
import com.pczhu.dao.impl.PicDaoImpl;

/**
 * Servlet implementation class Showpics
 */
public class Showpics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showpics() {
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
		PicDaoInterface picDao = new PicDaoImpl();
		List<ImageInfo> picList = picDao.getPicList();
		if(picList != null){
			request.getSession().setAttribute("piclist", picList);
		}
		response.sendRedirect("showpic.jsp");
		
	}

}
