/**
 *
 */
package com.uks.shubham.struts.day1.a1;

/**
 * @author Shubham
 *
 */
public class WelcomeAction {

	//Initializing username and message variables
	private String message;
	private String username;

	public WelcomeAction(){
	}

	//Strting method of the class
	public String execute() {
		setMessage("Hello " + getUsername());
		String str = getUsername();
		if(!str.isEmpty())
			return "success";
		else
			return "error";
	}

	//Getter and Setter methods
	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}
}
