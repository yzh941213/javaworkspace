package com.aishidai.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aishidai.app.dao.RoleResourceDOCustomMapper;
import com.aishidai.app.dao.RoleResourceDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.RoleResourceDO;
import com.aishidai.app.service.RoleResourceService;



import java.util.List;

@Transactional
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceDOMapper roleResourceDOMapper;
    @Autowired
    private RoleResourceDOCustomMapper roleResourceDOCustomMapper;

    private static final Logger logger = LoggerFactory.getLogger(RoleResourceServiceImpl.class);


    
    public Result<Long> addRoleResourceDO(List<RoleResourceDO> roleResourceDOs) {

        Result<Long> result = new Result<Long>();
        try {
            for (RoleResourceDO roleResource : roleResourceDOs) {
                long row2 = roleResourceDOCustomMapper.insertRoleResourceDO(roleResource);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        result.setResult(1l);
        result.setSuccess(true);
        result.setSuccessInfo("设置成功");
        return result;
    }
    
    public Result<Long> editRoleResourceDO(List<RoleResourceDO> roleResourceDOs) {

        Result<Long> result = new Result<Long>();
        try {
            for (RoleResourceDO roleResource : roleResourceDOs) {
                if (null != roleResource.getId() && roleResource.getId() != 0) {
                	
                    long row1 = roleResourceDOMapper.updateByPrimaryKeySelective(roleResource);
                    if (row1 == 0) {
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
}
