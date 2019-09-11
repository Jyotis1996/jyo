package com.uks.assignment1.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.assignment1.bean.LoginBean;
import com.uks.assignment1.bean.UserDataBean;
import com.uks.assignment1.logic.UserFetchLogic;;


public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserFetchLogic objUserFetchLogic;
	// Initializing the objects
	public UserDataBean objuser;
	public LoginBean objbean;
	// Define arraylist of UserDataBean class
	public List<UserDataBean> list,userList;


	//Constructor
	public UserLoginAction(){
		objUserFetchLogic = new UserFetchLogic();
	}
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
		System.out.println(objbean.getUsername());
		list = objUserFetchLogic.list();

		userList = objUserFetchLogic.fetchUser(objbean.getUsername());
		System.out.println(userList.get(0).getCategory());
		objbean.setCategory(userList.get(0).getCategory());
		return SUCCESS;
	}
}
