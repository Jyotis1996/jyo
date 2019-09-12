package com.uks.assignment1.logic;
/**
 *
 */

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.uks.assignment1.common.util.DbMasterNames;
import com.uks.assignment1.common.util.HibernateUtil;
import com.uks.assignment1.bean.LoginBean;
import com.uks.assignment1.bean.UserDataBean;

public class LoginLogic {

	LoginBean objbean = new LoginBean();

	// private String userId, userPassword;
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

			items = (List<UserDataBean>) session.createQuery("from " + DbMasterNames.ITEMS_MASTER).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "success";

	}
}
