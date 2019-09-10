package com.uks.shubham.struts.day2.a1.logic;
/**
 *
 */

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.uks.shubham.struts.common.util.DbMasterNames;
import com.uks.shubham.struts.common.util.HibernateUtil;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * @author Shubham
 *
 */
public class LoginLogic{
	/**
	 * This class is using for the Login logic
	 */
	/**
	 * DbLogic objDbLogic = new DbLogic(); Connection con = null;
	 */
	LoginBean objbean = new LoginBean();

	//private String userId, userPassword;
	Session session = null;
	String returnResult = "";

	// This methods validate user is prasent in your system or not
	@SuppressWarnings("unchecked")
	public String validateUser(LoginBean objbean) throws SQLException {

		HibernateUtil hbUtil = new HibernateUtil();
		Session session = hbUtil.getSession();
		session.beginTransaction();
		@SuppressWarnings("unused")
		List<UserDataBean> items = null;
		try {

			//items = (List<ItemMaster>)session.createQuery("from ItemMaster").list();
			items = (List<UserDataBean>)session.createQuery("from "+ DbMasterNames.ITEMS_MASTER ).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "success";

		// String category = null;
		/*
		 * try { con = objDbLogic.connect(); Statement stmt =
		 * con.createStatement(); //Executing the query ResultSet rs =
		 * stmt.executeQuery(
		 * "SELECT * FROM northwind_shubam.userdetails where userid = '" +
		 * objbean.getUsername() + "' and password ='" + objbean.getPassword() +
		 * "'"); //checks records available or not if (rs.next()) {
		 * objbean.setCategory(rs.getString(14)); return objbean.getCategory();
		 * } else { return objbean.getCategory(); }
		 *
		 * } catch (Exception e) { e.printStackTrace(); } finally {
		 * //discooneting the connection objDbLogic.disconnect(); }
		 */

		// returning the boolean
		//return objbean.getCategory();
	}
}
