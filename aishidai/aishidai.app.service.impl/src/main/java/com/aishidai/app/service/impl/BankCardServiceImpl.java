package com.aishidai.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.BankCardDAO;
import com.zhezhuo.biz.manager.BankCardManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.BankCardDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.BankCardQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class BankCardServiceImpl implements BankCardManager {
	@Autowired
	private BankCardDAO bankCardDAO;

	
	public Result<List<BankCardDO>> queryBankCardDOList(BankCardQuery query) {
		Result<List<BankCardDO>> result = null;
		try {
			List<BankCardDO> list = bankCardDAO.queryBankCardDOList(query);
			result = new Result<List<BankCardDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<BankCardDO>();
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

	
	public Result<BankCardDO> queryBankCardDOById(long bankCardId) {
		Result<BankCardDO> result = null;
		try {
			BankCardDO bankCardDO = bankCardDAO.queryBankCardDOById(bankCardId);
			result = new Result<BankCardDO>();
			if (bankCardDO == null) {
				bankCardDO = new BankCardDO();
			}
			result.setSuccess(true);
			result.setResult(bankCardDO);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Result<Long> editBankCardDO(BankCardDO bankCardDO) {
		Result<Long> result = null;
		try {
			long row = bankCardDAO.editBankCardDO(bankCardDO);
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

	
	public Result<Integer> updateBankCardStatus(BankCardDO bankCardDO) {
		Result<Integer> result = null;
		try {
			int row = bankCardDAO.updateBankCardDOStatus(bankCardDO);
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

	
	public Result<List<BankCardDO>> queryBankCardDOByUserId(BankCardQuery query) {
		Result<List<BankCardDO>> result = null;
		try {
			List<BankCardDO> list = bankCardDAO.queryBankCardDOByUserId(query);
			result = new Result<List<BankCardDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<BankCardDO>();
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
