package com.pczhu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pczhu.bean.NewsBean;
import com.pczhu.bean.UserBean;
import com.pczhu.dao.DBPool;
import com.pczhu.dao.UserDaoInterface;


public class UserDaoImpl implements UserDaoInterface {
	private Connection conn;
	@Override
	public boolean register(UserBean user) {
		if(getOneWord(user.getUserName()) == -1){
			return false;
		}
		
		conn = DBPool.getConnection();  
//		userid	int(8)			��		auto_increment	 Browse distinct values	 ���	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		userName	varchar(64)	utf8_general_ci		��			 Browse distinct values	 ���	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		userPassword	varchar(200)	utf8_general_ci		��			 Browse distinct values	 ���	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		registerTime	varchar(12)	utf8_general_ci		��			 Browse distinct values	 ���	 ɾ��	 ����	 Ψһ	 ����	ȫ������
//		uuid	varchar(64)	utf8_general_ci		��			 Browse distinct values	 ���	 ɾ��	 ����	 Ψһ	 ����	ȫ������
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
			return false;
		}
		
		return i == 0 ? false:true;
	}

	@Override
	public boolean checkVaildUser(String username, String userpassword) {
		conn = DBPool.getConnection();  
		  
	    QueryRunner queryRunner = new QueryRunner();
	    UserBean userbean = null;
	    try {
			userbean = queryRunner.query(conn, "select * from users where userName = ? and userPassword = ?", new BeanHandler<UserBean>(UserBean.class), username,userpassword);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	    if(userbean != null){
	    	return true;
	    }else{
	    	return false;
	    }
		
	}

	@SuppressWarnings("finally")
	@Override
	public UserBean getVaildUser(String username, String userpassword) {
		conn = DBPool.getConnection();  
		  
	    QueryRunner queryRunner = new QueryRunner();
	    UserBean userbean = null;
	    try {
			userbean = queryRunner.query(conn, "select * from users where userName = ? and userPassword = ?", new BeanHandler<UserBean>(UserBean.class), username,userpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return userbean;
		}
	}

	@Override
	public int delUser(String userid) {
		int i = 0;
		conn = DBPool.getConnection();  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			i = queryRunner.update(conn,"delete from users where userid = ?", userid);
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}

	@Override
	public List<UserBean> showUserList() {
		List<UserBean> allbeanListResult = null;
		conn = DBPool.getConnection();  
		  
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			allbeanListResult = queryRunner.query(conn,"select * from users", new BeanListHandler<UserBean>(UserBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allbeanListResult;
	}
	public int getOneWord(String name){
		conn = DBPool.getConnection();  
		NewsBean newbean = null;
	    QueryRunner queryRunner = new QueryRunner();  
		try {
			newbean = queryRunner.query(conn,"select * from newsinfodata where userName = ?", new BeanHandler<NewsBean>(NewsBean.class),name);
	
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
		 if(newbean != null){
			 return -1;
		 }
		return 0;
	}

}
