package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Item;

public interface IItemDao {
	Item getItemByID(Integer itemAutoid);
	List<Map<String, Object>> getItemMapByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	
	List<Item> getItemByFlow(Map<String, Object> map);
	
	int setDelByFlow();
	int setDel(Map<String, Object> map);
	
	int create(Item item);
	
	int deleteByFlowIds(Map<String, Object> map);
	
	List<Item> getItemsByFlow(Map<String, Object> map);
	int getItemsByFlowCount(Map<String, Object> map);
	List<Item> getItemByFlowAutoid(Map<String, Object> map);
	List<Item> getItemByCourseAutoid(Map<String, Object> map);
	List<Item> getItem(Map<String, Object> map);
	List<Map<String, Object>>  getItemOverByCourseAutoid(Map<String, Object> map);
	Map<String, Object> getItemByAutoid(Map<String, Object> map);
	Item getItemByItemID(Map<String, Object> map);
	
	List<Map<String, Object>>  getItemForContent(Map<String, Object> map);
	
	int setItemByFlowSubID(Map<String, Object> map);
	Item getItemByFlowSubID(Map<String, Object> map);
}
