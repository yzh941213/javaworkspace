package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.FavoriteDO;

public interface FavoriteDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FavoriteDO record);

    int insertSelective(FavoriteDO record);

    FavoriteDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FavoriteDO record);

    int updateByPrimaryKey(FavoriteDO record);
}