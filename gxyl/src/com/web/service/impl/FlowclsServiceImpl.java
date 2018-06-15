package com.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.web.dao.IFlowclsDao;
import com.web.entity.Flowcls;
import com.web.service.IFlowclsService;

public class FlowclsServiceImpl implements IFlowclsService {

	private IFlowclsDao flowclsDao;
	
	public void setFlowclsDao(IFlowclsDao flowclsDao) {
		this.flowclsDao = flowclsDao;
	}

	public Flowcls getFlowclsByID(Integer fcAutoid) {
		return flowclsDao.getFlowclsByID(fcAutoid);
	}
	
	public List<Flowcls> getFlowcls(String order) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("order", order);
		return flowclsDao.getFlowcls(map);
	}

	public List<Map<String, Object>> getFlowclsTree(List<Flowcls> list) {
		List<Map<String, Object>> list2=new ArrayList<Map<String,Object>>();
		if(list!=null && list.size()>0){
			for(Flowcls flowcls: list){
				Map<String, Object> map=new HashMap<String, Object>();
				map=parseMap(flowcls);
				map.put("state", "open");
				list2.add(map);
			}
		}
		return list2;
	}

	public Map<String, Object> parseMap(Flowcls flowcls) {
		Map<String, Object> attr=new HashMap<String, Object>();
		attr.put("sortIndex", flowcls.getSortIndex());
		attr.put("content", flowcls.getContent());
		attr.put("image", flowcls.getImage());
		attr.put("url", flowcls.getUrl());
		attr.put("parentID", 0);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", flowcls.getFcAutoid());
		map.put("text", flowcls.getFcName());
		map.put("attributes", attr);
		return map;
	}

	public Flowcls create(Flowcls flowcls) {
		int r=flowclsDao.create(flowcls);
		if(r>0){
			return getFlowclsByID(flowcls.getFcAutoid());
		}
		return null;
	}

	public int modify(Flowcls flowcls) {
		return flowclsDao.modify(flowcls);
	}

	public int delete(Integer fcAutoid) {
		int a=flowclsDao.setItemDel(fcAutoid);
		int b=flowclsDao.setFlowDel(fcAutoid);
		int c=flowclsDao.delete(fcAutoid);
		return c;
	}
}
