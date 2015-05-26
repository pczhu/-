package com.pczhu.servlet;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.UserBean;
import com.pczhu.service.LoginControl;
import com.sun.net.httpserver.HttpContext;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginControl loginControl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		loginControl = new LoginControl();
		if(username!=null && userpassword!=null){
			UserBean userinfo = loginControl.getUserInfo(username, userpassword);
			if(userinfo != null){
				request.getSession().removeAttribute("loginerror");
				request.getSession().setAttribute("logininfo", userinfo);
				response.sendRedirect("index.jsp");
			}else{
				request.getSession().setAttribute("loginerror", "登陆信息错误，请重新登陆");
				response.sendRedirect("login.jsp");
			}
			
		}
	}

}
