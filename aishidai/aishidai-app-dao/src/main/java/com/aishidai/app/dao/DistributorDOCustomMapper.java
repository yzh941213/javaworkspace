package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.query.DistributorQuery;


public interface DistributorDOCustomMapper {

	long insertDistributorDO(DistributorDO distributorDO);

	List<DistributorDO> selectDistributorDOList(DistributorQuery query);

	long selectDistributorDOListCount(DistributorQuery query);
    
}