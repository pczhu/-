package com.pczhu.dao;

import java.util.List;

import com.pczhu.bean.UserBean;

public interface UserDaoInterface {

	public boolean register(UserBean user);

	public boolean checkVaildUser(String username,String userpassword);

	public UserBean getVaildUser(String username,String userpassword);
	
	public int delUser(String userid);
	
	public List<UserBean> showUserList();
}
