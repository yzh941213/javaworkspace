package com.aishidai.app.service;

import com.aishidai.app.model.pojo.AttributeDO;

import java.util.List;

public interface AttributeService {
    /**
     * 根据id  获取下面所有的子级
     * @param attributeId
     * @return
     */
    List<AttributeDO> getAllSubclassByAttrId(Integer attributeId);
}
