package com.assignment1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.assignment1.Database.ConnectDB;
import com.assignment1.bean.UserListBean;


/**
 * Search logic to search data from userdetails table
 * @author Jyoti Date-2019/09/09
 *
 */
public class SearchLogic {

	public ArrayList<UserListBean> getList(String input) {

		Connection objConnection = null;
		ConnectDB objConnectDB = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		ArrayList<UserListBean> objArrayList = null;
		UserListBean objUserListBean = null;
		try {
			objArrayList = new ArrayList<>();
			objConnectDB = new ConnectDB();
			// call connect method for database connection
			objConnection = objConnectDB.connect();
			objStatement = objConnection.createStatement();
			objResultSet = objStatement.executeQuery(input);
			// Loop till resultSet has records
			while (objResultSet.next()) {
				// initialize the object of UserDataBean class
				objUserListBean = new UserListBean();
				// get data from Result set and set to the USerdatabean object
				objUserListBean.setUserName(objResultSet.getString(2));
				objUserListBean.setPassword(objResultSet.getString(3));
				objUserListBean.setSalutation(objResultSet.getString(4));
				objUserListBean.setFirstName(objResultSet.getString(5));
				objUserListBean.setMiddleInitial(objResultSet.getString(6));
				objUserListBean.setLastName(objResultSet.getString(7));
				objUserListBean.setGender(objResultSet.getString(8));
				objUserListBean.setEmail(objResultSet.getString(9));
				objUserListBean.setAddress(objResultSet.getString(11));
				objUserListBean.setCategory(objResultSet.getString(14));
				objArrayList.add(objUserListBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objArrayList;
	}
}
