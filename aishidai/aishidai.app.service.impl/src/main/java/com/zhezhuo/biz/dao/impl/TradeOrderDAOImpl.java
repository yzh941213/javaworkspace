package com.zhezhuo.biz.dao.impl;

import java.util.List;





import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.TradeOrderDAO;
import com.zhezhuo.model.domain.TradeOrderDetailDTO;
import com.zhezhuo.model.domain.TradeOrderListDTO;
import com.zhezhuo.model.domain.TradeOrderReadonlyDTO;
import com.zhezhuo.model.entity.CommissionMoneyDO;
import com.zhezhuo.model.entity.ServicesOrdersDO;
import com.zhezhuo.model.entity.TradeOrderDO;
import com.zhezhuo.model.query.ServicesOrdersQuery;
import com.zhezhuo.model.query.TradeOrderQuery;

public class TradeOrderDAOImpl extends BaseDAO implements TradeOrderDAO {

    public List<TradeOrderListDTO> queryTradeOrderList(TradeOrderQuery query) {
        return null;
    }

    public List<TradeOrderReadonlyDTO> queryTradeOrderReadonly(TradeOrderQuery query) {
        return null;
    }

    public TradeOrderDetailDTO queryTradeOrder(long orderId) {
        return null;
    }

    public TradeOrderDO queryTradeOrderDetail(long orderId) {
        return null;
    }

    public List<TradeOrderDO> queryChildOrder(long parentOrderId) {
        return null;
    }

    public Long updateTradeOrderStatus(TradeOrderQuery query) {
        return null;
    }

    public Integer queryTradeOrderListCount(TradeOrderQuery query) {
        return null;
    }

    public Integer queryTradeOrderReadonlyCount(TradeOrderQuery query) {
        return null;
    }

    public Integer closeOrder(TradeOrderQuery query) {
        return null;
    }

    public TradeOrderReadonlyDTO queryTradeOrderStat(TradeOrderQuery query) {
        return null;
    }

    public TradeOrderDO queryOrderDOByOrderId(long orderId) {
        return null;
    }

    public int updateOrderDOStatus(TradeOrderDO tradeOrderDO) {
        return 0;
    }

    public int editOrderDOCancel(TradeOrderDO tradeOrderDO) {
        return 0;
    }

    public List<TradeOrderDO> selectTraderOrderList() throws Exception {
        return null;
    }

    public List<ServicesOrdersDO> selectServicesOrederDOList() throws Exception {
        return null;
    }

    public List<TradeOrderDO> selectTraderOrder(TradeOrderQuery orderQuery) throws Exception {
        return null;
    }

    public List<ServicesOrdersDO> selectServicesOrdersDO(ServicesOrdersQuery serviceQuery) throws Exception {
        return null;
    }

    public CommissionMoneyDO selectCommissionMoneyMoneyByOrederId(Long orderId) throws Exception {
        return null;
    }
}
