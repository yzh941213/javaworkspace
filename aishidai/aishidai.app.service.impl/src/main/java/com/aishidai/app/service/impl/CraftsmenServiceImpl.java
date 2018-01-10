package com.aishidai.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.CraftsmenDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOExample;
import com.aishidai.app.model.query.CraftsmenQuery;
import com.aishidai.app.service.CraftsmenService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CraftsmenServiceImpl implements CraftsmenService {
	
	@Autowired
	private CraftsmenDOMapper craftsmenDOMapper;

	
/*	public Result<List<CraftsmenDO>> queryCraftsmenDOList(CraftsmenQuery query) {
		Result<List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDOMapper.queryCraftsmenDOList(query);
			result = new Result<List<CraftsmenDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<CraftsmenDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<CraftsmenDO> queryCraftsmenDOById(long craftsmenId) {
		Result<CraftsmenDO> result = null;
		try {
			CraftsmenDO craftsmenDO = craftsmenDOMapper.queryCraftsmenDOById(craftsmenId);

			result = new Result<CraftsmenDO>();
			result.setSuccess(true);
			result.setResult(craftsmenDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<Long> editCraftsmenDO(CraftsmenDO craftsmenDO) {
		Result<Long> result = null;
		try {
			long row = craftsmenDOMapper.editCraftsmenDO(craftsmenDO);
			result = new Result<Long>();
			result.setSuccess(true);
			result.setResult(row);
			if (row == 0) {
				result.setSuccess(false);
				result.setErrorInfo("数据操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<Integer> updateCraftsmenStatus(CraftsmenDO craftsmenDO) {
		Result<Integer> result = null;
		try {
			int row = craftsmenDOMapper.updateCraftsmenDOStatus(craftsmenDO);
			result = new Result<Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<Integer> updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO) {
		Result<Integer> result = null;
		try {
			int row = craftsmenDOMapper.updateCraftsmenIsDeleted(craftsmenDO);
			result = new Result<Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}
	
	
	public Result<List<CraftsmenDO>> queryCraftsmenDOByDistributorId(long parentId) {
		Result<List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDOMapper.queryCraftsmenDOByDistributorId(parentId);
			result = new Result<List<CraftsmenDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<CraftsmenDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<List<CraftsmenDO>> queryCraftsmenDOByShopId(long shopId) {
		Result<List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDOMapper.queryCraftsmenDOByShopId(shopId);
			result = new Result<List<CraftsmenDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<CraftsmenDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<Long> updateCraftsmenSysUserId(CraftsmenDO craftsmenDO) {
		Result<Long> result = null;
		try {
			Long row = craftsmenDOMapper.updateCraftsmenDOSysUserId(craftsmenDO);
			result = new Result<Long>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	

	
	public Result<Integer> updateCraftsmenAudit(CraftsmenDO craftsmenDO) {
		Result<Integer> result = null;
		try {
			int row = craftsmenDOMapper.updateCraftsmenAudit(craftsmenDO);
			result = new Result<Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}*/

	public List<CraftsmenDO> queryCraftsmenDOBySysUserId(Long sysUserId) {
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(Integer.valueOf(sysUserId+""));
		List<CraftsmenDO> list= craftsmenDOMapper.selectByExample(example);
		return list;
	}
	
}
