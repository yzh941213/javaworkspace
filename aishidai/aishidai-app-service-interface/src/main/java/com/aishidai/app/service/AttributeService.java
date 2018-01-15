package com.aishidai.app.service;

import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.query.QueryAttrbute;
import com.aishidai.app.model.vo.AttributeDetailsVo;

import java.util.List;

public interface AttributeService {
    /**
     * 根据id  获取下面所有的子级
     * @param attributeId
     * @return
     */
    List<AttributeDO> getAllSubclassByAttrId(Long attributeId);

    List<AttributeDO> getAll();

    Boolean add(AttributeDO attributeDO);
    Boolean update(AttributeDO attributeDO);

    /**
     * 查询
     * @param queryAttrbute
     * @return
     */
    List<AttributeDO> queryList(QueryAttrbute  queryAttrbute);
    Long queryListCount(QueryAttrbute  queryAttrbute);

    AttributeDO getById(Long attributeId);
    AttributeDetailsVo getDetailsById(Long attributeId);
    List<AttributeDO> queryByObj(QueryAttrbute queryAttrbute);

    Boolean del(Long attributeId);





}
