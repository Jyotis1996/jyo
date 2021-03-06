/**
 *
 */
package common.db_logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import common.util.Constants;

/**
 * Common Database class and returing the connection object
 * @author Jyoti Date-2019/09/04
 *
 */
public class DbLogic {

	Connection con = null;

	@SuppressWarnings("finally")
	public Connection connect() {
		try {

			// Passing the property file location

			ResourceBundle myBundle = ResourceBundle.getBundle(Constants.PATH);
			String URL = myBundle.getString(Constants.DB_URL);
			String Driver = myBundle.getString(Constants.DB_DriverName);
			String db_username = myBundle.getString(Constants.DB_username);
			String db_password = myBundle.getString(Constants.Db_password);

			// finding the class
			Class.forName(Driver);
			con = DriverManager.getConnection(URL, db_username, db_password);
			System.out.println(Constants.CONNECTION);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return con;
			// returing connection object
		}
	}

	// Disconneting the connection of database
	public void disconnect() {
		try {
			System.out.println(Constants.DISCONNECTION);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
