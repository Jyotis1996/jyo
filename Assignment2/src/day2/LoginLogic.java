package day2;

import java.sql.*;

import DatabaseConnection.DatabaseConnection;
import Common.Constants;

/**
 * LoginLogic class has a method validateUser() that will get userName and
 * Password as a perameter, these perameters will set at sql query and get data
 * accordingly
 *
 *@author Jyoti
 *2019/09/02
 */
public class LoginLogic {
	public static String userType = "";

	/**
	 * validateUser() will get conection by calling getConnection() of
	 * DatabasweConnection class and check userId and Password with database
	 * records and return status accordinly
	 *
	 * @param userId
	 * @param password
	 * @return validateStatus
	 */
	public boolean validateUser(String userId, String password) {
		ResultSet objResultSet = null;
		PreparedStatement objPreparedStatement = null;
		DatabaseConnection objConnection = null;
		Connection connect = null;
		boolean validateStatus = false;
		try {
			objConnection = new DatabaseConnection();
			// calling getConnection() to get databse connection
			connect = objConnection.getConnection();
			objPreparedStatement = connect
					.prepareStatement(Constants.SELECT_QUERY1);
			// passign userId and password to query string
			objPreparedStatement.setString(1, userId);
			objPreparedStatement.setString(2, password);
			objResultSet = objPreparedStatement.executeQuery();
			while (objResultSet.next()) {

				validateStatus = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// disconnetion the databse connection and releasing resourses
			if (objConnection.connection != null)
				objConnection.disconnectDB();
			objResultSet = null;
			objPreparedStatement = null;
			objConnection = null;
			connect = null;
		}
		return validateStatus;
	}
}
