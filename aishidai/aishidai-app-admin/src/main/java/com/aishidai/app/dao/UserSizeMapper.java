package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserSize;

public interface UserSizeMapper {
    int deleteByPrimaryKey(Long sizeId);

    int insert(UserSize record);

    int insertSelective(UserSize record);

    UserSize selectByPrimaryKey(Long sizeId);

    int updateByPrimaryKeySelective(UserSize record);

    int updateByPrimaryKey(UserSize record);
}