package com.zhezhuo.biz.dao.impl;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.PropertyDAO;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.query.PropertyQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class PropertyDAOImpl extends BaseDAO implements PropertyDAO {
    public List<PropertyDO> queryPropertyDOList(PropertyQuery query) throws Exception {
        return null;
    }

    public PropertyDO queryPropertyDOById(long propertyId) throws Exception {
        return null;
    }

    public long insertPropertyDO(PropertyDO propertyDO) throws Exception {
        return 0;
    }

    public long updatePropertyDO(PropertyDO propertyDO) throws Exception {
        return 0;
    }

    public int updatePropertyDOStatus(PropertyDO propertyDO) throws Exception {
        return 0;
    }

    public String queryPropertyNameById(long propertyId) {
        return null;
    }

    public List<PropertyDO> queryPropertyDOByParentId(long parentId) throws Exception {
        return null;
    }
}
