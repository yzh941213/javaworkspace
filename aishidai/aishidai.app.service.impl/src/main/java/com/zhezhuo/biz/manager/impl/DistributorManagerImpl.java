package com.zhezhuo.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.DistributorDAO;
import com.zhezhuo.biz.manager.DistributorManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.DistributorQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class DistributorManagerImpl implements DistributorManager {
    @Autowired
    private DistributorDAO distributorDAO;

    @Override
    public Result<List<DistributorDO>> queryDistributorDOList(DistributorQuery query) {
        Result<List<DistributorDO>> result = null;
        try {
            List<DistributorDO> list = distributorDAO.queryDistributorDOList(query);
            result = new Result<List<DistributorDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<DistributorDO>();
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
    public Result<DistributorDO> queryDistributorDOById(long distributorId) {
        Result<DistributorDO> result = null;
        try {
            DistributorDO distributorDO = distributorDAO.queryDistributorDOById(distributorId);

            result = new Result<DistributorDO>();
            result.setSuccess(true);
            result.setResult(distributorDO);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(true);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public Result<Long> editDistributorDO(DistributorDO distributorDO) {
        Result<Long> result = null;
        try {
            long row = distributorDAO.editDistributorDO(distributorDO);
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
    public Result<Integer> updateDistributorStatus(DistributorDO distributorDO) {
        Result<Integer> result = null;
        try {
            int row = distributorDAO.updateDistributorDOStatus(distributorDO);
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
	public Result<Long> updateDistributorSysUserId(DistributorDO distributorDO) {
		Result<Long> result = null;
        try {
            Long row = distributorDAO.updateDistributorDOSysUserId(distributorDO);
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
	public Result<DistributorDO> queryDistributorDOBySysUserId(long sysUserId) {
		Result<DistributorDO> result = null;
        try {
            DistributorDO distributorDO = distributorDAO.queryDistributorDOBySysUserId(sysUserId);
            result = new Result<DistributorDO>();
            result.setSuccess(true);
            result.setResult(distributorDO);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(true);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
	}

	@Override
	public Result<List<DistributorDO>> queryDistributorDOAll(DistributorQuery query) {
		Result<List<DistributorDO>> result = null;
        try {
            List<DistributorDO> list = distributorDAO.queryDistributorDOAll(query);
            result = new Result<List<DistributorDO>>();
            if (list.isEmpty() || list == null) {
                list = new ArrayList<DistributorDO>();
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
	public Result<DistributorDO> queryDistributorDOByDeviceNo(String deviceNo) {
		Result<DistributorDO> result = null;
        try {
            DistributorDO distributorDO = distributorDAO.queryDistributorDOByDeviceNo(deviceNo);
            result = new Result<DistributorDO>();
            result.setSuccess(true);
            result.setResult(distributorDO);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(true);
            result.setErrorInfo(e.getMessage());
            return result;
        }
        return result;
	}

	@Override
	public List<DistributorDO> queryDistributorDOByNameLike(String name)
			throws Exception {
		// TODO Auto-generated method stub
		return distributorDAO.selectDistributorDOByNameLike(name);
	}

}
