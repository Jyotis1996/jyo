/**
 *
 */
package com.uks.assignment1.common.db_logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.uks.assignment1.common.util.Constants;

/**
 *
 * Common Database class and returing the connection object
 *
 */
public class DbLogic {

	Connection con = null;

	@SuppressWarnings("finally")
	public Connection connect(){
		try{


			ResourceBundle myBundle = ResourceBundle.getBundle("com.uks.jyoti.common.util.database");
			String URL = myBundle.getString(Constants.DB_URL);
			String Driver = myBundle.getString(Constants.DB_DriverName);
			String db_username = myBundle.getString(Constants.DB_username);
			String db_password = myBundle.getString(Constants.Db_password);

			//finding the class
			Class.forName(Driver);
			//establishmenting the connection
			con = DriverManager.getConnection(URL,db_username,db_password);
			System.out.println("Database Connecting.....");

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return con;
			//returing connection object
		}
	}

	//Disconneting the connection of database
	public void disconnect(){
		try {
			System.out.println("Database Disonnecting.....");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
