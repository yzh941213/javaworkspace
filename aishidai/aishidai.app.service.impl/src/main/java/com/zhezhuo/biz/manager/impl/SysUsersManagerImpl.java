package com.zhezhuo.biz.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.ResourceDAO;
import com.zhezhuo.biz.dao.SysUsersDAO;
import com.zhezhuo.biz.dao.SysUsersRoleDAO;
import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.manager.SysUsersManager;
import com.zhezhuo.biz.util.PasswordHash;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.entity.SysUsersDO;
import com.zhezhuo.model.entity.SysUsersRoleDO;
import com.zhezhuo.model.query.ResourceQuery;

/**
 * 
 * @author 51147
 *
 */
public class SysUsersManagerImpl implements SysUsersManager {

	@Autowired
	private SysUsersDAO sysUsersDAO;

	@Resource
	private SysUsersRoleDAO sysUsersRoleDAO;

	@Resource
	private ResourceDAO resourceDAO;

	@Autowired
	private CacheManager cacheManager;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Result<List<SysUsersDO>> querySysUsersDOList() {
		Result<List<SysUsersDO>> result = new Result<List<SysUsersDO>>();
		try {
			List<SysUsersDO> usersDOs = sysUsersDAO.querySysUsersList();
			result.setSuccess(true);
			result.setResult(usersDOs);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			result.setSuccess(false);
			return result;
		}

	}

	@Override
	public Result<Long> updateSysUsersDO(SysUsersDO usersDO) {
		Result<Long> result = new Result<Long>();
		try {
			long row = sysUsersDAO.updateSysUser(usersDO);
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

	@Override
	public Result<Long> addSysUsersDOS(SysUsersDO usersDO) {
		Result<Long> result = new Result<Long>();
		try {
			long row = sysUsersDAO.addSysUser(usersDO);
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

	@Override
    public Result<Long> addSysUsersDOAndRole(SysUsersDO usersDO,Long roleId) {
        Result<Long> result = new Result<Long>();
        try {
        	long row = 0;
        	if(usersDO.getUserId()==null||usersDO.getUserId().intValue()==0){
        		row = sysUsersDAO.addSysUser(usersDO);
        		//分配角色
        		SysUsersRoleDO sysUsersRole = new SysUsersRoleDO();
        		sysUsersRole.setSysusersId(row);
        		sysUsersRole.setRoleId(roleId);
        		long row1 = sysUsersRoleDAO.addSysUsersRoleDO(sysUsersRole);
        		if (row1 == 0) {
                    throw new RuntimeException();
                }
        	}else{
        		row = sysUsersDAO.addSysUser(usersDO);	
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

	@Override
	public Result<SysUsersDO> loginAdmin(String uesrName, String password) {
		Result<SysUsersDO> result = new Result<SysUsersDO>();
		try {
			SysUsersDO sysUsersDO = sysUsersDAO.querySysUsersByUserName(uesrName);
			if (sysUsersDO != null) {
				if (PasswordHash.validatePassword(password, sysUsersDO.getPassword())) {
					// 查权限
					// sysUsersDO.setResourceDOs(queryResourceDO(sysUsersDO.getUserId()).getResult());
					result.setSuccess(true);
					result.setResult(sysUsersDO);
					return result;
				} else {
					result.setSuccess(false);
					result.setErrorInfo("密码错误");
					return result;
				}
			}
			result.setSuccess(false);
			result.setErrorInfo("用户不存在");
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			result.setSuccess(false);
			return result;
		}
	}

	@Override
	public Result<SysUsersDO> querySysUserInfoById(long userId) {
		Result<SysUsersDO> result = new Result<SysUsersDO>();
		try {
			SysUsersDO sysUsersDO = sysUsersDAO.querySysUsersById(userId);
			result.setResult(sysUsersDO);
			result.setSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			result.setSuccess(false);
			return result;
		}
	}

	public Result<List<ResourceDO>> queryResourceDO(long userId) {
		Result<List<ResourceDO>> result = new Result<List<ResourceDO>>();
		long isSuperAdmin = sysUsersRoleDAO.isSuperAdmin(userId);
		try {
			if (isSuperAdmin == 1) {
				List<ResourceDO> adminResource = resourceDAO.queryAllResourceByUserId(0);
				cacheManager.put("adminId" + userId, adminResource);
				// 查全部权限
				List<ResourceDO> firstMenus = resourceDAO.queryFirstMenu();

				if (firstMenus != null && !firstMenus.isEmpty()) {
					for (ResourceDO first : firstMenus) {
						List<ResourceDO> secMenus = resourceDAO.queryAllMenuByParentId(first.getId());
						first.setResourceDOs(secMenus);
					}
				}
				result.setResult(firstMenus);
				result.setSuccess(true);
				result.setObj(adminResource);
				result.setSuccessInfo("查询成功");
				return result;
			} else {
				List<ResourceDO> adminResource = resourceDAO.queryAllResourceByUserId(userId);
				cacheManager.put("adminId" + userId, adminResource);
				// 查部分权限
				List<ResourceDO> firstMenus = resourceDAO.queryFirstMenuByUserId(userId);
				if (firstMenus != null && !firstMenus.isEmpty()) {
 					for (ResourceDO first : firstMenus) {
						ResourceQuery query = new ResourceQuery();
						query.setParentId(first.getId());
						query.setUserId(userId);
						List<ResourceDO> secMenus = resourceDAO.querySecondMenuByUserId(query);
						first.setResourceDOs(secMenus);
					}
				}
				result.setResult(firstMenus);
				result.setSuccess(true);
				result.setObj(adminResource);
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

	@Override
	public SysUsersDO querySysUsersByUserName(String sysUserName) {
		return sysUsersDAO.querySysUsersByUserName(sysUserName);
	}

	@Override
	public List<SysUsersDO> querySysUsersByGroupId(Long groupId) {
		return sysUsersDAO.querySysUsersByGroupId(groupId);
	}
}
