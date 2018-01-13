package com.aishidai.app.dao;

import com.aishidai.app.model.dto.ResourceDTO;
import com.aishidai.app.model.pojo.ResourceDOCustom;
import com.aishidai.app.model.query.ResourceQuery;

import java.util.List;


public interface ResourceDOCustomMapper {
    
    List<ResourceDOCustom> queryAllResourceByUserId(long userId);
    
    List<ResourceDOCustom>  queryFirstMenu();
    
    List<ResourceDOCustom>  queryAllResource();
    
    List<ResourceDOCustom> queryFirstMenuByUserId(long userId);
    
    List<ResourceDOCustom> querySecondMenuByUserId(ResourceQuery query);
    
	List<ResourceDTO> queryResourceByRoleId(long roleId);
	
	List<ResourceDOCustom> queryAllMenuByParentId(long prantenId);
    
}