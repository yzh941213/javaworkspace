package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.RoleDAO;
import com.zhezhuo.biz.dao.SysUsersRoleDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.SysUsersRoleManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.SysUsersRoleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Shaka on 15/6/10.
 */
public class SysUsersRoleManagerImpl implements SysUsersRoleManager {
    @Resource
    SysUsersRoleDAO sysUsersRoleDAO;

    @Autowired
    RoleDAO roleDAO;

    @Resource
    CacheManager cacheManager;

    Logger logger = LoggerFactory.getLogger(SysUsersRoleManagerImpl.class);


    @Override
    @Transactional
    public Result<Long> addSysUsersRole(List<SysUsersRoleDO> sysUsersRoleDOs) {
        Result<Long> result = new Result<Long>();
        try {
            for (SysUsersRoleDO sysUsersRole : sysUsersRoleDOs) {
                if (sysUsersRole.getId() != 0 && sysUsersRole.getId() != null) {
                    long row1 = sysUsersRoleDAO.updateSysUsersRoleDO(sysUsersRole);
                    if (row1 != 1) {
                        throw new RuntimeException();
                    }
                } else {
                    long row2 = sysUsersRoleDAO.addSysUsersRoleDO(sysUsersRole);
                    if (row2 == 0) {
                        throw new RuntimeException();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("set users role" + e.getMessage());
            throw new RuntimeException();
        }
        result.setResult(1l);
        result.setSuccessInfo("添加成功");
        result.setSuccess(true);
        return result;
    }

    @Override
    public Result<List<SysUsersRoleDO>> querySysUsersRole(long userId) {
        Result<List<SysUsersRoleDO>> result = new Result<List<SysUsersRoleDO>>();
        try {
            List<SysUsersRoleDO> roleDOs = sysUsersRoleDAO.queryAllRoleByUserId(userId);
            result.setResult(roleDOs);
            result.setSuccess(true);
            result.setSuccessInfo("查询成功");
            return result;
        } catch (Exception e) {
            result.setResult(null);
            result.setSuccess(false);
            result.setErrorInfo("查询失败");
            return result;
        }
    }


}
