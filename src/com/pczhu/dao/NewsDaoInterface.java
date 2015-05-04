package com.pczhu.dao;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.NewsBean;

public interface NewsDaoInterface {
	/**
	 * 获取新闻列表
	 * @param tag  Map 条件集合
	 * @return
	 */
	public List<NewsBean> getNewsList(Map<String,String> tag);
	/**
	 * 删除新闻
	 * @param id 新闻ID
	 */
	public void delNewsInfo(int id);
	/**
	 * 添加新闻内容
	 * @param news
	 */
	public int addNewsInfo(NewsBean news);
	/**
	 * 更新新闻内容
	 * @param id
	 * @param bean
	 */
	public void updateNews(int id,NewsBean bean);
}
