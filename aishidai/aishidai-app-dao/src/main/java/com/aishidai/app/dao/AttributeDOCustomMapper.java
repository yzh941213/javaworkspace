package com.aishidai.app.dao;


import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.query.QueryAttrbute;

import java.util.List;

public interface AttributeDOCustomMapper {
    List<AttributeDO> getAll();
    List<AttributeDO> queryList(QueryAttrbute queryAttrbute);

}