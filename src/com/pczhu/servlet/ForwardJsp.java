package com.pczhu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.pczhu.bean.NewsBean;
import com.pczhu.service.NewsDataControl;

/**
 * Servlet implementation class ForwardJsp
 */
public class ForwardJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardJsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = "/WEB-INF/"+request.getParameter("target");
		if("newsinfo.jsp".equals(request.getParameter("target"))){
			String id = request.getParameter("newsbean");
			if(null != id && !"".equals(id)){
				NewsDataControl newscontrol = new NewsDataControl();
				NewsBean newsInfo = newscontrol.getNewsInfo(id);
				
				request.getSession().setAttribute("newsbeandetail", newsInfo);
			}else{
				request.getSession().setAttribute("newsbeandetail", null);
			}
		}
		request.getSession().removeAttribute("addnewsresult");
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
