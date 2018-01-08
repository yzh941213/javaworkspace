package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemMetaPropertyDO;

public interface ItemMetaPropertyDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemMetaPropertyDO record);

    int insertSelective(ItemMetaPropertyDO record);

    ItemMetaPropertyDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemMetaPropertyDO record);

    int updateByPrimaryKey(ItemMetaPropertyDO record);
}