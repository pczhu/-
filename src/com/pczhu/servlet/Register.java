package com.pczhu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.UserBean;
import com.pczhu.service.RegisterControl;
import com.pczhu.utils.MD5Utils;
import com.pczhu.utils.TimeUtils;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
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
		String reuserpassword = request.getParameter("userrepassword");
		if(username !=null && userpassword != null && reuserpassword != null && userpassword.equals(reuserpassword)){
			UserBean userbean = new UserBean();
			userbean.setUserName(username);
			userbean.setRegisterTime(TimeUtils.getFormatTime("yyyy-MM-dd HH-mm-ss"));
			userbean.setUserPassword(userpassword);
			userbean.setUserPower(1);
			userbean.setUuid(MD5Utils.toMD5(userbean.getUserName()+userbean.getRegisterTime()));
			RegisterControl registerControl = new RegisterControl();
			boolean result = registerControl.register(userbean);
			if(result){
				response.sendRedirect("success.jsp");
			}
		}else{
			
		}
		
	}

}
