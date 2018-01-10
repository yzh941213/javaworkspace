package com.aishidai.app.service.impl;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aishidai.app.dao.ResourceDOMapper;
import com.aishidai.app.dao.SysUsersDOMapper;
import com.aishidai.app.dao.SysusersRoleDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.query.ResourceQuery;
import com.aishidai.app.service.SysUsersService;
import com.aishidai.app.utils.PasswordHash;

@Service
@Transactional
public class SysUsersServiceImpl implements SysUsersService {

	@Autowired
	private SysUsersDOMapper sysUsersDOMapper;
	@Autowired
	private SysusersRoleDOMapper sysusersRoleDOMapper;
	@Autowired
	private ResourceDOMapper resourceDOMapper;

	private static final Logger logger = LoggerFactory.getLogger(SysUsersServiceImpl.class);

	
	public Result<List<SysUsersDO>> querySysUsersDOList() throws Exception{
		Result<List<SysUsersDO>> result = new Result<List<SysUsersDO>>();
		SysUsersDOExample example = new SysUsersDOExample();

		List<SysUsersDO> usersDOs = sysUsersDOMapper.selectByExample(example);
		result.setResult(usersDOs);
		return result;
	}

	
	public Result<Long> editSysUsersDO(SysUsersDO sysUsersDO) throws Exception {
		Result<Long> result = new Result<Long>();

		long row = sysUsersDOMapper.updateByPrimaryKeySelective(sysUsersDO);
		if (row > 0) {
			result.setResult(row);
			return result;
		}
		result.setResult(-1l);
		return result;

	}

	
	public Result<Long> addSysUsersDOS(SysUsersDO usersDO)throws Exception {
		Result<Long> result = new Result<Long>();

		long row = sysUsersDOMapper.insertSysUserDO(usersDO);
		if (row > 0) {
			result.setResult(row);
			return result;
		}
		result.setResult(-1L);
		return result;
	}
	
	public SysUsersDO queryByPrimaryKey(long userId) throws Exception {
		// TODO Auto-generated method stub
		SysUsersDO sysUsersDO = sysUsersDOMapper.selectByPrimaryKey(userId);
		return sysUsersDO;
	}
	
    public Result<Long> addSysUsersDOAndRole(SysUsersDO usersDO,Long roleId) {
        Result<Long> result = new Result<Long>();
        try {
        	long row = 0;
        	if(usersDO.getUserId()==null||usersDO.getUserId().intValue()==0){
        		row = sysUsersDOMapper.insertSysUserDO(usersDO);
        		//分配角色
        		SysusersRoleDO sysUsersRole = new SysusersRoleDO();
        		sysUsersRole.setSysusersId(row);
        		sysUsersRole.setRoleId(roleId);
        		long row1 = sysusersRoleDOMapper.insertSysusersRoleDO(sysUsersRole);
        		if (row1 == 0) {
                    throw new RuntimeException();
                }
        	}else{
        		row = sysUsersDOMapper.insertSysUserDO(usersDO);	
        	}
            if (row > 0) {
                result.setResult(row);
                result.setSuccess(true);
                return result;
            }
            result.setResult(-1l);
            result.setSuccess(false);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            result.setResult(-1l);
            result.setSuccess(false);
            return result;
        }
    }

	
	public Result<SysUsersDO> loginUser(String uesrName, String password) throws Exception {
		Result<SysUsersDO> result = new Result<SysUsersDO>();
		result.setSuccess(false);
		SysUsersDOExample example = new SysUsersDOExample();
		SysUsersDOExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(uesrName);
		
		List<SysUsersDO> list = sysUsersDOMapper.selectByExample(example);
		
		if (!list.isEmpty() || !(list.size() <= 0)) {
			if (PasswordHash.validatePassword(password, list.get(0).getPassword())) {
				result.setSuccess(true);
				result.setResult(list.get(0));
				return result;
			} else {
				result.setErrorInfo("用户名或密码错误");
				return result;
			}
		}
		result.setErrorInfo("用户名或密码错误");
		return result;
	}

	

	public Result<List<ResourceDO>> queryResourceDO(long userId) {
		Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();
		
		SysUsersDOExample example = new SysUsersDOExample();
		SysUsersDOExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<SysUsersDO> list = sysUsersDOMapper.selectByExample(example);
		
		try {
			//代表是超级管理员
			if (!list.isEmpty() && list.size() > 0 && list.get(0).getUserName().equals("admin")) {
				List<ResourceDO> adminResource = 
						resourceDOMapper.queryAllResource();
				// 查全部权限
				List<ResourceDO> firstMenus = resourceDOMapper.queryFirstMenu();

				if (firstMenus != null && !firstMenus.isEmpty()) {
					for (ResourceDO first : firstMenus) {
						ResourceDOExample doexample = new ResourceDOExample();
						ResourceDOExample.Criteria docriteria = doexample.createCriteria();
						docriteria.andParentidEqualTo(first.getId());
						List<ResourceDO> secMenus = resourceDOMapper.selectByExample(doexample);
						first.setResourceDOList(secMenus);
					}
				}
				result.setResult(firstMenus);
				result.setSuccess(true);
				result.setObj(adminResource);
				result.setSuccessInfo("查询成功");
				return result;
				
			} else {
				List<ResourceDO> userResource = resourceDOMapper.queryAllResourceByUserId(userId);
				// 查部分权限
				List<ResourceDO> firstMenus = resourceDOMapper.queryFirstMenuByUserId(userId);
				if (firstMenus != null && !firstMenus.isEmpty()) {
 					for (ResourceDO first : firstMenus) {
						ResourceQuery query = new ResourceQuery();
						query.setParentId(first.getId());
						query.setUserId(userId);
						List<ResourceDO> secMenus = resourceDOMapper.querySecondMenuByUserId(query);
						first.setResourceDOList(secMenus);
					}
				}
				result.setResult(firstMenus);
				result.setSuccess(true);
				result.setObj(userResource);
				result.setSuccessInfo("查询成功");
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(null);
			result.setSuccess(false);
			result.setErrorInfo("服务器开小差了...");
			return result;
		}
	}

	
	public SysUsersDO querySysUsersByUserName(String sysUserName) {
		
		SysUsersDOExample example = new SysUsersDOExample();
		SysUsersDOExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(sysUserName);
		List<SysUsersDO> list = sysUsersDOMapper.selectByExample(example);
		if (list.isEmpty() || list.size() <= 0) {
			return null;
		}else{
			return list.get(0);
		}
		
	}
	
	public List<SysUsersDO> querySysUsersByGroupId(Long groupId) {
		
		SysUsersDOExample example = new SysUsersDOExample();
		SysUsersDOExample.Criteria criteria = example.createCriteria();
		criteria.andGroupIdEqualTo(groupId);
		List<SysUsersDO> list = sysUsersDOMapper.selectByExample(example);
		return list;
	}
	
}
