package com.aishidai.app.service;



import java.util.List;

import com.aishidai.app.model.pojo.SysusersRoleDO;
import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;

@Service
public interface SysUsersRoleService {

    Result<Long> addSysUsersRole(List<SysusersRoleDO> sysUsersRoleDOs);

    Result<List<SysusersRoleDO>> querySysUsersRole(long userId);

	Result<Long> editSysUsersRole(List<SysusersRoleDO> list);



}
