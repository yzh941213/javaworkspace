package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.TradeOrderDetailDTO;
import com.zhezhuo.model.domain.TradeOrderListDTO;
import com.zhezhuo.model.domain.TradeOrderReadonlyDTO;
import com.zhezhuo.model.entity.CommissionMoneyDO;
import com.zhezhuo.model.entity.ServicesOrdersDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.query.ServicesOrdersQuery;
import com.zhezhuo.model.query.TradeOrderQuery;

/**
 * Created by 蝈蝈 on 2016/9/28.
 */
public interface TradeOrderManager {

	Result<List<TradeOrderListDTO>> queryTraderOrderList(TradeOrderQuery query,long userId);

	Result<List<TradeOrderReadonlyDTO>> queryTraderOrderReadonly(TradeOrderQuery query);

	Result<List<TradeOrderDO>> queryChildOrderList(long parentOrderId);

	Result<TradeOrderDetailDTO> queryTradeOrderDO(long orderId);

	Result<Long> updateTradeOrderStatus(TradeOrderQuery query);

	Result<TradeOrderReadonlyDTO> queryTradeOrderStat(TradeOrderQuery query);

	
	/**
	 * 修改订单的状态
	 * @param query
	 * @return
	 */
	int editOrderStatus(TradeOrderDO tradeOrderDO);
	/**
	 * 根据订单ID查询订单的是否存在
	 * @param orderId
	 * @return
	 */
	TradeOrderDO queryOrderDOByOrderId(long orderId);
	/**
	 * 取消订单
	 * @param tradeOrderDO
	 * @return
	 */
	int editOrderDOCancel(TradeOrderDO tradeOrderDO);
	//查询所有的订单详情
	List<TradeOrderDO> queryTraderOrderList() throws Exception;
	
	List<ServicesOrdersDO> queryServicesOrdersDOList() throws Exception;

	
	List<TradeOrderDO> queryTraderOrder(TradeOrderQuery orderQuery) throws Exception;

	List<ServicesOrdersDO> queryServicesOrdersDO(
			ServicesOrdersQuery serviceQuery) throws Exception;

	CommissionMoneyDO queryCommissionMoneyMoneyByOrederId(Long orderId) throws Exception;

}
