package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AppPanelDO;
import com.aishidai.app.model.pojo.AppPanelDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppPanelDOCustomMapper {
    List<AppPanelDO> getAll();
}