package com.zhezhuo.biz.dao;

import com.zhezhuo.model.domain.ResourceDTO;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.query.ResourceQuery;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public interface ResourceDAO {

    List<ResourceDO> queryFirstMenuByUserId (long userId);

    List<ResourceDO> querySecondMenuByUserId (ResourceQuery query);

    List<ResourceDO> queryAllResourceByUserId (long userId);



    List<ResourceDO> queryFirstMenu ();

    List<ResourceDO> queryAllMenuByParentId (long parentId);

//    List<ResourceDO> queryThirdResource (long parentId);
//
//    List<ResourceDO> queryFourthResource(long parentId);




//    List<ResourceDO> queryFirstByRoleId (long roleId);
//
//    List<ResourceDO> querySecondByRoleId (ResourceQuery resourceQuery);
//
//    List<ResourceDO> queryThirdByRoleId (ResourceQuery resourceQuery);
//
//    List<ResourceDO> queryForthByRoleId(ResourceQuery resourceQuery);

    List<ResourceDTO> queryResourceByRoleId(long roleId);
}
