package com.pczhu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.pczhu.bean.NewsBean;
import com.pczhu.bean.UserBean;
import com.pczhu.service.NewsDataControl;
import com.pczhu.utils.TimeUtils;

/**
 * Servlet implementation class ShowNews
 */
public class ShowNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<NewsBean> newslist;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowNews() {
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
		
		UserBean userbean = (UserBean) request.getSession().getAttribute("logininfo");
		NewsDataControl newsdatacontrol = new NewsDataControl();
		if(userbean.getUserPower()==2){
			newslist = newsdatacontrol.getAllNews();
		}else{
			Map<String, String> map = new HashMap<String,String>();
			map.put("newsUserID", userbean.getUserid()+"");
			newslist = newsdatacontrol.getNewsDataList(map);

		}
//		if(newslist!=null){
//			for (NewsBean newsBean : newslist) {
//				String date = newsBean.getNewsdateTime();
//				newsBean.setNewsdateTime(TimeUtils.getFormatTime("yyyy-MM-dd HH:mm:ss", new Date(date)));
//			}
//		}
		request.getSession().setAttribute("newslist", newslist);
		response.sendRedirect("shownews.jsp");
	}
}
