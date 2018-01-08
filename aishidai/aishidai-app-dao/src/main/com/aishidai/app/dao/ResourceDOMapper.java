package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ResourceDO;

public interface ResourceDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceDO record);

    int insertSelective(ResourceDO record);

    ResourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceDO record);

    int updateByPrimaryKey(ResourceDO record);
}