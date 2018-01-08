package com.aishidai.app.service;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.PercentageDO;
import com.zhezhuo.model.query.PercentageQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface PercentageService {

	public Result<List<PercentageDO>> queryPercentageDOList(PercentageQuery query);

	public Result<PercentageDO> queryPercentageDOById(long percentageId);

	public Result<Long> editPercentageDO(PercentageDO percentageDO);

	public Result<Integer> updatePercentageStatus(PercentageDO percentageDO);

}
