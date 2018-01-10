package com.aishidai.app.service;


import java.util.List;

import com.aishidai.app.model.pojo.ResourceDO;
import com.aishidai.app.model.pojo.SysUsersDO;
import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;

@Service
public interface SysUsersService {

    Result<List<SysUsersDO>> querySysUsersDOList() throws Exception;

    Result<Long> editSysUsersDO(SysUsersDO usersDO) throws Exception;

    Result<Long> addSysUsersDOS(SysUsersDO usersDOs) throws Exception;
    
    Result<Long> addSysUsersDOAndRole(SysUsersDO usersDOs,Long roleId) throws Exception;

    Result<SysUsersDO> loginUser(String uesrName,String password) throws Exception;


    Result<List<ResourceDO>> queryResourceDO(long userId) throws Exception;

	SysUsersDO querySysUsersByUserName(String sysUserName) throws Exception;
	
	List<SysUsersDO> querySysUsersByGroupId(Long groupId) throws Exception;

	SysUsersDO queryByPrimaryKey(long userId) throws Exception;
}
