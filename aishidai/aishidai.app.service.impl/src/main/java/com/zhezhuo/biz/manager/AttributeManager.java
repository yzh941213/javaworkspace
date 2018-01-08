package com.zhezhuo.biz.manager;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AttributeDO;
import com.zhezhuo.model.query.AttributeQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface AttributeManager {

    public Result<List<AttributeDO>> queryAttributeDOList(AttributeQuery query);

    public Result<AttributeDO> queryAttributeDOById(long attributeId);

    public Result<Long> editAttributeDO(AttributeDO attributeDO);

    public Result<Integer> updateAttributeStatus(AttributeDO attributeDO);

    public Result<List<AttributeDO>> queryAttributeDOByParentId(long parentId);
}
