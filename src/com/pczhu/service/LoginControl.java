package com.pczhu.service;

import com.pczhu.bean.UserBean;
import com.pczhu.dao.UserDaoInterface;
import com.pczhu.dao.impl.UserDaoImpl;


public class LoginControl {
	UserDaoInterface userDaoInterface;
	public LoginControl() {
		userDaoInterface = new UserDaoImpl();
	}
	public boolean loginChecked(String username,String password){
		
		return userDaoInterface.checkVaildUser(username, password);
	}
	public UserBean getUserInfo(String username,String password){
		return userDaoInterface.getVaildUser(username, password);
	}

}
