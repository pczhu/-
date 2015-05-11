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



public class NesFilter implements Filter {
	private FilterConfig config = null; 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		 this.config = arg0;
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		 // 强制类型转换  
        HttpServletRequest request = (HttpServletRequest) arg0;  
        HttpServletResponse response = (HttpServletResponse) arg1;  
        // 获取web.xm设置的编码集，设置到Request、Response中  
        request.setCharacterEncoding(config.getInitParameter("charset"));  
        response.setContentType(config.getInitParameter("contentType"));  
        response.setCharacterEncoding(config.getInitParameter("charset"));  
        // 将请求转发到目的地  
        
        checkuser(request,response);
        chain.doFilter(request, response);
	}
	
	private void checkuser(HttpServletRequest request, HttpServletResponse response) {
		 String currentPath = request.getRequestURI();
		 if("/ZhuNewsManager/register.jsp".equals(currentPath)){
/*			 if(){
				 
			 }else{
				 
			 }*/
		 }
		 System.out.println(currentPath);
	}
	@Override
	public void destroy() {
		
	}



	

}
