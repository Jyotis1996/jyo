package com.assignment1.struts.login.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.assignment1.struts.common.db_logic.DbLogic;
import com.assignment1.struts.login.bean.LoginBean;
import com.assignment1.struts.login.bean.UserDataBean;
import com.assignment1.struts.login.logic.UserLogic;

public class UserDataAction {

	//Initializing the objects
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	LoginBean objbean = new LoginBean();
	UserLogic objLogic = new UserLogic();

	public UserDataBean fetchUserData(String username) throws SQLException, IOException {

		UserDataBean objBean;
		//calling fetchUser method by passing usernmae as parameter
		objBean = objLogic.fetchUser(username);
		return objBean;
	}

	public ArrayList<UserDataBean> fetchAllUserData() throws SQLException{
		//Calling method that return the arraylist of objects
		ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();
		list = objLogic.fetchAllUsers();

		//returning list
		return list;
	}
}
