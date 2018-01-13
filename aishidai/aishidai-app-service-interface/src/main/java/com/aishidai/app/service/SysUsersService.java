package com.aishidai.app.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.ResourceDOCustom;
import com.aishidai.app.model.pojo.SysUsersDO;

@Service
public interface SysUsersService {

    Result<List<SysUsersDO>> querySysUsersDOList() throws Exception;

    Result<Long> editSysUsersDO(SysUsersDO usersDO) throws Exception;

    Result<Long> addSysUsersDOS(SysUsersDO usersDOs) throws Exception;
    
    Result<Long> addSysUsersDOAndRole(SysUsersDO usersDOs,Long roleId) throws Exception;

    Result<SysUsersDO> loginUser(String uesrName,String password) throws Exception;


    Result<List<ResourceDOCustom>> queryResourceDO(long userId) throws Exception;

	SysUsersDO querySysUsersByUserName(String sysUserName) throws Exception;
	
	List<SysUsersDO> querySysUsersByGroupId(Long groupId) throws Exception;

	SysUsersDO queryByPrimaryKey(long userId) throws Exception;
}
