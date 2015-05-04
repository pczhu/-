package com.pczhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.NewsBean;
import com.pczhu.service.NewsDataControl;

/**
 * Servlet implementation class AddNews
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private NewsDataControl newsdatacontrol;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		NewsBean news = receivedata(request,response);
		
		
		
		
		newsdatacontrol = new NewsDataControl();
		boolean flag = newsdatacontrol.addNews(news);
		if(!flag){
			response.sendRedirect("failed.jsp");
		}else{
			response.sendRedirect("welcome.jsp");
		}
	}

	private NewsBean receivedata(HttpServletRequest request,
			HttpServletResponse response) {
		
		String newstitle = request.getParameter("newstitle");
		String newsdesc = request.getParameter("newsdesc");
		String newscontent = request.getParameter("newscontent");
		String newsclassTag = request.getParameter("newsclasstag");
		String newswriter = request.getParameter("newswriter");
		String newsimgurl = request.getParameter("newsimgurl");
		String newscontentimgurl = request.getParameter("newscontentimgurl");
		String newsuserName = request.getParameter("newsusername");
		String userPassword = request.getParameter("userpassword");
		String newssource = request.getParameter("newssource");
		
		System.out.println(newstitle+":"+newsdesc+":"+newscontent+":"+newsclassTag+":"+newswriter+":"+newstitle+":"+newsimgurl+":"+newscontentimgurl+":"+newsuserName+":"+newssource+"userPassword");
		NewsBean news = new NewsBean();
		news.setNewscontent(newscontent);
		news.setNewstitle(newstitle);
		news.setClassTag(newsclassTag);
		news.setNewsuserName(newswriter);
		news.setNewsdesc(newsdesc);
		news.setNewswriter(newswriter);
		news.setNewssource(newssource);
		Date date = new Date();
		long l = date.getTime();
		news.setNewsdateTime(l+"");
		news.setNewscheckup(0);
		news.setNewsshow(0);
		news.setNewslight(0);
		news.setNewsimgurl(newsimgurl);
		news.setNewscontentimgurl(newscontentimgurl);
		news.setNewsuserName(newsuserName);
		return news;
	}

}
