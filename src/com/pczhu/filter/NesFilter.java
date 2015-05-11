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
		 // ǿ������ת��  
        HttpServletRequest request = (HttpServletRequest) arg0;  
        HttpServletResponse response = (HttpServletResponse) arg1;  
        // ��ȡweb.xm���õı��뼯�����õ�Request��Response��  
        request.setCharacterEncoding(config.getInitParameter("charset"));  
        response.setContentType(config.getInitParameter("contentType"));  
        response.setCharacterEncoding(config.getInitParameter("charset"));  
        // ������ת����Ŀ�ĵ�  
        
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
