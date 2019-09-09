package day2;

import java.sql.*;
import java.util.*;

import DatabaseConnection.DatabaseConnection;
import Common.Constants;

/**
 * FetchUserDataAction class has fetchUserData() which will get data of all
 * users from the database and store it in List collection
 *
 * @author Jyoti date-2019/09/02
 *
 */
public class FetchUserDataAction {
	/**
	 * fetchUserData() will call getConnection() of DatabaseConnection class and
	 * make DB connection, than fatch all user's data and make list collection
	 * and at end it will return that list.
	 *
	 * @return userData
	 */
	public List<UserDataBean> fetchUserData(String userName, String password) {
		List<UserDataBean> userData = null;
		DatabaseConnection objConnection = null;
		Connection connect = null;
		Statement objStatement = null;
		ResultSet objResultSet = null;
		UserDataBean objUserDataBean = null;
		try {
			userData = new ArrayList<UserDataBean>();
			objConnection = new DatabaseConnection();
			objUserDataBean = new UserDataBean();
			// calling getConnection() to get databse connection
			connect = objConnection.getConnection();

			if (objUserDataBean.getUserId().equalsIgnoreCase(Constants.ADMIN)
					&& objUserDataBean.getPassword().equalsIgnoreCase(Constants.ADMIN)) {
				objStatement = connect.createStatement();
				objResultSet = objStatement.executeQuery(Constants.SELECT_QUERY);
				/*
				 * fetched all the records and store the object of UserDataBean
				 * in list collection with the use of getter and setter methods
				 */
				while (objResultSet.next()) {

					objUserDataBean = new UserDataBean();
					objUserDataBean.setUserId(objResultSet.getString("UserId"));
					objUserDataBean.setPassword(objResultSet.getString("Password"));
					objUserDataBean.setSalutation(objResultSet.getString("Salutation"));
					objUserDataBean.setFirstName(objResultSet.getString("FirstName"));
					objUserDataBean.setMiddleInitial(objResultSet.getString("MiddleInitial"));
					objUserDataBean.setLastName(objResultSet.getString("LastName"));
					objUserDataBean.setSex(objResultSet.getString("Sex"));
					objUserDataBean.setEmailID(objResultSet.getString("EmailId"));
					objUserDataBean.setBirthDate(objResultSet.getString("BirthDate"));
					objUserDataBean.setAddress(objResultSet.getString("Address"));
					objUserDataBean.setAreaOfInterest(objResultSet.getString("AreaOfInterest"));
					objUserDataBean.setOtherInterest(objResultSet.getString("OtherInterest"));
					userData.add(0, objUserDataBean);
				}
			} else {
				objStatement = connect.createStatement();
				objResultSet = objStatement.executeQuery(Constants.SELECT_QUERY);
				while (objResultSet.next()) {
					if (objResultSet.getString("UserId").equalsIgnoreCase(userName)
							&& objResultSet.getString("Password").equalsIgnoreCase(password)) {
						objUserDataBean = new UserDataBean();
						objUserDataBean.setUserId(objResultSet.getString("UserId"));
						objUserDataBean.setPassword(objResultSet.getString("Password"));
						objUserDataBean.setSalutation(objResultSet.getString("Salutation"));
						objUserDataBean.setFirstName(objResultSet.getString("FirstName"));
						objUserDataBean.setMiddleInitial(objResultSet.getString("MiddleInitial"));
						objUserDataBean.setLastName(objResultSet.getString("LastName"));
						objUserDataBean.setSex(objResultSet.getString("Sex"));
						objUserDataBean.setEmailID(objResultSet.getString("EmailId"));
						objUserDataBean.setBirthDate(objResultSet.getString("BirthDate"));
						objUserDataBean.setAddress(objResultSet.getString("Address"));
						objUserDataBean.setAreaOfInterest(objResultSet.getString("AreaOfInterest"));
						objUserDataBean.setOtherInterest(objResultSet.getString("OtherInterest"));
						userData.add(0, objUserDataBean);
					}

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// releasing resources
			objConnection = null;
			connect = null;
			objStatement = null;
			objResultSet = null;
			objUserDataBean = null;
		}
		return userData;
	}
}
