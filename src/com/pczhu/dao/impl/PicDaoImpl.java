package com.pczhu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pczhu.bean.ImageInfo;
import com.pczhu.bean.NewsBean;
import com.pczhu.dao.DBPool;

public class PicDaoImpl implements PicDaoInterface {
	Connection conn;
	private List<ImageInfo> imagelist;

	@Override
	public List<ImageInfo> getPicList(int i,int j) {

		conn = DBPool.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {

			imagelist = queryRunner.query(conn, "select * from picdata",
					new BeanListHandler<ImageInfo>(ImageInfo.class));

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
	public int delpic(int id) {
		return 0;
	}

	@Override
	public int addpic(ImageInfo imageinfo) {
		return 0;
	}

	@Override
	public int checkshow(int id) {
		return 0;
	}


	@Override
	public int updateImage(int id, Map<String, String> map) {
		
		return 0;
	}

}
