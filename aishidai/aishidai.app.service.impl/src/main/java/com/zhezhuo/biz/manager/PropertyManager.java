package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.query.PropertyQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface PropertyManager {

    public Result<List<PropertyDO>> queryPropertyDOList(PropertyQuery query);

    public Result<PropertyDO> queryPropertyDOById(long propertyId);

    public Result<Integer> updatePropertyDOStatus(PropertyDO propertyDO);

    public Result<Long> editPropertyDO(PropertyDO propertyDO);

	public Result<List<PropertyDO>> queryPropertyDOByParentId(long parentId);
}
