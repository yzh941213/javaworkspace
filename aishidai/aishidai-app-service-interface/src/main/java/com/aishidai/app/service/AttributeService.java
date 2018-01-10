package com.aishidai.app.service;

import java.util.List;

public interface AttributeService {
    /**
     * 根据id  获取下面所有的子级
     * @param attributeId
     * @return
     */
    List<AttributeDO> getAllSubclassByAttrId(Integer attributeId);


    List<AttributeDO> getAll();


    Boolean update(AttributeDO attributeDO);

    Boolean add(AttributeDO attributeDO);
}
