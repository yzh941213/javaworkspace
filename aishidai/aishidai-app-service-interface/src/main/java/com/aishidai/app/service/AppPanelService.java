package com.aishidai.app.service;

import com.aishidai.app.model.pojo.AppPanelContentDO;
import com.aishidai.app.model.pojo.AppPanelDO;

import java.util.List;

public interface AppPanelService {
     Boolean add(AppPanelDO appPanelDO);
    Boolean  update(AppPanelDO appPanelDO);
    Boolean  del(AppPanelDO appPanelDO);
    AppPanelDO  getById(Long panelId);
    List<AppPanelDO> getAll();



}
