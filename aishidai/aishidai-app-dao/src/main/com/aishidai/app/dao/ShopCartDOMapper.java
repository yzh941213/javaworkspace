package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ShopCartDO;

public interface ShopCartDOMapper {
    int deleteByPrimaryKey(Long shopCartId);

    int insert(ShopCartDO record);

    int insertSelective(ShopCartDO record);

    ShopCartDO selectByPrimaryKey(Long shopCartId);

    int updateByPrimaryKeySelective(ShopCartDO record);

    int updateByPrimaryKey(ShopCartDO record);
}