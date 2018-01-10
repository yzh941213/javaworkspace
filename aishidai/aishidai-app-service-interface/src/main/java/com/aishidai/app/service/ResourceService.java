package com.aishidai.app.service;



import java.util.List;

import com.aishidai.app.model.pojo.ResourceDO;
import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;

@Service
public interface ResourceService {

    Result<List<ResourceDO>> queryAllResource();


    Result<List<ResourceDO>> queryAllResourceByRoleId(long roleId);

}
