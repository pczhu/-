package com.pczhu.service;

import java.util.List;

import com.pczhu.bean.UserBean;
import com.pczhu.dao.UserDaoInterface;
import com.pczhu.dao.impl.UserDaoImpl;

public class UserControl {
	UserDaoInterface userDaoInterface;
	public UserControl() {
		userDaoInterface = new UserDaoImpl();
	}
	public List<UserBean> getUserList(){
		return userDaoInterface.showUserList();
	}
	public int delUser(String userid){
		return userDaoInterface.delUser(userid);
	}

}
