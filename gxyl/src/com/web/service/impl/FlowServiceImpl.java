package com.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Model;
import com.common.Tools;
import com.web.dao.IFlowDao;
import com.web.dao.IItemDao;
import com.web.entity.Flow;
import com.web.entity.Item;
import com.web.service.IFlowService;

public class FlowServiceImpl implements IFlowService {
	private IFlowDao flowDao;

	private IItemDao itemDao;

	public void setItemDao(IItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setFlowDao(IFlowDao flowDao) {
		this.flowDao = flowDao;
	}

	public Flow getFlowByID(Integer flowAutoid) {
		return flowDao.getFlowByID(flowAutoid);
	}

	public List<Flow> getFlowByfcAutoid(Integer fcAutoid) {
		return flowDao.getFlowByfcAutoid(fcAutoid);
	}

	public Map<String, Object> getFlowMapByID(Integer flowAutoid) {
		return flowDao.getFlowMapByID(flowAutoid);
	}

	public List<Map<String, Object>> getFlowByItemID(String itemID, int subID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemID", itemID);
		map.put("subID", subID);
		return flowDao.getFlowByItemID(map);
	}

	public Flow findFlowByItem(String itemID) {
		return flowDao.findFlowByItemID(itemID);
	}

	public Model<Map<String, Object>> getFlowMapByPage(int pageindex,
			int pagesize, Integer fcAutoid, String state, Integer personAutoid,
			String del) {
		Map<String, Object> map = new HashMap<String, Object>();
		pageindex = (pageindex - 1) * pagesize;
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("fcAutoid", fcAutoid);
		map.put("state", state);
		map.put("personAutoid", personAutoid);
		map.put("del", del);
		List<Map<String, Object>> list = flowDao.getFlowMapByPage(map);
		int count = flowDao.getCount(map);
		Model<Map<String, Object>> model = new Model<Map<String, Object>>(list,
				count);
		return model;
	}

	public Flow create(Flow flow, List<Item> list) {
		int result = flowDao.createFlow(flow);
		Integer flowAutoid = flow.getFlowAutoid();
		if (result > 0) {
			if (list != null && list.size() > 0) {
				for (Item item : list) {
					item.setFlowAutoid(flowAutoid);
					flowDao.createItem(item);
				}

			}
		}
		if (result > 0) {
			return getFlowByID(flowAutoid);
		}
		return null;
	}

	public int create(List<Flow> list, Integer personAutoid) {
		int result = 0;
		if (list != null && list.size() > 0) {
			for (Flow flow : list) {
				flow.setPersonAutoid(personAutoid);
				result += flowDao.createFlow(flow);
			}
		}
		return result;
	}

	public List<Item> getItemByFlow(Integer flowAutoid, String del) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flowAutoid", flowAutoid);
		map.put("del", del);
		return flowDao.getItemByFlow(map);
	}

	public Map<String, Object> parseMap(Flow flow) {
		Map<String, Object> attr = new HashMap<String, Object>();
		attr.put("personAutoid", flow.getPersonAutoid());
		attr.put("sortIndex", flow.getSortIndex());
		attr.put("imageUrl", flow.getImageUrl());
		attr.put("state", flow.getState());
		attr.put("parentID", 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", flow.getFlowAutoid());
		String state = "";
		if (flow.getState().equals("已停用")) {
			state = "[" + flow.getState() + "]";
		}
		map.put("text", flow.getFlowName() + state);
		map.put("attributes", attr);
		return map;
	}

	public Flow modify(Flow flow, List<Item> list) {
		Integer flowAutoid=flow.getFlowAutoid();
		for(Item item:list){
			int subID=item.getSubID();
			Item it=getItemByFlowSubID(flowAutoid, subID);
			if(it!=null){
				setItemByFlowSubID(item.getItemName(),item.getDel(), flowAutoid, subID);
			}else{
				item.setFlowAutoid(flowAutoid);
				itemDao.create(item);
			}
		}

		int r = flowDao.modify(flow);
		if (r > 0) {
			return getFlowByID(flow.getFlowAutoid());
		}
		return null;
	}

	public int setItemDel(String del, String autoids) {
		int[] ids = Tools.toArray(autoids, ",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("del", del);
		map.put("autoids", ids);
		return flowDao.setItemDel(map);
	}

	public int setItemDelByItemAutoid(String del, Integer itemAutoid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("del", "false");
		map.put("itemAutoid", itemAutoid);
		return flowDao.setItemDelByItemAutoid(map);
	}

	public int setState(String state, String autoids) {
		int[] ids = Tools.toArray(autoids, ",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put("autoids", ids);
		return flowDao.setState(map);
	}

	public int setFlowDel(String del, String autoids) {
		int[] ids = Tools.toArray(autoids, ",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("del", del);
		map.put("autoids", ids);
		int s = setItemDel("true", autoids);
		int r = flowDao.setFlowDel(map);
		return r;
	}

	public int modify(Flow flow) {
		return flowDao.modify(flow);
	}

	// 查询公司下拉列表
	public List<String> getCompanyNotRepeat() {
		return flowDao.getCompanyNotRepeat();
	}

	// 分页获取软件列表
	public Model<Map<String, Object>> getSoftByMap(int fcAutoid, String state,
			String del, int personAutoid, int pageindex, int pagesize,
			String companyID) {
		pageindex = (pageindex - 1) * pagesize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fcAutoid", fcAutoid);
		map.put("state", state);
		map.put("del", del);
		map.put("personAutoid", personAutoid);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("companyID", companyID);
		List<Map<String, Object>> list = flowDao.getSoftByMap(map);
		int count = flowDao.getSoftByMapCount(map);
		Model<Map<String, Object>> model = new Model<Map<String, Object>>(list,
				count);
		return model;
	}

	public int deleteByIds(String autoids) {
		Map<String, Object> map = new HashMap<String, Object>();
		String[] auto = autoids.split(",");
		int[] ids = new int[auto.length];
		for (int i = 0; i < auto.length; i++) {
			ids[i] = Integer.parseInt(auto[i]);
		}
		map.put("ids", ids);
		int status = itemDao.deleteByFlowIds(map);
		status = flowDao.deleteByIds(map);
		return status;
	}

	public Flow updataFlowAndItem(Flow flow, List<Item> list) {
		int flowAutoid = flow.getFlowAutoid();
		int status = flowDao.modify(flow);
		// 循环插入item
		if (list != null && list.size() > 0) {
			for (Item item : list) {
				item.setFlowAutoid(flowAutoid);
				flowDao.createItem(item);
			}
		}
		if (status > 0)
			return getFlowByID(flowAutoid);
		return null;
	}

	public List<Flow> getFlowByPersonAutoid(Integer personAutoid, String del,
			String state, String fcKey) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personAutoid", personAutoid);
		map.put("del", del);
		map.put("state", state);
		map.put("fcKey", fcKey);
		return flowDao.getFlowByPersonAutoid(map);
	}

	public List<Map<String, Object>> getFlowPapersByMap(String state,
			String del, int personAutoid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("personAutoid", personAutoid);
		map.put("del", del);
		map.put("state", state);
		map.put("fcAutoid", 1);
		return flowDao.getFlowPapersByMap(map);
	}

	public Flow getFlowByItemAutoid(int itemAutoid) {
		return flowDao.getFlowByItemAutoid(itemAutoid);
	}

	public List<Flow> getFlowByCourseAutoid(Integer courseAutoid) {

		return flowDao.getFlowByCourseAutoid(courseAutoid);
	}

	public Model<Map<String, Object>> getFlowForStudentByPage(
			int pageindex,int pagesize,String del,String state,int fcAutoid,int personAutoid) {
		Map<String, Object> map = new HashMap<String, Object>();
		pageindex = (pageindex - 1) * pagesize;
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("fcAutoid", fcAutoid);
		map.put("state", state);
		map.put("personAutoid", personAutoid);
		map.put("del", del);
		List<Map<String, Object>> list = flowDao.getFlowForStudentByPage(map);
		int count = flowDao.getFlowForStudentCount(map);
		Model<Map<String, Object>> model = new Model<Map<String, Object>>(list,
				count);
		return model;
	}

	public Model<Map<String, Object>> getResourceForStudentByPage(int pageindex,
			int pagesize, String del, String state, int fcAutoid,
			int personAutoid) {
		Map<String, Object> map = new HashMap<String, Object>();
		pageindex = (pageindex - 1) * pagesize;
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("fcAutoid", fcAutoid);
		map.put("state", state);
		map.put("personAutoid", personAutoid);
		map.put("del", del);
		List<Map<String, Object>> list = flowDao.getResourceForStudentByPage(map);
		int count = flowDao.getResourceForStudentcount(map);
		Model<Map<String, Object>> model = new Model<Map<String, Object>>(list,
				count);
		return model;
	}

	public List<Flow> getFlowForSelection(int courseAutoid) {
		return flowDao.getFlowForSelection(courseAutoid);
	}
	
	public Item getItemByFlowSubID(Integer flowAutoid, int subID){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("flowAutoid", flowAutoid);
		map.put("subID", subID);
		return itemDao.getItemByFlowSubID(map);
	}
	
	public int setItemByFlowSubID(String itemName, String del, Integer flowAutoid, int subID){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("itemName", itemName);
		map.put("del", del);
		map.put("flowAutoid", flowAutoid);
		map.put("subID", subID);
		return itemDao.setItemByFlowSubID(map);
	}
	
	public List<Flow> getFlowByNum(int number){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("number", number);
		return flowDao.getFlowByNum(map);
	}
}
