package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemSkuDO;

public interface ItemSkuDOMapper {
    int deleteByPrimaryKey(Long skuId);

    int insert(ItemSkuDO record);

    int insertSelective(ItemSkuDO record);

    ItemSkuDO selectByPrimaryKey(Long skuId);

    int updateByPrimaryKeySelective(ItemSkuDO record);

    int updateByPrimaryKey(ItemSkuDO record);
}