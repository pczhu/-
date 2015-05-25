package com.pczhu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pczhu.bean.ImageInfo;
import com.pczhu.bean.NewsBean;
import com.pczhu.dao.DBPool;
import com.pczhu.dao.PicDaoInterface;

public class PicDaoImpl implements PicDaoInterface {
	Connection conn;
	private List<ImageInfo> imagelist;

	@Override
	public List<ImageInfo> getPicList(int i,int j) {

		conn = DBPool.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {

			imagelist = queryRunner.query(conn, "select * from picdata where checkok = 1 order by pid desc limit ?,? ",
					new BeanListHandler<ImageInfo>(ImageInfo.class),i,j);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return imagelist;
	}

	@Override
	public int delpic(String id) {
		conn = DBPool.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		int i = 0;
		try {

			i = queryRunner.update(conn, "delete from picdata where pid = ?",id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
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
	public int addpic(ImageInfo imageinfo) {

		
		conn = DBPool.getConnection();  
	    QueryRunner queryRunner = new QueryRunner();  
	    int i = 0;
		try {
			i = queryRunner.update(conn, "insert into picdata ("
					+ "uid,"
					+ "picname,"
					+ "picurl,"
					+ "width,"
					+ "height,"
					+ "checkok,"
					+ "pictime)"
					+ "values (?,?,?,?,?,?,?)",imageinfo.getUid(),imageinfo.getPicname(),imageinfo.getPicurl(),imageinfo.getWidth(),imageinfo.getHeight(),imageinfo.getCheckok(),imageinfo.getPictime());
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		}
		
		return i;
	
	}

	@Override
	public int checkshow(String id) {
		return 0;
	}


	@Override
	public int updateImage(String id, Map<String, String> map) {
	Iterator<String> iterator = map.keySet().iterator();
		
		int i = 0;
		conn = DBPool.getConnection();  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			while(iterator.hasNext()){
				String key = iterator.next();
				String value = map.get(key);
				i = queryRunner.update(conn,"update picdata set "+key+" = ? where pid = ?",value,id);
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
	public List<ImageInfo> getPicList() {

		conn = DBPool.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {

			imagelist = queryRunner.query(conn, "select * from picdata",new BeanListHandler<ImageInfo>(ImageInfo.class));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return imagelist;
	}

}
