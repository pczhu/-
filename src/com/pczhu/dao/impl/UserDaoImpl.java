package com.pczhu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pczhu.bean.NewsBean;
import com.pczhu.bean.UserBean;
import com.pczhu.dao.DBPool;
import com.pczhu.dao.UserDaoInterface;

public class UserDaoImpl implements UserDaoInterface {
	private Connection conn;
	@Override
	public boolean register(UserBean user) {
		conn = DBPool.getConnection();  
//		userid	int(8)			��		auto_increment	 Browse distinct values	 ����	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		userName	varchar(64)	utf8_general_ci		��			 Browse distinct values	 ����	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		userPassword	varchar(200)	utf8_general_ci		��			 Browse distinct values	 ����	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		registerTime	varchar(12)	utf8_general_ci		��			 Browse distinct values	 ����	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		uuid	varchar(64)	utf8_general_ci		��			 Browse distinct values	 ����	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		userPower
	    QueryRunner queryRunner = new QueryRunner();  
	    int i = 0;
		try {
			i = queryRunner.update(conn, "insert into users ("
					+ "userName,"
					+ "userPassword,"
					+ "registerTime,"
					+ "uuid,"
					+ "userPower)"
					+ "values (?,?,?,?,?)",user.getUserName(),user.getUserPassword(),user.getRegisterTime(),user.getUuid(),user.getUserPower());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i == 0 ? false:true;
	}

	@Override
	public boolean checkVaildUser(String username, String userpassword) {
		return false;
	}

	@Override
	public UserBean getVaildUser(String username, String userpasword) {
		return null;
	}

}
