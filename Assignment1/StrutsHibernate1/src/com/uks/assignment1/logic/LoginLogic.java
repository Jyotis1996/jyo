package com.uks.assignment1.logic;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.uks.assignment1.common.util.DbMasterNames;
import com.uks.assignment1.common.util.HibernateUtil;
import com.uks.assignment1.bean.LoginBean;
import com.uks.assignment1.bean.UserDataBean;

/**
 * Login logic class to validate user
 *
 * @author Jyoti date-2019/09/13
 */

public class LoginLogic {

	LoginBean objbean = new LoginBean();

	// private String userId, userPassword;
	Session session = null;
	String returnResult = "";

	// This methods validate user is prasent in your system or not
	@SuppressWarnings("unchecked")
	public String validateUser(String Username, String Password) throws SQLException {

		HibernateUtil hbUtil = new HibernateUtil();
		Session session = hbUtil.getSession();
		session.beginTransaction();
		List<UserDataBean> items = null;
		try {

			items = (List<UserDataBean>) session
					.createQuery(
							"from " + DbMasterNames.ITEMS_MASTER + "where userid = :Username and password = :Password")
					.list();
			if (items.size() < 0) {
				return "failure";
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}
		return "success";

	}
}
