package com.pczhu.service;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.NewsBean;
import com.pczhu.dao.NewsDaoInterface;
import com.pczhu.dao.impl.NewsDaoImpl;

public class NewsDataControl {
	NewsDaoInterface newsdao = null;
	public NewsDataControl() {
		newsdao = new NewsDaoImpl();
	}
	
	public List<NewsBean> getNewsDataList(Map<String, String> mapkey){
		
		List<NewsBean> newsList = newsdao.getNewsList(mapkey);
		return newsList;
		
	}
	public boolean addNews(NewsBean news){
		if(newsdao.addNewsInfo(news) == 1){
			return true;
		}else{
			return false;
		}
	}
}
