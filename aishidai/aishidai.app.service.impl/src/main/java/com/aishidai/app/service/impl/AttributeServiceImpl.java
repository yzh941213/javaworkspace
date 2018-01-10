package com.aishidai.app.service.impl;

import com.aishidai.app.dao.AttributeDOMapper;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeDOMapper attributeDOMapper;
    public List<AttributeDO> getAllSubclassByAttrId(Integer attributeId) {
        return attributeDOMapper.getAllSubclassByAttrIdI(attributeId);
    }
}
