package com.aishidai.app.service;



import java.util.List;


import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.RoleDO;


public interface RoleService {

    long addRoleDO(RoleDO roleDO) throws Exception;

    Result<Long> updateRoleDO(RoleDO roleDO) throws Exception;

    List<RoleDO> queryAllRole() throws Exception;

	RoleDO queryByPrimaryKey(long id) throws Exception;

}
