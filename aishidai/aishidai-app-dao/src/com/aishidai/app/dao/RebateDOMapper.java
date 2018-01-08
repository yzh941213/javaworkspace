package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.RebateDO;

public interface RebateDOMapper {
    int deleteByPrimaryKey(Long rebateId);

    int insert(RebateDO record);

    int insertSelective(RebateDO record);

    RebateDO selectByPrimaryKey(Long rebateId);

    int updateByPrimaryKeySelective(RebateDO record);

    int updateByPrimaryKey(RebateDO record);
}