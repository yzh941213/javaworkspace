package com.zhezhuo.biz.dao;


import com.zhezhuo.model.entity.AttributeDO;
import com.zhezhuo.model.query.AttributeQuery;

import java.util.List;

/**
 * Created by Shaka on 15/7/5.
 */
public interface AttributeDAO {

    public List<AttributeDO> queryAttributeDOList(AttributeQuery query) throws Exception;

    public AttributeDO queryAttributeDOById(long attributeId) throws Exception;

    public long editAttributeDO(AttributeDO attributeDO) throws Exception;

    public int updateAttributeDOStatus(AttributeDO attributeDO) throws Exception;

    public List<AttributeDO> queryAttributeDOByParentId(long parentId) throws Exception;

    public String queryAttrNameById(long attributeId);
}
