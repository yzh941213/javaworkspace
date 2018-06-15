package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.web.dao.IMenuDao;
import com.web.entity.Menu;
import com.web.service.IMenuService;

public class MenuServiceImpl implements IMenuService {
	private IMenuDao menuDao;
	
	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public Menu create(Menu menu) {
		int result=menuDao.create(menu);
		if(result!=0){
			return getMenuByID(menu.getMenuAutoid());
		}
		return null;
	}

	public int delete(Integer menuAutoid) {
		return menuDao.delete(menuAutoid);
	}
	public List<Menu> getAllMenu(){
		return menuDao.getAllMenu();
	}
	public List<Menu> getMenu(Integer isWeb) {		
		return menuDao.getMenu(isWeb);
	}

	public Menu getMenuByID(Integer menuAutoid) {
		return menuDao.getMenuByID(menuAutoid);
	}

	public Menu getMenuByModel(String model){
		return menuDao.getMenuByModel(model);
	}
	public int modify(Menu menu) {
		return menuDao.modify(menu);
	}

	public Model<Menu> getMenuByPage(int pageindex, int pagesize) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<Menu> list=menuDao.getMenuByPage(map);
		int count=menuDao.getCount(map);
		Model<Menu> model=new Model<Menu>(list, count);
		return model;
	}

	public boolean hasModel(String model, Integer menuAutoid){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("model", model);
		map.put("menuAutoid", menuAutoid);
		Menu menu = menuDao.hasModel(map);
		if(menu!=null){
			return true;
		}else{
			return false;
		}
	}
}
