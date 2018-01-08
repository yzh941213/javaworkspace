package com.aishidai.app.service;

import com.aishidai.app.model.pojo.AttributeDO;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface AttributeService {

    public List<AttributeDO> queryAttributeDOList(AttributeQuery query);

    public AttributeDO queryAttributeDOById(long attributeId);

    public Long editAttributeDO(AttributeDO attributeDO);

    public Integer updateAttributeStatus(AttributeDO attributeDO);

    public List<AttributeDO> queryAttributeDOByParentId(long parentId);
}
