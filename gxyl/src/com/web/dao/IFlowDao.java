package com.web.dao;

import java.util.List;
import java.util.Map;

import com.web.entity.Flow;
import com.web.entity.Item;

public interface IFlowDao {
	Flow getFlowByID(Integer flowAutoid);
	List<Flow> getFlowByfcAutoid(Integer fcAutoid);
	/**返回map格式的flow对象*/
	Map<String, Object> getFlowMapByID(Integer flowAutoid);
	/**查询数据库中是否存在itemID和subID的纪录*/
	List<Map<String, Object>> getFlowByItemID(Map<String, Object> map);
	/**根据ItemID返回flow对象*/
	Flow findFlowByItemID(String itemID);
	
	/**分页查询*/
	List<Map<String, Object>> getFlowMapByPage(Map<String, Object> map);
	int getCount(Map<String, Object> map);
	
	int createFlow(Flow flow);
	int createItem(Item item);
	
	int modify(Flow flow);
	int setItemDel(Map<String, Object> map);
	int setItemDelByItemAutoid(Map<String, Object> map);
	
	List<Item> getItemByFlow(Map<String, Object> map);
	int setState(Map<String, Object> map);
	
	int setFlowDel(Map<String, Object> map);
	
	List<String> getCompanyNotRepeat();
	
	/**获取软件列表（分页） */
	List<Map<String,Object>> getSoftByMap(Map<String, Object> map);
	int getSoftByMapCount(Map<String, Object> map);
	
	int deleteByIds(Map<String,Object> map);
	
	int modifyMap(Flow flow);
	
	List<Map<String,Object>> getFlowPapersByMap(Map<String,Object> map);
	List<Flow> getFlowByPersonAutoid(Map<String, Object> map);
	
	Flow getFlowByItemAutoid(int itemAutoid);
	List<Flow> getFlowByCourseAutoid(Integer courseAutoid);
	
	List<Map<String,Object>> getFlowForStudentByPage(Map<String,Object> map);
	int getFlowForStudentCount(Map<String,Object> map);
	
	List<Map<String,Object>> getResourceForStudentByPage(Map<String,Object> map);
	int getResourceForStudentcount(Map<String,Object> map);
	
	List<Flow> getFlowForSelection(int courseAutoid);
	
	List<Flow> getFlowByNum(Map<String, Object> map);
}
