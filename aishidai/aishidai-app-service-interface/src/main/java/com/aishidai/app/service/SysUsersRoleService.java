package com.aishidai.app.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.SysusersRoleDO;

@Service
public interface SysUsersRoleService {

    Result<Long> addSysUsersRole(List<SysusersRoleDO> sysUsersRoleDOs);

    List<SysusersRoleDO> querySysUsersRole(long userId);

	Result<Long> editSysUsersRole(List<SysusersRoleDO> list);

}
