package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.ResourceDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.ResourceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.ResourceDTO;
import com.zhezhuo.model.entity.ResourceDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class ResourceServiceImpl implements ResourceManager {
    @Resource
    ResourceDAO resourceDAO;

    @Resource
    CacheManager cacheManager;

    Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);


    
    public Result<List<ResourceDO>> queryAllResource() {
        Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();
        try {
            List<ResourceDO> firstMenusAll = resourceDAO.queryFirstMenu();
            for (ResourceDO firstAll: firstMenusAll) {
                List<ResourceDO> secMenusAll = resourceDAO.queryAllMenuByParentId(firstAll.getId());
                for (ResourceDO secAll: secMenusAll) {
                    List<ResourceDO> thirdMenusAll = resourceDAO.queryAllMenuByParentId(secAll.getId());
                    for (ResourceDO thirdAll:thirdMenusAll) {
                        List<ResourceDO> fourthMenusAll = resourceDAO.queryAllMenuByParentId(thirdAll.getId());
                        thirdAll.setResourceDOs(fourthMenusAll);
                    }
                    secAll.setResourceDOs(thirdMenusAll);
                }
                firstAll.setResourceDOs(secMenusAll);
            }
            result.setResult(firstMenusAll);
            result.setSuccess(true);
            result.setSuccessInfo("查询成功");
            return result;
        } catch (Exception e) {
            result.setResult(null);
            result.setSuccess(false);
            result.setSuccessInfo("查询失败");
            return result;
        }
    }

    
    public Result<List<ResourceDO>> queryAllResourceByRoleId(long roleId) {
        Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();
        try {
            List<ResourceDTO> resourceDOs = resourceDAO.queryResourceByRoleId(roleId);
            List<ResourceDO> firstMenusAll = resourceDAO.queryFirstMenu();

                for (ResourceDO firstAll: firstMenusAll) {
                    for (ResourceDTO resourceDTO:resourceDOs) {
                        if (firstAll.getId().equals(resourceDTO.getId())) {
                            firstAll.setIsTrue(1);
                            firstAll.setRole_res_id(resourceDTO.getRole_res_id());
                        }
                    }
                    List<ResourceDO> secMenusAll = resourceDAO.queryAllMenuByParentId(firstAll.getId());
                    for (ResourceDO secAll: secMenusAll) {

                        for (ResourceDTO resourceDTO:resourceDOs) {
                            if (secAll.getId().equals(resourceDTO.getId())) {
                                secAll.setIsTrue(1);
                                secAll.setRole_res_id(resourceDTO.getRole_res_id());
                            }
                        }
                        List<ResourceDO> thirdMenusAll = resourceDAO.queryAllMenuByParentId(secAll.getId());

                        for (ResourceDO thirdAll:thirdMenusAll) {
                            for (ResourceDTO resourceDTO:resourceDOs) {
                                if (thirdAll.getId().equals(resourceDTO.getId())) {
                                    thirdAll.setIsTrue(1);
                                    thirdAll.setRole_res_id(resourceDTO.getRole_res_id());
                                }
                            }
                            List<ResourceDO> fourthMenusAll = resourceDAO.queryAllMenuByParentId(thirdAll.getId());
                            for (ResourceDO fourthAll: fourthMenusAll) {
                                for (ResourceDTO resourceDTO:resourceDOs) {
                                    if (fourthAll.getId().equals(resourceDTO.getId())) {
                                        fourthAll.setIsTrue(1);
                                        fourthAll.setRole_res_id(resourceDTO.getRole_res_id());
                                    }
                                }
                            }
                            thirdAll.setResourceDOs(fourthMenusAll);
                        }

                        secAll.setResourceDOs(thirdMenusAll);
                    }

                    firstAll.setResourceDOs(secMenusAll);
                }
            result.setResult(firstMenusAll);
            result.setSuccess(true);
            result.setSuccessInfo("查询成功");
            return result;
        } catch (Exception e) {
            result.setResult(null);
            result.setSuccess(false);
            result.setSuccessInfo("查询失败");
            return result;
        }
    }
}
