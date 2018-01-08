package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.HqCommissionDO;

public interface HqCommissionDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(HqCommissionDO record);

    int insertSelective(HqCommissionDO record);

    HqCommissionDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HqCommissionDO record);

    int updateByPrimaryKey(HqCommissionDO record);
}