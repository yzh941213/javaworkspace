package com.zhezhuo.biz.dao;

import com.zhezhuo.model.entity.RoleDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public interface RoleDAO {

    Long addRole(RoleDO roleDO);

    Long updateRole(RoleDO roleDO);

    List<RoleDO> queryAllRole();

    List<RoleDO> queryAllRoleByUserId(long userId);

    RoleDO queryRoleById(long id);

}
