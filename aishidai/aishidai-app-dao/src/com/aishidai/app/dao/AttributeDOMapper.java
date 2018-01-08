package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AttributeDO;

public interface AttributeDOMapper {
    int deleteByPrimaryKey(Integer attributeId);

    int insert(AttributeDO record);

    int insertSelective(AttributeDO record);

    AttributeDO selectByPrimaryKey(Integer attributeId);

    int updateByPrimaryKeySelective(AttributeDO record);

    int updateByPrimaryKey(AttributeDO record);
}