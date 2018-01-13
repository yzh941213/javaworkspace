package com.aishidai.app.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.ResourceDOCustom;

@Service
public interface ResourceService {

    Result<List<ResourceDOCustom>> queryAllResource();

    Result<List<ResourceDOCustom>> queryAllResourceByRoleId(long roleId);

}
