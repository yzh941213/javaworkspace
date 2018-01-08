package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.PropertyDO;

public interface PropertyDOMapper {
    int deleteByPrimaryKey(Integer propertyId);

    int insert(PropertyDO record);

    int insertSelective(PropertyDO record);

    PropertyDO selectByPrimaryKey(Integer propertyId);

    int updateByPrimaryKeySelective(PropertyDO record);

    int updateByPrimaryKey(PropertyDO record);
}