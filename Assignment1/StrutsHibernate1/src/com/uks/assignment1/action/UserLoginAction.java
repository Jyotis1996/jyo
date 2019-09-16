package com.uks.assignment1.action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.assignment1.bean.LoginBean;
import com.uks.assignment1.bean.UserDataBean;
import com.uks.assignment1.common.util.Constants;
import com.uks.assignment1.logic.LoginLogic;
import com.uks.assignment1.logic.UserFetchLogic;;
/**
 * UserLoginAction class to get username and password from jsp page and validate and perform further actions
 *
 * @author Jyoti Date-2019/09/13
 *
 */

public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserFetchLogic objUserFetchLogic;
	// Initializing the objects
	public UserDataBean objuser;
	public LoginBean objbean;
	public LoginLogic objlogin;
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

	/**
	 * execute method to check whether username and password are entered or not
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		if(objbean.getUsername().length() == 0 && objbean.getPassword().length() == 0){
			addActionError(Constants.BLANK_USERNAME_PASSWORD);
		} else if(objbean.getUsername().length() == 0 ) {
			addActionError(Constants.BLANK_USERNAME);
		} else if(objbean.getPassword().length() == 0) {
			addActionError(Constants.BLANK_PASSWORD);
		}else if(objlogin.validateUser(objbean.getUsername(), objbean.getPassword()) != null){
			addActionError(Constants.INVALID_CREDENTIALS);
		}else if(!(objbean.equals(null))){
			userList = objUserFetchLogic.fetchUser(objbean.getUsername());
			if(userList.get(0).getCategory().equals("admin")){
				list = objUserFetchLogic.list();
				objbean.setCategory(userList.get(0).getCategory());
				return SUCCESS;
			} else if(userList.get(0).getCategory().equals("user")){
				list = objUserFetchLogic.fetchUser(objbean.getUsername());
				objbean.setCategory(userList.get(0).getCategory());
				return SUCCESS;
			}
		}
		return "login";
	}
}
