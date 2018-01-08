package com.aishidai.app.service;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.SysUsersRoleDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface SysUsersRoleManager {

    Result<Long> addSysUsersRole(List<SysUsersRoleDO> sysUsersRoleDOs);

    Result<List<SysUsersRoleDO>> querySysUsersRole(long userId);



}
