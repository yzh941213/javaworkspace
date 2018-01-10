package com.aishidai.app.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.ResourceDO;

@Service
public interface ResourceService {

    Result<List<ResourceDO>> queryAllResource();


    Result<List<ResourceDO>> queryAllResourceByRoleId(long roleId);

}
