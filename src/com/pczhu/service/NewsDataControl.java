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
	public List<NewsBean> getAllNews(){
		return newsdao.getAllNewsInfo("0",false);
		
	}
	public List<NewsBean> getAllNews(int i,int j,String tag){
		if(j != 0){
			System.out.println("抓分页");
			return newsdao.getAllNewsInfo(i,j,tag,true);
		}else{
			System.out.println("抓全部");
			return newsdao.getAllNewsInfo(tag,true);
		}
		
	}
	public int deleteNews(String id){
		return newsdao.delNewsInfo(id);
	}
	public int canshow(Map<String,String> tag,String newsid){
		return newsdao.updateNews(tag, newsid);
	}
}
