package com.aishidai.app.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.RoleDOCustomMapper;
import com.aishidai.app.dao.RoleDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.RoleDO;
import com.aishidai.app.model.pojo.RoleDOExample;
import com.aishidai.app.service.RoleService;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	
    @Autowired
    private RoleDOMapper roleDOMapper;
    @Autowired
    private RoleDOCustomMapper roleDOCustomMapper;
    
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    
    public long addRoleDO(RoleDO roleDO)  throws Exception {
	    long row = roleDOCustomMapper.insertRole(roleDO);
	    return row;
    }

    
    public Result<Long> updateRoleDO(RoleDO roleDO)  throws Exception {
        Result<Long> result = new Result<Long>();
       
        int row = roleDOMapper.updateByPrimaryKeySelective(roleDO);
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
    }

    
    public List<RoleDO> queryAllRole() throws Exception  {
    	RoleDOExample example = new RoleDOExample();
    	
    	RoleDOExample.Criteria criteria = example.createCriteria();
    	criteria.andIsdeletedEqualTo((byte)0);
        List<RoleDO> list  = roleDOMapper.selectByExample(example);
        return list;
    }


	public RoleDO queryByPrimaryKey(long id) throws Exception {
		// TODO Auto-generated method stub
		RoleDO roleDO = roleDOMapper.selectByPrimaryKey(id);
		return roleDO;
	}
}
