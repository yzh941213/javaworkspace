package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SysusersRoleDO;

public interface SysusersRoleDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysusersRoleDO record);

    int insertSelective(SysusersRoleDO record);

    SysusersRoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysusersRoleDO record);

    int updateByPrimaryKey(SysusersRoleDO record);
}