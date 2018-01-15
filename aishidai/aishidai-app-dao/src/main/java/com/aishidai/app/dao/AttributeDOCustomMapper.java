package com.aishidai.app.dao;


import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.query.QueryAttrbute;

import java.util.List;

public interface AttributeDOCustomMapper {
    List<AttributeDO> getAll();
    List<AttributeDO> queryList(QueryAttrbute queryAttrbute);
    Long queryListCount(QueryAttrbute  queryAttrbute);
    List<AttributeDO> queryByObj(QueryAttrbute queryAttrbute);

    /**
     * 获取一个分类下面所有子类
     * @param attributeId
     * @return
     */
    List<AttributeDO> getAllSubclassByAttrId(Long attributeId);
}