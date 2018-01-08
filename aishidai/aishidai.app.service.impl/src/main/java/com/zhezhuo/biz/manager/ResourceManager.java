package com.zhezhuo.biz.manager;


import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ResourceDO;

import java.util.List;

/**
 * Created by Shaka on 15/6/3.
 */
public interface ResourceManager {

    Result<List<ResourceDO>> queryAllResource();


    Result<List<ResourceDO>> queryAllResourceByRoleId(long roleId);

}
