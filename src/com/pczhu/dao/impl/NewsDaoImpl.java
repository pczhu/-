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
 * dbutils支持返回以下类型的结果：
 　　ArrayHandler ：将结果集中第一行的数据转化成对象数组。返回值类型：Object[]
　　 ArrayListHandler将结果集中所有的数据转化成List。返回值类型：List<Object[]>
 　　BeanHandler ：将Object中第一行的数据转化成类对象。返回值类型：T
 　　BeanListHandler ：将Object中所有的数据转化成List，List中存放的是类对象。返回值类型：List<T>
 　　ColumnListHandler ：将Object中某一列的数据存成List，List中存放的是 Object对象。返回值类型：List<Object>
 　　KeyedHandler ：将Object中存成映射，key为某一列对应为Map。Map中存放的是数据。Map<关键字字段值，map<列名,字段值>>返回值类型：Map<Object,Map<String,Object>>
 　　MapHandler ：将结果集中第一行的数据存成Map<列名,字段值>映射。返回值类型：Map<String,Object>
 　　MapListHandler ：将结果集中所有的数据存成List。List中存放的是Map<列名,字段值>。返回值类型：List<Map<String,Object>>
 　　ScalarHandler ：返回结果集中的第一行的指定列的一个值。返回值类型：Object
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
