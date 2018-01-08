package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.query.PercentageQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface PercentageDAO {

	public List<PercentageDO> queryPercentageDOList(PercentageQuery query) throws Exception;

	public PercentageDO queryPercentageDOById(long percentageId) throws Exception;

	public long editPercentageDO(PercentageDO percentageDO) throws Exception;

	public int updatePercentageDOStatus(PercentageDO percentageDO) throws Exception;

	public int updatePercentageDOAmount(PercentageDO percentageDO) throws Exception;

	public int updatePercentageDOBalance(PercentageDO percentgeDO);
	
}
