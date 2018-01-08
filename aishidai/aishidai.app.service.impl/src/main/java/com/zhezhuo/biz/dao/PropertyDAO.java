package com.zhezhuo.biz.dao;


import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.query.PropertyQuery;

import java.util.List;

/**
 * Created by Shaka on 15/7/5.
 */
public interface PropertyDAO {

    public List<PropertyDO> queryPropertyDOList(PropertyQuery query) throws Exception;

    public PropertyDO queryPropertyDOById(long propertyId) throws Exception;

    public long insertPropertyDO(PropertyDO propertyDO) throws Exception;

    public long updatePropertyDO(PropertyDO propertyDO) throws Exception;

    public int updatePropertyDOStatus(PropertyDO propertyDO) throws Exception;

    public String queryPropertyNameById(long propertyId);

	public List<PropertyDO> queryPropertyDOByParentId(long parentId) throws Exception;
}
