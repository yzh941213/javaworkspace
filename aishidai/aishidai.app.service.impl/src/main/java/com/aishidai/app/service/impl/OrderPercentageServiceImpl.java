package com.aishidai.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhezhuo.biz.dao.OrderPercentageDAO;
import com.zhezhuo.biz.manager.OrderPercentageManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.OrderPercentageDO;
import com.zhezhuo.model.query.OrderPercentageQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class OrderPercentageServiceImpl implements OrderPercentageManager {

	@Autowired
	private OrderPercentageDAO orderPercentageDAO;

	
	public Result<List<OrderPercentageDO>> queryOrderPercentageDOList(OrderPercentageQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Result<OrderPercentageDO> queryOrderPercentageDOById(long orderPercentageId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Result<Long> editOrderPercentageDO(OrderPercentageDO orderPercentageDO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Result<Integer> updateOrderPercentageStatus(OrderPercentageDO orderPercentageDO) {
		// TODO Auto-generated method stub
		return null;
	}

}
