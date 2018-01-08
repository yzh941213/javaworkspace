package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.RoleResourceDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.RoleResourceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RoleResourceDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class RoleResourceManagerImpl implements RoleResourceManager {

    @Autowired
    RoleResourceDAO roleResourceDAO;

    @Resource
    CacheManager cacheManager;

    Logger logger = LoggerFactory.getLogger(RoleResourceManagerImpl.class);


    
    @Transactional
    public Result<Long> addRoleResourceDO(List<RoleResourceDO> roleResourceDOs) {

        Result<Long> result = new Result<Long>();
        try {
            for (RoleResourceDO roleResource : roleResourceDOs) {
                if (null != roleResource.getId() && roleResource.getId() != 0) {
                    long row1 = roleResourceDAO.updateRoleResourceDO(roleResource);
                    if (row1 == 0) {
                        throw new RuntimeException();
                    }
                } else {
                    long row2 = roleResourceDAO.addRoleResourceDO(roleResource);
                    if (row2 == 0) {
                        throw new RuntimeException();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("set Resource to Role" + e.getMessage());
            throw new RuntimeException();
        }
        result.setResult(1l);
        result.setSuccess(true);
        result.setSuccessInfo("设置成功");
        return result;
    }

    
    public Result<Long> updateRoleResourceDO(List<RoleResourceDO> roleResourceDOs) {
        return null;
    }
}
