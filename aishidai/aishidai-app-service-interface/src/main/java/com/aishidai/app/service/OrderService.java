package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.CommissionMoneyDO;
import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.model.pojo.TradeOrderItemDO;


public interface OrderService {

	List<TradeOrderDO> queryAll();

	List<TradeOrderDO> queryOrderByBuyerUserItem(long id);
	
	List<TradeOrderDO> queryOrderByBuyerUserService(long id);

	CommissionMoneyDO queryCommissionMoneyByOrderId(long orderId);

	List<TradeOrderItemDO> queryChildOrderItemsList(long orderId);

	List<TradeOrderDO> queryItems();
	
	List<TradeOrderDO> queryService();
}
