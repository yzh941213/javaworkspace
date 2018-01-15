package com.aishidai.app.service;

import com.aishidai.app.model.pojo.AppPanelContentDO;
import com.aishidai.app.model.pojo.AppPanelDO;

import java.util.List;

public interface AppPanelContentService {
    Boolean add(AppPanelContentDO appPanelContentDO);
    Boolean  update(AppPanelContentDO appPanelContentDO);
    Boolean  del(AppPanelContentDO appPanelContentDO);
    AppPanelContentDO  getById(Long panelContentId);
    List<AppPanelContentDO> getAll();


}
