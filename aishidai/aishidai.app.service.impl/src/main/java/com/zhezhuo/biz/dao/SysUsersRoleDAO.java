package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.SysUsersRoleDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public interface SysUsersRoleDAO {

    Long isSuperAdmin(Long userId);

    Long addSysUsersRoleDO(SysUsersRoleDO sysUsersRoleDO);

    Long updateSysUsersRoleDO(SysUsersRoleDO sysUsersRoleDO);

    List<SysUsersRoleDO> queryAllRoleByUserId(long userId);
}
