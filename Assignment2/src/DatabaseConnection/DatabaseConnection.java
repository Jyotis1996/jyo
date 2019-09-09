package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DatabaseConnection class has a getConnection() which returns the connection
 * object after creating database connection. It has another method
 * disconnectDB() that will break database connection
 *
 *
 * @param connectoin
 *            - Database Conection object
 *
 * @author Jyoti
 * Date-2019/09/02
 */
public class DatabaseConnection {
	public Connection connection = null;

	/**
	 * getConnection() will create connectoin and will return it.
	 *
	 * @return connection
	 */
	public Connection getConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://172.16.1.15:3306/northwind_jyoti?useSSL=false",
					"jyoti", "jyoti@741");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		/*
		 * return databse connection
		 */
		return connection;
	}

	/**
	 * disconnectDB() will break connectoin with database.
	 */
	public void disconnectDB() {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			connection = null;
		}
	}
}
