package com.zhezhuo.biz.manager;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RoleResourceDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface RoleResourceManager {

    Result<Long> addRoleResourceDO(List<RoleResourceDO> roleResourceDOs);

    Result<Long> updateRoleResourceDO(List<RoleResourceDO> roleResourceDOs);

}
