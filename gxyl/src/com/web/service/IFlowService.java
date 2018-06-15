package com.web.service;

import java.util.List;
import java.util.Map;

import com.common.Model;
import com.web.entity.Flow;
import com.web.entity.Item;

public interface IFlowService {
	Flow getFlowByID(Integer flowAutoid);
	List<Flow> getFlowByfcAutoid(Integer fcAutoid);
	
	/**返回Map格式的Flow对象，编辑Flow时更新datagrid*/
	Map<String, Object> getFlowMapByID(Integer flowAutoid);
	/**查询数据库中是否存在itemID和subID的纪录
	 * @param itemID flow表中itemID字段
	 * @param subID item表中subID字段
	 * */
	List<Map<String, Object>> getFlowByItemID(String itemID, int subID);
	
	/**根据ItemID返回flow对象*/
	Flow findFlowByItem(String itemID);
	
	/**分页查询
	 * @param pageindex
	 * @param pagesize
	 * @param del 如果为空，则忽略该字段
	 * */
	Model<Map<String, Object>> getFlowMapByPage(int pageindex, int pagesize, Integer fcAutoid, String state, Integer personAutoid, String del);
	
	List<Item> getItemByFlow(Integer flowAutoid,String del);
	Flow create(Flow flow, List<Item> list);
	
	/**批量创建资源*/
	int create(List<Flow> list, Integer personAutoid);
	Map<String, Object> parseMap(Flow flow);
	
	/**编辑流程，对培训项目的操作是
	 * 1.item表del列更新成true，
	 * 2.循环list，如果表中有list中的项目，则更新该项目del成false，如果没有则插入项目*/
	Flow modify(Flow flow, List<Item> list);
	int setItemDel(String del, String autoids);
	int setItemDelByItemAutoid(String del, Integer itemAutoid);
	
	int setState(String state, String autoids);
	/**删除流程：
	 * 1.更新该流程del=true,itemID=NULL，
	 * 2.更新item表，del=true
	 * */
	int setFlowDel(String del, String autoids);
	
	/**编辑资源*/
	int modify(Flow flow);
	
	List<String> getCompanyNotRepeat();
	
	Model<Map<String, Object>>getSoftByMap(int fcAutoid,String state,String del,int personAutoid,int pageindex,int pagesize,String companyID);
	int deleteByIds(String autoids);
	Flow updataFlowAndItem(Flow flow, List<Item> list);
	
	List<Map<String,Object>> getFlowPapersByMap(String state,String del,int personAutoid);
	/**
	 * 根据登录教师获取培训流程
	 * @param personAutoid
	 * @param del
	 * @param state
	 * @param fcKey 
	 * @return
	 */
	List<Flow> getFlowByPersonAutoid(Integer personAutoid, String del,
			String state, String fcKey);
	
	Flow getFlowByItemAutoid(int itemAutoid);
	/**
	 * 根据课程id获取相关的软件
	 * @param courseAutoid
	 * @return
	 */
	List<Flow> getFlowByCourseAutoid(Integer courseAutoid);
	
	Model<Map<String,Object>> getFlowForStudentByPage(int pageindex,int pagesize,String del,String state,int fcAutoid,int personAutoid);
	
	Model<Map<String,Object>> getResourceForStudentByPage(int pageindex,int pagesize,String del,String state,int fcAutoid,int personAutoid);
	
	List<Flow> getFlowForSelection(int courseAutoid);
	
	List<Flow> getFlowByNum(int number);
}
