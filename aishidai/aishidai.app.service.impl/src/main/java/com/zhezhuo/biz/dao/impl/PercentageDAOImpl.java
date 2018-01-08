package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.PercentageDAO;
import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.query.PercentageQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class PercentageDAOImpl extends BaseDAO implements PercentageDAO {
	public List<PercentageDO> queryPercentageDOList(PercentageQuery query) throws Exception {
		return null;
	}

	public PercentageDO queryPercentageDOById(long percentageId) throws Exception {
		return null;
	}

	public long editPercentageDO(PercentageDO percentageDO) throws Exception {
		return 0;
	}

	public int updatePercentageDOStatus(PercentageDO percentageDO) throws Exception {
		return 0;
	}

	public int updatePercentageDOAmount(PercentageDO percentageDO) throws Exception {
		return 0;
	}

	public int updatePercentageDOBalance(PercentageDO percentgeDO) {
		return 0;
	}
}
