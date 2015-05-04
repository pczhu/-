package com.pczhu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pczhu.bean.NewsBean;
import com.pczhu.dao.DBPool;
import com.pczhu.dao.NewsDaoInterface;
/*
 * dbutils֧�ַ����������͵Ľ����
 ����ArrayHandler ����������е�һ�е�����ת���ɶ������顣����ֵ���ͣ�Object[]
���� ArrayListHandler������������е�����ת����List������ֵ���ͣ�List<Object[]>
 ����BeanHandler ����Object�е�һ�е�����ת��������󡣷���ֵ���ͣ�T
 ����BeanListHandler ����Object�����е�����ת����List��List�д�ŵ�������󡣷���ֵ���ͣ�List<T>
 ����ColumnListHandler ����Object��ĳһ�е����ݴ��List��List�д�ŵ��� Object���󡣷���ֵ���ͣ�List<Object>
 ����KeyedHandler ����Object�д��ӳ�䣬keyΪĳһ�ж�ӦΪMap��Map�д�ŵ������ݡ�Map<�ؼ����ֶ�ֵ��map<����,�ֶ�ֵ>>����ֵ���ͣ�Map<Object,Map<String,Object>>
 ����MapHandler ����������е�һ�е����ݴ��Map<����,�ֶ�ֵ>ӳ�䡣����ֵ���ͣ�Map<String,Object>
 ����MapListHandler ��������������е����ݴ��List��List�д�ŵ���Map<����,�ֶ�ֵ>������ֵ���ͣ�List<Map<String,Object>>
 ����ScalarHandler �����ؽ�����еĵ�һ�е�ָ���е�һ��ֵ������ֵ���ͣ�Object
 * @see com.pczhu.dao.NewsDaoInterface#getNewsList(java.util.Map)
 */
public class NewsDaoImpl implements NewsDaoInterface {

    
	private Connection conn;

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsBean> getNewsList(Map<String, String> tag) {
		List<NewsBean> beanListResult = null;
		conn = DBPool.getConnection();  
		  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			beanListResult = queryRunner.query(conn,"select * from newsinfodata", new BeanListHandler<NewsBean>(NewsBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		return beanListResult;
	}

	@Override
	public void delNewsInfo(int id) {

	}

	@Override
	public int addNewsInfo(NewsBean news) {
		conn = DBPool.getConnection();
		QueryRunner queryRunner = new QueryRunner(); 
		int i = 0;
		try {
			//queryRunner.in
			i = queryRunner.update(conn, "insert into newsinfodata ("
					+ "newscontent,"
					+ "newstitle,"
					+ "classTag,"
					+ "newsuserName,"
					+ "newsdesc,"
					+ "newswriter,"
					+ "newssource,"
					+ "newsdateTime,"
					+ "newscheckup,"
					+ "newsshow,"
					+ "newslight,"
					+ "newsimgurl,"
					+ "newscontentimgurl,"
					+ "newshints) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
					news.getNewscontent(),
					news.getNewstitle(),
					news.getClassTag(),
					news.getNewsuserName(),
					news.getNewsdesc(),
					news.getNewswriter(),
					news.getNewssource(),
					news.getNewsdateTime(),
					news.getNewscheckup(),
					news.getNewsshow(),
					news.getNewslight(),
					news.getNewsimgurl(),
					news.getNewscontentimgurl(),
					0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public void updateNews(int id, NewsBean bean) {
		
	}



}
