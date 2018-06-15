package com.web.service;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.web.entity.Item;

public interface IItemService {
	/**通过id返回item*/
	Item getItemByID(Integer itemAutoid);
	
	/**分页查询
	 * @param pageindex
	 * @param pagesize
	 * @param autoid 根据parentID的值判断autoid是fcAutoid 还是flowAutoid
	 * @param parentID 取值为-1、0、1，如果取值0则autoid的值是fcAutoid，如果取值1则autoid的值是flowAutoid
	 * @param del
	 * */
	Model<Map<String, Object>> getItemMapByPage(int pageindex, int pagesize, Integer personAutoid, int autoid, int parentID, String del);
	
	List<Item> getItemByFlow(Integer flowAutoid, String del);
	
	Model<Item> getItemsByFlow(int flowAutoid,int pageindex,int pagesize);

	List<Item> getItemByFlowAutoid(Integer flowAutoid, String del);
	/**
	 * 根据课程id获取流程
	 * @param courseAutoid
	 * @return
	 */
	List<Item> getItemByCourseAutoid(Integer courseAutoid);
	/**
	 * 根据课程和软件获取培训项目
	 * @param flowAutoid
	 * @param courseAutoid
	 * @return
	 */
	List<Item> getItem(Integer flowAutoid, Integer courseAutoid);
	/**
	 * 结课
	 * @param courseAutoid
	 * @return
	 */
	List<Map<String, Object>> getItemOverByCourseAutoid(Integer courseAutoid);
	/**
	 * 根据itemAutoid查询
	 * @param itemAutoid
	 * @param courseAutoid 
	 * @return
	 */
	Map<String, Object> getItemByAutoid(Integer itemAutoid, Integer courseAutoid);
	
	Item getItemByItemID(String itemID, int subID);
	
	List<Map<String, Object>>  getItemForContent(int courseAutoid);


}
