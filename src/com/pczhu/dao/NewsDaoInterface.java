package com.pczhu.dao;

import java.util.List;
import java.util.Map;

import com.pczhu.bean.NewsBean;

public interface NewsDaoInterface {
	/**
	 * ��ȡ�����б�
	 * @param tag  Map ��������
	 * @return
	 */
	public List<NewsBean> getNewsList(Map<String,String> tag);
	/**
	 * ɾ������
	 * @param id ����ID
	 */
	public void delNewsInfo(int id);
	/**
	 * �����������
	 * @param news
	 */
	public int addNewsInfo(NewsBean news);
	/**
	 * ������������
	 * @param id
	 * @param bean
	 */
	public void updateNews(int id,NewsBean bean);
}
