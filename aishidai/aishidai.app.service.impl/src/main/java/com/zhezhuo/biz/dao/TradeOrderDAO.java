package com.zhezhuo.biz.dao;

import java.util.List;

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
public interface TradeOrderDAO {

	List<TradeOrderListDTO> queryTradeOrderList(TradeOrderQuery query);

	List<TradeOrderReadonlyDTO> queryTradeOrderReadonly(TradeOrderQuery query);

	TradeOrderDetailDTO queryTradeOrder(long orderId);

	TradeOrderDO queryTradeOrderDetail(long orderId);

	List<TradeOrderDO> queryChildOrder(long parentOrderId);

	Long updateTradeOrderStatus(TradeOrderQuery query);

	Integer queryTradeOrderListCount(TradeOrderQuery query);
	
	Integer queryTradeOrderReadonlyCount(TradeOrderQuery query);

	Integer closeOrder(TradeOrderQuery query);

	TradeOrderReadonlyDTO queryTradeOrderStat(TradeOrderQuery query);

	/**
	 * 根据订单ID查询订单是否存在
	 * @param orderId
	 * @return
	 */
	TradeOrderDO queryOrderDOByOrderId(long orderId);
	
	/**
	 * 修改商品的状态
	 * @param tradeOrderDO
	 * @return
	 */
	int updateOrderDOStatus(TradeOrderDO tradeOrderDO);
	
	/**
	 * 取消订单
	 * @param tradeOrderDO
	 * @return
	 */
	int editOrderDOCancel(TradeOrderDO tradeOrderDO);
	//查询所有的订单详情
	List<TradeOrderDO> selectTraderOrderList() throws Exception;
	
	//查询所有服务订单详情
	List<ServicesOrdersDO> selectServicesOrederDOList() throws Exception;

	List<TradeOrderDO> selectTraderOrder(TradeOrderQuery orderQuery) throws Exception;

	List<ServicesOrdersDO> selectServicesOrdersDO(ServicesOrdersQuery serviceQuery) throws Exception;

	CommissionMoneyDO selectCommissionMoneyMoneyByOrederId(Long orderId) throws Exception;
}
