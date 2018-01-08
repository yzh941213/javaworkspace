package com.aishidai.app.service;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.OrderPercentageDO;
import com.zhezhuo.model.query.OrderPercentageQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface OrderPercentageService {

	public Result<List<OrderPercentageDO>> queryOrderPercentageDOList(OrderPercentageQuery query);

	public Result<OrderPercentageDO> queryOrderPercentageDOById(long orderPercentageId);

	public Result<Long> editOrderPercentageDO(OrderPercentageDO orderPercentageDO);

	public Result<Integer> updateOrderPercentageStatus(OrderPercentageDO orderPercentageDO);

}
