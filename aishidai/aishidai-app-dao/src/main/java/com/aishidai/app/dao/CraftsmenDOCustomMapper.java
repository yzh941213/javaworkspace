package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOCustom;
import com.aishidai.app.model.query.CraftsmenQuery;

public interface CraftsmenDOCustomMapper {

	long insertCraftsmenDO(CraftsmenDO craftsmenDO);

	CraftsmenDOCustom selectByPrimaryKeyCustom(long craftsmenId);

	List<CraftsmenDOCustom> selectCraftsmenDOList(CraftsmenQuery query);
	
	int selectCraftsmenDOListCount(CraftsmenQuery query);
	
}