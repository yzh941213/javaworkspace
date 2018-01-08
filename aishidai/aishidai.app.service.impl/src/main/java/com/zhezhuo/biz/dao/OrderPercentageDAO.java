package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.domain.ReportDTO;
import com.zhezhuo.model.entity.OrderPercentageDO;
import com.zhezhuo.model.query.OrderPercentageQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface OrderPercentageDAO {

	public List<OrderPercentageDO> queryOrderPercentageDOList(OrderPercentageQuery query) throws Exception;

	public OrderPercentageDO queryOrderPercentageDOById(long orderPercentageId) throws Exception;

	public long editOrderPercentageDO(OrderPercentageDO orderPercentageDO) throws Exception;

	public int updateOrderPercentageDOStatus(OrderPercentageDO orderPercentageDO) throws Exception;

	public ReportDTO queryStatOrderSys();

	public ReportDTO queryStatServiceSys();

	public ReportDTO queryStatOrderByDistributor(Long id);

	public ReportDTO queryStatServiceByDistributor(Long id);

	public ReportDTO queryStatOrderByShop(Long shopsId);

	public ReportDTO queryStatServiceByShop(Long shopsId);

	public ReportDTO queryStatOrderByMaker(Long id);

	public ReportDTO queryStatServiceByMaker(Long id);

	public ReportDTO queryStatServiceByCraftsmen(Long id);

//	public ReportDTO queryStatOrderByCraftsmen(Long id);

}
