package com.aishidai.app.service.impl;

import com.aishidai.app.dao.AppPanelContentDOCustomMapper;
import com.aishidai.app.dao.AppPanelContentDOMapper;
import com.aishidai.app.model.pojo.AppPanelContentDO;
import com.aishidai.app.service.AppPanelContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppPanelContentServiceImpl implements AppPanelContentService {

    @Autowired
    AppPanelContentDOMapper appPanelContentDOMapper;



    public Boolean add(AppPanelContentDO appPanelContentDO) {
        return appPanelContentDOMapper.insert(appPanelContentDO)>0;
    }

    public Boolean update(AppPanelContentDO appPanelContentDO) {
        return appPanelContentDOMapper.updateByPrimaryKey(appPanelContentDO)>0;
    }

    public Boolean del(AppPanelContentDO appPanelContentDO) {
        return null;
    }

    public AppPanelContentDO getById(Long panelContentId) {
        return appPanelContentDOMapper.selectByPrimaryKey(panelContentId);
    }

    @Autowired
    AppPanelContentDOCustomMapper appPanelContentDOCustomMapper;
    public List<AppPanelContentDO> getAll() {
        return appPanelContentDOCustomMapper.getAll();
    }
}
