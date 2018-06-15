package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Menu;

public interface IMenuDao {
	Menu getMenuByID(Integer menuAutoid);
	List<Menu> getAllMenu();
	List<Menu> getMenu(Integer isWeb);
	Menu getMenuByModel(String model);
	List<Menu> getMenuByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	
	/**在添加和编辑的时候判断是否已经存在该名称model*/
	Menu hasModel(Map<String, Object> map);
	int create(Menu menu);
	int modify(Menu menu);
	int delete(Integer menuAutoid);
}
