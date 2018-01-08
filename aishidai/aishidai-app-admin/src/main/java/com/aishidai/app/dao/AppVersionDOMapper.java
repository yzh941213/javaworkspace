package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AppVersionDO;

public interface AppVersionDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppVersionDO record);

    int insertSelective(AppVersionDO record);

    AppVersionDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersionDO record);

    int updateByPrimaryKey(AppVersionDO record);
}