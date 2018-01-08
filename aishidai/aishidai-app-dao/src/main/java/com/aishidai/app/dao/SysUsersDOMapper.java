package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SysUsersDO;

public interface SysUsersDOMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUsersDO record);

    int insertSelective(SysUsersDO record);

    SysUsersDO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUsersDO record);

    int updateByPrimaryKey(SysUsersDO record);
}