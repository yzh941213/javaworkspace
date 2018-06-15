package com.web.service;

import java.util.List;
import java.util.Map;

import com.web.entity.Flowcls;

public interface IFlowclsService {
	Flowcls getFlowclsByID(Integer fcAutoid);
	List<Flowcls> getFlowcls(String order);
	Map<String, Object> parseMap(Flowcls flowcls);
	List<Map<String, Object>> getFlowclsTree(List<Flowcls> list);
	
	
	/**创建一个*/
	Flowcls create(Flowcls flowcls);
	/**编辑*/
	int modify(Flowcls flowcls);
	/**删除分类，一次更新item表，flow表，相关记录，然后删除分类*/
	int delete(Integer fcAutoid);
}
