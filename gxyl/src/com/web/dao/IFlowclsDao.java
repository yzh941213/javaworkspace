package com.web.dao;

import java.util.List;
import java.util.Map;

//import com.web.entity.Flow;
import com.web.entity.Flowcls;

public interface IFlowclsDao {
	Flowcls getFlowclsByID(Integer fcAutoid);
	List<Flowcls> getFlowcls(Map<String, Object> map);
	//List<Flow> getFlowByfcAutoid(Integer fcAutoid);
	int create(Flowcls flowcls);
	int modify(Flowcls flowcls);
	
	int setItemDel(Integer fcAutoid);
	int setFlowDel(Integer fcAutoid);
	int delete(Integer fcAutoid);
}
