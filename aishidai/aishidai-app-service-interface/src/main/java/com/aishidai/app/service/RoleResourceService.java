package com.aishidai.app.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;

@Service
public interface RoleResourceService {

    Result<Long> addRoleResourceDO(List<RoleResourceDO> roleResourceDOs);

    
    public Result<Long> editRoleResourceDO(List<RoleResourceDO> roleResourceDOs);

}
