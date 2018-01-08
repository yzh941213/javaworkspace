package com.zhezhuo.biz.manager;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RoleDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface RoleManager {

    Result<Long> addRoleDO(RoleDO roleDO);

    Result<Long> updateRoleDO(RoleDO roleDO);

    Result<List<RoleDO>> queryAllRole();

}
