package com.pczhu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.ImageInfo;
import com.pczhu.bean.UserBean;
import com.pczhu.dao.PicDaoInterface;
import com.pczhu.dao.impl.PicDaoImpl;
import com.pczhu.service.NewsDataControl;

/**
 * Servlet implementation class Showpics
 */
public class Showpics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<ImageInfo> picList;
       
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
		UserBean userbean = (UserBean) request.getSession().getAttribute("logininfo");
		PicDaoInterface picDao = new PicDaoImpl();
		picList = picDao.getPicList();
		if(userbean.getUserPower()==2){
			picList = picDao.getPicList();
		}else{
			Map<String, String> map = new HashMap<String,String>();
			map.put("uid", userbean.getUserid()+"");
			picList = picDao.getPicList(map);

		}
		
		
//		PicDaoInterface picDao = new PicDaoImpl();
//		List<ImageInfo> picList = picDao.getPicList();
		
		request.getSession().setAttribute("piclist", picList);
		
		response.sendRedirect("showpic.jsp");
		
	}

}
