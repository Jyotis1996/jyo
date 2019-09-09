package day2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

/**
 * LoginBean class has getter and setter methods for username and password
 *
 * @param userName
 * @param password
 *
 * @author Jyoti
 * Date-2019/09/02
 */
public class LoginBean extends ActionForm {
	private static final long serialVersionUID = 6385064633875823282L;
	private String userName = null;
	private String password = null;

	// LoginBean's default constructor
	public LoginBean() {
	}

	/*
	 * getUserName() will get userName from Login.jsp page
	 */
	public String getUserName() {
		return userName;
	}

	/*
	 * setUserName() will set password as user enterd value
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * getPassword() will get password from Login.jsp page
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * setUserName() will set UserName as user enterd value
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * override the method "reset" in form bean. "reset" method is called at the
	 * end of the every request processed by the struts. In reset method we have
	 * set the value of password as null which means every time the user will
	 * open the login jsp in browser it will show the last entered username and
	 * reset the password field.
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.password = null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (userName == null || userName.length() < 1) {
			errors.add("err_username", new ActionMessage("error.userName.required"));
		}
		if (password == null || password.length() < 1) {
			errors.add("err_passsword", new ActionMessage("error.password.required"));
		}
		return errors;
	}

}
