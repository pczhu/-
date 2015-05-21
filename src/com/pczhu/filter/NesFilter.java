package com.pczhu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.UserBean;
import com.pczhu.dao.DBPool;
import com.pczhu.dao.UserDaoInterface;
import com.pczhu.dao.impl.UserDaoImpl;



public class NesFilter implements Filter {
	private FilterConfig config = null; 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		 this.config = arg0;
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;  
        HttpServletResponse response = (HttpServletResponse) arg1;  
        request.setCharacterEncoding(config.getInitParameter("charset"));  
        response.setContentType(config.getInitParameter("contentType"));  
        response.setCharacterEncoding(config.getInitParameter("charset"));  
        
        if(checkuser(request,response)){
        	chain.doFilter(request, response);
        }else{
        	request.getSession().setAttribute("error", "权限错误");
        }
	}
	
	private boolean checkuser(HttpServletRequest request, HttpServletResponse response) {
		 String currentPath = request.getRequestURI();
		 if("/ZhuNewsManager/register.jsp".equals(currentPath)){
/*			 if(){
				 
			 }else{
				 
			 }*/
		 }

		 if("/ZhuNewsManager/addNews.jsp".equals(currentPath)){
			UserBean users = (UserBean) request.getSession().getAttribute("logininfo");
			if(users == null){
				return false;
			}
			String username = users.getUserName();
			String userpassword = users.getUserPassword();
			UserDaoInterface userDaoInterface = new UserDaoImpl();
			if(userDaoInterface.checkVaildUser(username, userpassword)){
				return true;
			}else{
				return false;
			}
		 }
		 System.out.println(currentPath);
		 return true;
	}
	@Override
	public void destroy() {
	}



	

}
