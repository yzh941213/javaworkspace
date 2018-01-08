package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.RoleResourceDO;

public interface RoleResourceDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceDO record);

    int insertSelective(RoleResourceDO record);

    RoleResourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResourceDO record);

    int updateByPrimaryKey(RoleResourceDO record);
}