package com.aishidai.app.service;

import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.ItemDO;

import javax.print.attribute.Attribute;
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
