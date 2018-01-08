package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemSuitDO;

public interface ItemSuitDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemSuitDO record);

    int insertSelective(ItemSuitDO record);

    ItemSuitDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemSuitDO record);

    int updateByPrimaryKey(ItemSuitDO record);
}