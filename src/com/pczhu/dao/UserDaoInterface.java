package com.pczhu.dao;

import com.pczhu.bean.UserBean;

public interface UserDaoInterface {
	public boolean register(UserBean user);
	public boolean checkVaildUser(String username,String userpassword);
	public UserBean getVaildUser(String username,String userpasword);
}
