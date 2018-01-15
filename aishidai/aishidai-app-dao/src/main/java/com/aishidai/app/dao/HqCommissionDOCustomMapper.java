package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.HqCommissionDO;
import com.aishidai.app.model.pojo.HqCommissionDOCustom;
import com.aishidai.app.model.query.HqCommissionQuery;


public interface HqCommissionDOCustomMapper {

	long insertHqCommissionDO(HqCommissionDO hqc);

	List<HqCommissionDOCustom> selectHqCommissionDOList(HqCommissionQuery query);

	long selectHqCommissionDOListCount(HqCommissionQuery query);
    
}