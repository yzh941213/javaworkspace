package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ShopCommissionDO;

public interface ShopCommissionDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(ShopCommissionDO record);

    int insertSelective(ShopCommissionDO record);

    ShopCommissionDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ShopCommissionDO record);

    int updateByPrimaryKey(ShopCommissionDO record);
}