package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserCollectDO;

public interface UserCollectDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollectDO record);

    int insertSelective(UserCollectDO record);

    UserCollectDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollectDO record);

    int updateByPrimaryKey(UserCollectDO record);
}