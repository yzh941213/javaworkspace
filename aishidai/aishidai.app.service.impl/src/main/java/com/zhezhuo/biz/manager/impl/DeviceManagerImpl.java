package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.dao.DeviceDAO;
import com.zhezhuo.biz.manager.DeviceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.query.DeviceQuery;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class DeviceManagerImpl implements DeviceManager {
	@Autowired
	private DeviceDAO deviceDAO;

	@Override
	public Result<List<DeviceDO>> queryDeviceDOList(DeviceQuery query) {
		Result<List<DeviceDO>> result = null;
		try {
			List<DeviceDO> list = deviceDAO.queryDeviceDOList(query);
			result = new Result<List<DeviceDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<DeviceDO>();
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
	public Result<List<DeviceDO>> queryDeviceList() throws Exception {
		// TODO Auto-generated method stub
		Result<List<DeviceDO>> result = new Result<List<DeviceDO>>();
	
		List<DeviceDO> list = deviceDAO.queryDeviceList();
		if (list.isEmpty() || list == null) {
			list = new ArrayList<DeviceDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		
		return result;
	}
	
	
	@Override
	public Result<DeviceDO> queryDeviceDOById(long deviceId) {
		Result<DeviceDO> result = null;
		try {
			DeviceDO deviceDO = deviceDAO.queryDeviceDOById(deviceId);

			result = new Result<DeviceDO>();
			result.setSuccess(true);
			result.setResult(deviceDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	@Override
	public Result<Long> editDeviceDO(DeviceDO deviceDO) {
		Result<Long> result = null;
		try {
			long row = deviceDAO.editDeviceDO(deviceDO);
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
	public Result<Integer> updateDeviceStatus(DeviceDO deviceDO) {
		Result<Integer> result = null;
		try {
			int row = deviceDAO.updateDeviceDOStatus(deviceDO);
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
	public Result<List<DeviceDO>> queryDeviceDOByDistributorId(long distributorId) {
		Result<List<DeviceDO>> result = null;
		try {
			List<DeviceDO> list = deviceDAO.queryDeviceDOByDistributorId(distributorId);
			result = new Result<List<DeviceDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<DeviceDO>();
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
	public Result<List<DeviceDO>> queryDeviceDOUnemployed(DeviceDO deviceDO) {
		Result<List<DeviceDO>> result = null;
		try {
			List<DeviceDO> list = deviceDAO.queryDeviceDOUnemployed(deviceDO);
			result = new Result<List<DeviceDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<DeviceDO>();
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
	public Result<Integer> updateDeviceDOInvest(DeviceDO deviceDO) {
		Result<Integer> result = null;
		try {
			int row = deviceDAO.updateDeviceDOInvest(deviceDO);
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
	public Result<Integer> updateDeviceDOInvestDrop(DeviceDO deviceDO) {
		Result<Integer> result = null;
		try {
			int row = deviceDAO.updateDeviceDOInvestDrop(deviceDO);
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
	public Result<DeviceDO> queryDeviceDOByProductNo(String productNo) {
		Result<DeviceDO> result = null;
		try {
			DeviceDO deviceDO = deviceDAO.queryDeviceDOByProductNo(productNo);
			result = new Result<DeviceDO>();
			result.setSuccess(true);
			result.setResult(deviceDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	@Override
	public Result<List<DeviceDO>> queryDeviceDOLike(String deviceNum) {
		// TODO Auto-generated method stub
		Result<List<DeviceDO>> result = null;
		try {
			List<DeviceDO> list = deviceDAO.queryDeviceDOLike(deviceNum);
			result = new Result<List<DeviceDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<DeviceDO>();
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
	public Result<List<DeviceDO>> queryHqDeviceDOLike(DeviceQuery query) {
		// TODO Auto-generated method stub
		Result<List<DeviceDO>> result = null;
		try {
			List<DeviceDO> list = deviceDAO.queryHqDeviceDOLike(query);
			result = new Result<List<DeviceDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<DeviceDO>();
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
