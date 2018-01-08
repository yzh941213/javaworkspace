package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.OrderPercentageDAO;
import com.zhezhuo.model.domain.ReportDTO;
import com.zhezhuo.model.entity.OrderPercentageDO;
import com.zhezhuo.model.query.OrderPercentageQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class OrderPercentageDAOImpl extends BaseDAO implements OrderPercentageDAO {
	public List<OrderPercentageDO> queryOrderPercentageDOList(OrderPercentageQuery query) throws Exception {
		return null;
	}

	public OrderPercentageDO queryOrderPercentageDOById(long orderPercentageId) throws Exception {
		return null;
	}

	public long editOrderPercentageDO(OrderPercentageDO orderPercentageDO) throws Exception {
		return 0;
	}

	public int updateOrderPercentageDOStatus(OrderPercentageDO orderPercentageDO) throws Exception {
		return 0;
	}

	public ReportDTO queryStatOrderSys() {
		return null;
	}

	public ReportDTO queryStatServiceSys() {
		return null;
	}

	public ReportDTO queryStatOrderByDistributor(Long id) {
		return null;
	}

	public ReportDTO queryStatServiceByDistributor(Long id) {
		return null;
	}

	public ReportDTO queryStatOrderByShop(Long shopsId) {
		return null;
	}

	public ReportDTO queryStatServiceByShop(Long shopsId) {
		return null;
	}

	public ReportDTO queryStatOrderByMaker(Long id) {
		return null;
	}

	public ReportDTO queryStatServiceByMaker(Long id) {
		return null;
	}

	public ReportDTO queryStatServiceByCraftsmen(Long id) {
		return null;
	}
}
