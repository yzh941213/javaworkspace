package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.CraftsmenDAO;
import com.zhezhuo.biz.manager.CraftsmenManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.CraftsmenDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.CraftsmenQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class CraftsmenManagerImpl implements CraftsmenManager {
	@Autowired
	private CraftsmenDAO craftsmenDAO;

	@Override
	public Result<List<CraftsmenDO>> queryCraftsmenDOList(CraftsmenQuery query) {
		Result<List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDAO.queryCraftsmenDOList(query);
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

	@Override
	public Result<CraftsmenDO> queryCraftsmenDOById(long craftsmenId) {
		Result<CraftsmenDO> result = null;
		try {
			CraftsmenDO craftsmenDO = craftsmenDAO.queryCraftsmenDOById(craftsmenId);

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

	@Override
	public Result<Long> editCraftsmenDO(CraftsmenDO craftsmenDO) {
		Result<Long> result = null;
		try {
			long row = craftsmenDAO.editCraftsmenDO(craftsmenDO);
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

	@Override
	public Result<Integer> updateCraftsmenStatus(CraftsmenDO craftsmenDO) {
		Result<Integer> result = null;
		try {
			int row = craftsmenDAO.updateCraftsmenDOStatus(craftsmenDO);
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

	@Override
	public Result<Integer> updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO) {
		Result<Integer> result = null;
		try {
			int row = craftsmenDAO.updateCraftsmenIsDeleted(craftsmenDO);
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
	
	@Override
	public Result<List<CraftsmenDO>> queryCraftsmenDOByDistributorId(long parentId) {
		Result<List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDAO.queryCraftsmenDOByDistributorId(parentId);
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

	@Override
	public Result<List<CraftsmenDO>> queryCraftsmenDOByShopId(long shopId) {
		Result<List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDAO.queryCraftsmenDOByShopId(shopId);
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

	@Override
	public Result<Long> updateCraftsmenSysUserId(CraftsmenDO craftsmenDO) {
		Result<Long> result = null;
		try {
			Long row = craftsmenDAO.updateCraftsmenDOSysUserId(craftsmenDO);
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

	@Override
	public Result<CraftsmenDO> queryCraftsmenDOBySysUserId(Long sysUserId) {
		Result<CraftsmenDO> result = null;
		try {
			CraftsmenDO craftsmenDO = craftsmenDAO.queryCraftsmenDOBySysUserId(sysUserId);
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

	@Override
	public Result<Integer> updateCraftsmenAudit(CraftsmenDO craftsmenDO) {
		Result<Integer> result = null;
		try {
			int row = craftsmenDAO.updateCraftsmenAudit(craftsmenDO);
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

}
