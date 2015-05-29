package com.pczhu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pczhu.bean.NewsBean;
import com.pczhu.dao.DBPool;
import com.pczhu.dao.NewsDaoInterface;
/*
 * dbutils֧�ַ����������͵Ľ��
 ����ArrayHandler ��������е�һ�е����ת���ɶ������顣����ֵ���ͣ�Object[]
���� ArrayListHandler����������е����ת����List������ֵ���ͣ�List<Object[]>
 ����BeanHandler ����Object�е�һ�е����ת��������󡣷���ֵ���ͣ�T
 ����BeanListHandler ����Object�����е����ת����List��List�д�ŵ�������󡣷���ֵ���ͣ�List<T>
 ����ColumnListHandler ����Object��ĳһ�е���ݴ��List��List�д�ŵ��� Object���󡣷���ֵ���ͣ�List<Object>
 ����KeyedHandler ����Object�д��ӳ�䣬keyΪĳһ�ж�ӦΪMap��Map�д�ŵ�����ݡ�Map<�ؼ����ֶ�ֵ��map<����,�ֶ�ֵ>>����ֵ���ͣ�Map<Object,Map<String,Object>>
 ����MapHandler ��������е�һ�е���ݴ��Map<����,�ֶ�ֵ>ӳ�䡣����ֵ���ͣ�Map<String,Object>
 ����MapListHandler ������������е���ݴ��List��List�д�ŵ���Map<����,�ֶ�ֵ>������ֵ���ͣ�List<Map<String,Object>>
 ����ScalarHandler �����ؽ���еĵ�һ�е�ָ���е�һ��ֵ������ֵ���ͣ�Object
 * @see com.pczhu.dao.NewsDaoInterface#getNewsList(java.util.Map)
 */
public class NewsDaoImpl implements NewsDaoInterface {

    
	private Connection conn;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<NewsBean> getNewsList(Map<String, String> tag) {
		Iterator<String> iterator = tag.keySet().iterator();
//		String value = tag.get(key);
		List<NewsBean> beanListResult = null;
		conn = DBPool.getConnection();  
		  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
				while(iterator.hasNext()){
					String key = iterator.next();
					String value = tag.get(key);
					beanListResult = queryRunner.query(conn,"select * from newsinfodata where "+key+" = ? order by newsID desc", new BeanListHandler<NewsBean>(NewsBean.class),value);
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return beanListResult;
	}

	@Override
	public int delNewsInfo(String id) {
		int i = 0;
		conn = DBPool.getConnection();  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			i = queryRunner.update(conn,"delete from newsinfodata where newsid = ?", id);
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
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
					+ "newsUserID,"
					+ "newsType,"
					+ "newshints) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
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
					news.getNewsUserID(),
					news.getNewsType(),
					0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}



	@Override
	public List<NewsBean> getAllNewsInfo(String tag,boolean isShown) {
		List<NewsBean> allbeanListResult = null;
		conn = DBPool.getConnection();  
		 System.out.println("抓全部开始");
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			if("0".equals(tag)){
				if(isShown){
					
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata where newsshow = 1 order by newsID desc", new BeanListHandler<NewsBean>(NewsBean.class));
				}else{
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata order by newsID desc", new BeanListHandler<NewsBean>(NewsBean.class));
					
				}
			}else{
				if(isShown){
					
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata where classTag = ? and newsshow = 1 order by newsID desc", new BeanListHandler<NewsBean>(NewsBean.class),tag);
				}else{
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata where classTag = ? order by newsID desc", new BeanListHandler<NewsBean>(NewsBean.class),tag);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 System.out.println("抓全部完毕");
		return allbeanListResult;
	}

	@Override
	public int updateNews(Map<String, String> tag, String newsid) {
		Iterator<String> iterator = tag.keySet().iterator();
		
		int i = 0;
		conn = DBPool.getConnection();  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			while(iterator.hasNext()){
				String key = iterator.next();
				String value = tag.get(key);
				i = queryRunner.update(conn,"update newsinfodata set "+key+" = ? where newsid = ?",value,newsid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public List<NewsBean> getAllNewsInfo(int i, int j,String tag,boolean isShown) {
		 System.out.println("抓分页开始");
		List<NewsBean> allbeanListResult = null;
		conn = DBPool.getConnection();  
		  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			if("0".equals(tag)){
				if(isShown){
					
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata where newsshow = 1 order by newsID desc limit ?,? ", new BeanListHandler<NewsBean>(NewsBean.class),i,j);
				}else{
					
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata order by newsID desc limit ?,? ", new BeanListHandler<NewsBean>(NewsBean.class),i,j);
				}
			}else{
				if(isShown){
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata where classTag = ? and  newsshow = 1 order by newsID desc limit ?,? ", new BeanListHandler<NewsBean>(NewsBean.class),tag,i,j);
					
				}else{
					allbeanListResult = queryRunner.query(conn,"select * from newsinfodata where classTag = ? order by newsID desc limit ?,? ", new BeanListHandler<NewsBean>(NewsBean.class),tag,i,j);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("抓分页完毕");
		return allbeanListResult;
	}

	@Override
	public NewsBean getNewsInfo(String id) {
		conn = DBPool.getConnection();  
		NewsBean newsbean = null;
	    QueryRunner queryRunner = new QueryRunner();  
		try {
				
			newsbean = queryRunner.query(conn,"select * from newsinfodata where newsid = ?", new BeanHandler<NewsBean>(NewsBean.class),id);
				
			} catch (SQLException e) {
				e.printStackTrace();
		}finally{
			try {
				if(conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return newsbean;
	}




}
