package com.web.service;

import java.util.List;

import com.common.Model;
import com.web.entity.Menu;

public interface IMenuService {
	Menu getMenuByID(Integer menuAutoid);
	List<Menu> getAllMenu();
	List<Menu> getMenu(Integer isWeb);
	Model<Menu> getMenuByPage(int pageindex, int pagesize);
	Menu getMenuByModel(String model);

	/**在添加和编辑的时候判断是否已经存在该名称model
	 * @param model 
	 * @param menuAutoid menuAutoid为0时是添加，不为0时是编辑
	 * */
	boolean hasModel(String model, Integer menuAutoid);
	
	Menu create(Menu menu);
	int modify(Menu menu);
	int delete(Integer menuAutoid);
}
