package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BankCardDAO;
import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.model.entity.BankCardDO;
import com.zhezhuo.model.entity.DistributorDO;
import com.zhezhuo.model.query.BankCardQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class BankCardDAOImpl extends BaseDAO implements BankCardDAO {
	//@Override
	public List<BankCardDO> queryBankCardDOList(BankCardQuery query) throws Exception {

		return null;
	}

	//@Override
	public BankCardDO queryBankCardDOById(long bankCardId) throws Exception {

		return null;
	}

	//@Override
	public long editBankCardDO(BankCardDO bankCardDO) throws Exception {

		return 1l;
	}

	//@Override
	public int updateBankCardDOStatus(BankCardDO bankCardDO) throws Exception {
		//int row = super.getSqlMapClientTemplate().update("bankCard.updateBankCardDOStatus", bankCardDO);
		return 11;
	}

	//@Override
	public List<BankCardDO> queryBankCardDOByUserId(BankCardQuery query) throws Exception {
		//List<BankCardDO> list = super.getSqlMapClientTemplate().queryForList("bankCard.queryBankCardDOByUserId",
				//query);
		return null;
	}

}
