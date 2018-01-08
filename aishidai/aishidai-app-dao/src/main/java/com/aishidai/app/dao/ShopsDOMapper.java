package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ShopsDO;

public interface ShopsDOMapper {
    int deleteByPrimaryKey(Long shopsId);

    int insert(ShopsDO record);

    int insertSelective(ShopsDO record);

    ShopsDO selectByPrimaryKey(Long shopsId);

    int updateByPrimaryKeySelective(ShopsDO record);

    int updateByPrimaryKey(ShopsDO record);
}