package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UsersDO;

public interface UsersDOMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UsersDO record);

    int insertSelective(UsersDO record);

    UsersDO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UsersDO record);

    int updateByPrimaryKey(UsersDO record);
}