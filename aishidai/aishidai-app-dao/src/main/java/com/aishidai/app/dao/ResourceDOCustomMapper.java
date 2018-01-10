package com.aishidai.app.dao;

import com.aishidai.app.model.dto.ResourceDTO;
import com.aishidai.app.model.pojo.ResourceDO;
import com.aishidai.app.model.query.ResourceQuery;

import java.util.List;


public interface ResourceDOCustomMapper {
    
    List<ResourceDO> queryAllResourceByUserId(long userId);
    
    List<ResourceDO>  queryFirstMenu();
    
    List<ResourceDO>  queryAllResource();
    
    List<ResourceDO> queryFirstMenuByUserId(long userId);
    
    List<ResourceDO> querySecondMenuByUserId(ResourceQuery query);
    
	List<ResourceDTO> queryResourceByRoleId(long roleId);
    
}