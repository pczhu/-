package com.pczhu.dao;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.NewsBean;

public interface NewsDaoInterface {

	public List<NewsBean> getNewsList(Map<String,String> tag);

	public int delNewsInfo(String id);

	public int addNewsInfo(NewsBean news);

	public List<NewsBean> getAllNewsInfo();
	
	public int updateNews(Map<String,String> tag,String newsid);
	
}
