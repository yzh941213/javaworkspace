package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOCustom;
import com.aishidai.app.model.query.MakerQuery;


public interface MakerDOCustomMapper {

	long insertMaker(MakerDO makerDO);

	MakerDOCustom selectByPrimaryKey(long id);

	List<MakerDOCustom> queryMakerDOList(MakerQuery query);

	long queryMakerDOListCount(MakerQuery query);
    
}