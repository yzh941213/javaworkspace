package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AppPanelContentDO;
import com.aishidai.app.model.pojo.AppPanelContentDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppPanelContentDOCustomMapper {


    List<AppPanelContentDO> getAll();
}