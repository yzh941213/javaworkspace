package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.ServicesDAO;
import com.zhezhuo.biz.manager.ServicesManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ServicesDO;
import com.zhezhuo.model.query.ServicesQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class ServicesServiceImpl implements ServicesManager {
	@Autowired
	private ServicesDAO servicesDAO;

	@Override
	public Result<List<ServicesDO>> queryServicesDOList(ServicesQuery query) {
		Result<List<ServicesDO>> result = null;
		try {
			List<ServicesDO> list = servicesDAO.queryServicesDOList(query);
			result = new Result<List<ServicesDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<ServicesDO>();
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
	public Result<ServicesDO> queryServicesDOById(long servicesId) {
		Result<ServicesDO> result = null;
		try {
			ServicesDO servicesDO = servicesDAO.queryServicesDOById(servicesId);

			result = new Result<ServicesDO>();
			result.setSuccess(true);
			result.setResult(servicesDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	@Override
	public Result<Long> editServicesDO(ServicesDO servicesDO) {
		Result<Long> result = null;
		try {
			long row = servicesDAO.editServicesDO(servicesDO);
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
	public Result<Integer> updateServicesStatus(ServicesDO servicesDO) {
		Result<Integer> result = null;
		try {
			int row = servicesDAO.updateServicesDOStatus(servicesDO);
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
	public Result<List<ServicesDO>> queryServicesDOByShopId(long shopId) {
		Result<List<ServicesDO>> result = null;
		try {
			List<ServicesDO> list = servicesDAO.queryServicesDOByShopId(shopId);
			result = new Result<List<ServicesDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<ServicesDO>();
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

}
