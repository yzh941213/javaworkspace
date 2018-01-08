package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.maker;

public interface makerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(maker record);

    int insertSelective(maker record);

    maker selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(maker record);

    int updateByPrimaryKey(maker record);
}