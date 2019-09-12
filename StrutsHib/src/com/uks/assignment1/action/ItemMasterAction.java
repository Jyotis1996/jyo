/**
 *
 */
package com.uks.assignment1.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.uks.assignment1.bean.ItemMaster;
import com.uks.assignment1.bean.UserDataBean;
import com.uks.assignment1.logic.UserFetchLogic;

/**
 *
 */
public class ItemMasterAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ItemMaster item;
	private List<UserDataBean> itemList;
	private Long id;
	private UserFetchLogic itemMasterDao;

	public ItemMaster getItem() {
		return item;
	}

	public void setItem(ItemMaster item) {
		this.item = item;
	}

	public ItemMasterAction() {
		itemMasterDao = new UserFetchLogic();
	}

	public String execute() {
		this.itemList = itemMasterDao.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getItem());
		try {
			ItemMaster item = getItem();
			item.setCreatedOn(new java.util.Date());
			// for current date to store on createdOn field.
			itemMasterDao.add(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.itemList = itemMasterDao.list();
		return SUCCESS;
	}

	public String list() {
		this.itemList = itemMasterDao.list();
		return SUCCESS;
	}

	public String delete() {
		itemMasterDao.delete(getId());
		return SUCCESS;
	}

	public List<UserDataBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<UserDataBean> itemList) {
		this.itemList = itemList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
