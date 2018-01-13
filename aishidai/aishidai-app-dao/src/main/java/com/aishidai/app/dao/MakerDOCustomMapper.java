package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOCustom;


public interface MakerDOCustomMapper {

	long insertMaker(MakerDO makerDO);

	MakerDOCustom selectByPrimaryKey(long id);
    
}