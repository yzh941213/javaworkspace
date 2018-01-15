package com.aishidai.app.service.impl;

import com.aishidai.app.dao.AppPanelDOCustomMapper;
import com.aishidai.app.dao.AppPanelDOMapper;
import com.aishidai.app.model.pojo.AppPanelDO;
import com.aishidai.app.service.AppPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppPanelServiceImpl implements AppPanelService {

    @Autowired
    AppPanelDOMapper appPanelDOMapper;
    public Boolean add(AppPanelDO appPanelDO) {
        return appPanelDOMapper.insert(appPanelDO)>0;
    }

    public Boolean update(AppPanelDO appPanelDO) {
        return appPanelDOMapper.updateByPrimaryKey(appPanelDO)>0;
    }

    public Boolean del(AppPanelDO appPanelDO) {
        return null;
    }

    public AppPanelDO getById(Long panelId) {
        return appPanelDOMapper.selectByPrimaryKey(panelId);
    }

    @Autowired
    AppPanelDOCustomMapper appPanelDOCustomMapper;
    public List<AppPanelDO> getAll() {
        return appPanelDOCustomMapper.getAll();
    }
}
