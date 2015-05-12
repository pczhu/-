package com.pczhu.service;

import com.pczhu.bean.UserBean;
import com.pczhu.dao.impl.UserDaoImpl;

public class RegisterControl {
	UserDaoImpl userdaoimpl = null;
	public RegisterControl() {
		userdaoimpl = new UserDaoImpl();
	}
	public boolean register(UserBean user) {
		boolean flag = userdaoimpl.register(user);
		return flag;
	}

	public boolean checkVaildUser(String username, String userpassword) {
		boolean flag = userdaoimpl.checkVaildUser(username, userpassword);
		return flag;
	}

	public UserBean getVaildUser(String username, String userpasword) {
		UserBean userbean = userdaoimpl.getVaildUser(username, userpasword);
		return userbean;
	}
}
