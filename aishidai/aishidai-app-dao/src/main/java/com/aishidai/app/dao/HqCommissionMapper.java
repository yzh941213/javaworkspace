package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.HqCommission;

public interface HqCommissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(HqCommission record);

    int insertSelective(HqCommission record);

    HqCommission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HqCommission record);

    int updateByPrimaryKey(HqCommission record);
}