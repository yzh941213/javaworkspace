package com.zhezhuo.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.PercentageDAO;
import com.zhezhuo.biz.manager.PercentageManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.query.PercentageQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class PercentageManagerImpl implements PercentageManager {
	@Autowired
	private PercentageDAO percentageDAO;

	@Override
	public Result<List<PercentageDO>> queryPercentageDOList(PercentageQuery query) {
		Result<List<PercentageDO>> result = null;
		try {
			List<PercentageDO> list = percentageDAO.queryPercentageDOList(query);
			result = new Result<List<PercentageDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<PercentageDO>();
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
	public Result<PercentageDO> queryPercentageDOById(long percentageId) {
		Result<PercentageDO> result = null;
		try {
			PercentageDO percentageDO = percentageDAO.queryPercentageDOById(percentageId);

			result = new Result<PercentageDO>();
			result.setSuccess(true);
			result.setResult(percentageDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	@Override
	public Result<Long> editPercentageDO(PercentageDO percentageDO) {
		Result<Long> result = null;
		try {
			long row = percentageDAO.editPercentageDO(percentageDO);
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
	public Result<Integer> updatePercentageStatus(PercentageDO percentageDO) {
		Result<Integer> result = null;
		try {
			int row = percentageDAO.updatePercentageDOStatus(percentageDO);
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
