package com.zhezhuo.biz.dao;


import com.zhezhuo.model.entity.SysUsersDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public interface SysUsersDAO {

    List<SysUsersDO> querySysUsersList();

    Long addSysUser(SysUsersDO usersDO);

    Long updateSysUser(SysUsersDO usersDO);

    SysUsersDO querySysUsersByUserName(String userName);

    SysUsersDO querySysUsersById(long userId);
    
    List<SysUsersDO> querySysUsersByGroupId(Long groupId);
}
