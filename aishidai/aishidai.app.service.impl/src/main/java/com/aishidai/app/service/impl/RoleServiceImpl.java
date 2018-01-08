package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.RoleDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.RoleManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RoleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class RoleServiceImpl implements RoleManager {
    @Resource
    RoleDAO roleDAO;

    @Resource
    CacheManager cacheManager;

    Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    
    public Result<Long> addRoleDO(RoleDO roleDO) {
        Result<Long> result = new Result<Long>();
        try {
            long row = roleDAO.addRole(roleDO);
            result.setSuccess(true);
            result.setResult(roleDO.getId());
            result.setSuccessInfo("添加成功");
            return result;

        } catch (Exception e) {
            logger.info("addRoleError---------" + e.getMessage());
            result.setSuccess(false);
            result.setResult(-1l);
            result.setErrorInfo("添加失败!");
            return result;
        }
    }

    
    public Result<Long> updateRoleDO(RoleDO roleDO) {
        Result<Long> result = new Result<Long>();
        try {
            long row = roleDAO.updateRole(roleDO);
            if (row == 1) {
                result.setSuccess(true);
                result.setResult(roleDO.getId());
                result.setSuccessInfo("修改成功");
                return result;
            }
            result.setSuccess(false);
            result.setResult(-1l);
            result.setErrorInfo("修改失败!");
            return result;
        } catch (Exception e) {
            logger.info("addRoleError---------" + e.getMessage());
            result.setSuccess(false);
            result.setResult(-1l);
            result.setErrorInfo("修改失败!");
            return result;
        }
    }

    
    public Result<List<RoleDO>> queryAllRole() {
        Result<List<RoleDO>> result = new Result<List<RoleDO>>();
        try {
            List<RoleDO> roleDOs  = roleDAO.queryAllRole();
            if (roleDOs != null && !roleDOs.isEmpty()) {
                result.setResult(roleDOs);
                result.setSuccess(true);
                result.setSuccessInfo("查询成功");
                return result;
            }
            result.setResult(null);
            result.setSuccess(false);
            result.setSuccessInfo("查询失败");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResult(null);
            result.setSuccess(false);
            result.setSuccessInfo("查询失败");
            return result;
        }
    }
}
