package com.aishidai.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aishidai.app.dao.RoleDOMapper;
import com.aishidai.app.dao.SysusersRoleDOCustomMapper;
import com.aishidai.app.dao.SysusersRoleDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.SysusersRoleDO;
import com.aishidai.app.model.pojo.SysusersRoleDOExample;
import com.aishidai.app.service.SysUsersRoleService;

import javax.annotation.Resource;

import java.util.List;

@Transactional
@Service
public class SysUsersRoleServiceImpl implements SysUsersRoleService {
	
    @Autowired
    private SysusersRoleDOMapper sysusersRoleDOMapper;
    @Autowired
    private SysusersRoleDOCustomMapper sysusersRoleDOCustomMapper;
    @Autowired
    private RoleDOMapper roleDOMapper;

   private static final Logger logger = LoggerFactory.getLogger(SysUsersRoleServiceImpl.class);


    
    
    public Result<Long> addSysUsersRole(List<SysusersRoleDO> SysusersRoleDOs) {
        Result<Long> result = new Result<Long>();
        try {
            for (SysusersRoleDO sysUsersRole : SysusersRoleDOs) {
            	long row2 = sysusersRoleDOCustomMapper.insertSysusersRoleDO(sysUsersRole);
                if (row2 == 0) {
                    throw new RuntimeException();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        result.setResult(1l);
        result.setSuccessInfo("添加成功");
        result.setSuccess(true);
        return result;
    }
    
    public Result<Long> editSysUsersRole(List<SysusersRoleDO> SysusersRoleDOs) {
    	
        Result<Long> result = new Result<Long>();
        try {
            for (SysusersRoleDO sysUsersRole : SysusersRoleDOs) {
                if (sysUsersRole.getId() != 0 && sysUsersRole.getId() != null) {
                    long row1 = sysusersRoleDOMapper.updateByPrimaryKeySelective(sysUsersRole);
                    if (row1 != 1) {
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
    
    public Result<List<SysusersRoleDO>> querySysUsersRole(long userId) {
        Result<List<SysusersRoleDO>> result = new Result<List<SysusersRoleDO>>();
        try {
        	SysusersRoleDOExample example = new SysusersRoleDOExample();
        	SysusersRoleDOExample.Criteria criteria = example.createCriteria();
        	
        	criteria.andSysusersIdEqualTo(userId);
        	
            List<SysusersRoleDO> roleDOList = 
            		sysusersRoleDOMapper.selectByExample(example);
            result.setResult(roleDOList);
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
