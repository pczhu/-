package com.pczhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pczhu.bean.NewsBean;
import com.pczhu.bean.UserBean;
import com.pczhu.dao.UserDaoInterface;
import com.pczhu.dao.impl.UserDaoImpl;
import com.pczhu.service.NewsDataControl;
import com.pczhu.utils.TimeUtils;

/**
 * Servlet implementation class AddNews
 */
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private NewsDataControl newsdatacontrol;
	private boolean flag;
	private UserBean userbean;
       
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
		
		
		
		newsdatacontrol = new NewsDataControl();
		
		String username = request.getParameter("newsusername");
		String userpassword = request.getParameter("userpassword");
		UserDaoInterface userDaoInterface = new UserDaoImpl();
		userbean = userDaoInterface.getVaildUser(username, userpassword);
		NewsBean news = receivedata(request,response);
		if(userbean!=null){
			flag = newsdatacontrol.addNews(news);
			
		}else{
			flag = false;
		}
		
		
		if(!flag){
			response.sendRedirect("failed.jsp");
		}else{
			response.sendRedirect("success.jsp");
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
		String newsuserid = userbean.getUserid()+"";
		System.out.println(newstitle+":"+newsdesc+":"+newscontent+":"+newsclassTag+":"+newswriter+":"+newstitle+":"+newsimgurl+":"+newscontentimgurl+":"+newsuserName+":"+newssource+"userPassword");
		NewsBean news = new NewsBean();
		news.setNewscontent(newscontent);
		news.setNewstitle(newstitle);
		news.setClassTag(newsclassTag);
		news.setNewsuserName(newswriter);
		news.setNewsdesc(newsdesc);
		news.setNewswriter(newswriter);
		news.setNewssource(newssource);
		news.setNewsdateTime(TimeUtils.getFormatTime("yyyy-MM-dd HH:mm:ss"));
		news.setNewscheckup(0);
		news.setNewsshow(0);
		news.setNewslight(0);
		news.setNewsimgurl(newsimgurl);
		news.setNewscontentimgurl(newscontentimgurl);
		news.setNewsuserName(newsuserName);
		news.setNewsUserID(newsuserid);
		return news;
	}

}
