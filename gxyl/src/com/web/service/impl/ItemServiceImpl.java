package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.web.dao.IItemDao;
import com.web.entity.Item;
import com.web.service.IItemService;

public class ItemServiceImpl implements IItemService {

	private IItemDao itemDao;
	
	public void setItemDao(IItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	public Item getItemByID(Integer itemAutoid){
		return itemDao.getItemByID(itemAutoid);
	}

	public Model<Map<String, Object>> getItemMapByPage(int pageindex, int pagesize, Integer personAutoid, int autoid, int parentID, String del) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("personAutoid", personAutoid);
		map.put("autoid", autoid);
		map.put("parentID", parentID);
		map.put("del", del);
		List<Map<String, Object>> list=itemDao.getItemMapByPage(map);
		int count=itemDao.getCount(map);
		Model<Map<String, Object>> model=new Model<Map<String,Object>>(list, count);
		return model;
	}

	public List<Item> getItemByFlow(Integer flowAutoid, String del) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("flowAutoid", flowAutoid);
		map.put("del", del);
		return itemDao.getItemByFlow(map);
	}

	public Model<Item> getItemsByFlow(int flowAutoid,
			int pageindex, int pagesize) {
		pageindex=(pageindex-1)*pagesize;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("flowAutoid", flowAutoid);
		List<Item> list=itemDao.getItemsByFlow(map);
		int count=itemDao.getItemsByFlowCount(map);
		Model<Item> model=new Model<Item>(list, count);
		return model;
	}

	public List<Item> getItemByFlowAutoid(Integer flowAutoid, String del) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("flowAutoid", flowAutoid);
		map.put("del", del);
		return itemDao.getItemByFlowAutoid(map);
	}

	public List<Item> getItemByCourseAutoid(Integer courseAutoid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("courseAutoid", courseAutoid);
		map.put("del", "false");
		return itemDao.getItemByCourseAutoid(map);
	}

	public List<Item> getItem(Integer flowAutoid, Integer courseAutoid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("courseAutoid", courseAutoid);
		map.put("del", "false");
		map.put("flowAutoid", flowAutoid);
		return itemDao.getItem(map);
	}

	public List<Map<String, Object>>  getItemOverByCourseAutoid(Integer courseAutoid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("courseAutoid", courseAutoid);
		map.put("del", "false");
		return itemDao.getItemOverByCourseAutoid(map);
	}

	public Map<String, Object> getItemByAutoid(Integer itemAutoid,Integer courseAutoid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("itemAutoid", itemAutoid);
		map.put("courseAutoid", courseAutoid);
		return itemDao.getItemByAutoid(map);
	}
	
	public Item getItemByItemID(String itemID, int subID){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("itemID", itemID);
		map.put("subID", subID);
		return itemDao.getItemByItemID(map);
	}
	
	public List<Map<String, Object>> getItemForContent(int courseAutoid) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("courseAutoid", courseAutoid);
		return itemDao.getItemForContent(map);
	}



}
