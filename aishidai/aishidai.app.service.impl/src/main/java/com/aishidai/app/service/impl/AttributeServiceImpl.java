package com.aishidai.app.service.impl;

import com.aishidai.app.dao.AttributeDOCustomMapper;
import com.aishidai.app.dao.AttributeDOMapper;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.query.QueryAttrbute;
import com.aishidai.app.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {
    public List<AttributeDO> getAll() {
        return attributeDOCustomMapper.getAll();
    }

    public List<AttributeDO> queryList(QueryAttrbute queryAttrbute) {
        return attributeDOCustomMapper.queryList(queryAttrbute);
    }

    @Autowired
    AttributeDOMapper attributeDOMapper;

    @Autowired
    AttributeDOCustomMapper attributeDOCustomMapper;
    public List<AttributeDO> getAllSubclassByAttrId(Integer attributeId) {
        return null;
    }

    public Boolean update(AttributeDO attributeDO) {
        return attributeDOMapper.updateByPrimaryKeySelective(attributeDO)>0;
    }

    public Boolean add(AttributeDO attributeDO) {
        return attributeDOMapper.insert(attributeDO)>0;
    }
}
