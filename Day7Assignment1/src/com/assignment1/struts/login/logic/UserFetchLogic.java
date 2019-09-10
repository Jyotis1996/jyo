/**
 *
 */
package com.assignment1.struts.login.logic;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.assignment1.struts.common.util.DbMasterNames;
import com.assignment1.struts.common.util.HibernateUtil;
import com.assignment1.struts.login.bean.ItemMaster;
import com.assignment1.struts.login.bean.UserDataBean;


public class UserFetchLogic {

	UserDataBean objuser = new UserDataBean();
	HibernateUtil hbUtil = new HibernateUtil();
	// For adding items in the Items table.
	public ItemMaster add(ItemMaster item) {
		Session session = hbUtil.getSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		return item;
	}

	// For deleting item from Items table.
	public ItemMaster delete(Long id) {
		Session session = hbUtil.getSession();
		session.beginTransaction();
		ItemMaster item = (ItemMaster) session.load(ItemMaster.class, id);
		if (null != item) {
			session.delete(item);
		}
		session.getTransaction().commit();
		return item;
	}
	// For generating , executing hibernate select query and returns items as a
	// list.

	@SuppressWarnings("unchecked")
	public List<UserDataBean> list() {

		Session session = hbUtil.getSession();
		session.beginTransaction();
		List<UserDataBean> items = null;
		try {
			items = (List<UserDataBean>) session.createQuery("from "+ DbMasterNames.ITEMS_MASTER ).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	@SuppressWarnings("unchecked")
	public List<UserDataBean> fetchUser(String userid){
		Session session = hbUtil.getSession();
		session.beginTransaction();
		List<UserDataBean> items = null;
		try {
			items =  (List<UserDataBean>) session.createQuery("from "+DbMasterNames.ITEMS_MASTER + " where userid = :userid").setParameter("userid", userid).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}
}
