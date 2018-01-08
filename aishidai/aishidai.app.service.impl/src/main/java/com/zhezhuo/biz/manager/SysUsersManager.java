package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.entity.SysUsersDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public interface SysUsersManager {

    Result<List<SysUsersDO>> querySysUsersDOList();

    Result<Long> updateSysUsersDO(SysUsersDO usersDO);

    Result<Long> addSysUsersDOS(SysUsersDO usersDOs);
    
    Result<Long> addSysUsersDOAndRole(SysUsersDO usersDOs,Long roleId);

    Result<SysUsersDO> loginAdmin(String uesrName,String password);

    Result<SysUsersDO> querySysUserInfoById(long userId);

    Result<List<ResourceDO>> queryResourceDO(long userId);

	SysUsersDO querySysUsersByUserName(String sysUserName);
	
	List<SysUsersDO> querySysUsersByGroupId(Long groupId);
}
