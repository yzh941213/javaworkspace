package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.ResourceDAO;
import com.zhezhuo.model.domain.ResourceDTO;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.query.ResourceQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public class ResourceDAOImpl extends BaseDAO implements ResourceDAO {

    public List<ResourceDO> queryFirstMenuByUserId(long userId) {
        return null;
    }

    public List<ResourceDO> querySecondMenuByUserId(ResourceQuery query) {
        return null;
    }

    public List<ResourceDO> queryAllResourceByUserId(long userId) {
        return null;
    }

    public List<ResourceDO> queryFirstMenu() {
        return null;
    }

    public List<ResourceDO> queryAllMenuByParentId(long parentId) {
        return null;
    }

    public List<ResourceDTO> queryResourceByRoleId(long roleId) {
        return null;
    }
}
