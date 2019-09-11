package com.uks.assignment1.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.assignment1.action.UserDataAction;
import com.uks.assignment1.bean.LoginBean;
import com.uks.assignment1.bean.UserDataBean;
import com.uks.assignment1.logic.LoginLogic;;


public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Creating object
	UserDataAction objFetch = new UserDataAction();
	LoginLogic objLogic = new LoginLogic();
	// Initailizing the objects
	public UserDataBean objuser;
	public LoginBean objbean;
	// Define arraylist of UserDataBean class
	public ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

	// Getter and Setter method for UserDataBean and LoginBean
	public UserDataBean getObjuser() {
		return objuser;
	}

	public void setObjuser(UserDataBean objuser) {
		this.objuser = objuser;
	}

	public LoginBean getObjbean() {
		return objbean;
	}

	public void setObjbean(LoginBean objbean) {
		this.objbean = objbean;
	}


	// execute() is the default starting method to be execute first
	public String execute() {

		// checking username and password
		if (objbean.getPassword().length() == 0 && objbean.getUsername().length() == 0) {
			addActionError("Please Enter Username and password");
		} else if (objbean.getPassword().length() == 0) {
			addActionError("Password is required");
		} else if (objbean.getUsername().length() == 0) {
			addActionError("Username is required");
		} else if (!objbean.equals(null)) {

			String category;
			try {
				category = objLogic.validateUser(objbean);
				if (objbean.getCategory() != null) {
					if (category.equalsIgnoreCase("admin")) {
						// Calling the method of UserDataAction with parameter
						// of
						// username
						objuser = objFetch.fetchUserData(objbean.getUsername());
						// Returning the list of objects
						list = objFetch.fetchAllUserData();
						return "success";
					} else {
						// Calling the method of UserDataAction with parameter
						// of
						// username
						objuser = objFetch.fetchUserData(objbean.getUsername());
						// Returning the list of objects
						return "success";
					}

				} else {
					addActionError("Username and password is incorrect");
				}
			} catch (SQLException | IOException e) {
				// e.printStackTrace();
				return "error";
			}
			/*
			 * list = objFetch.fetchAllUserData(); return "success";
			 */
		}
		// return login if user unable to login into the system
		return "login";
	}
}
