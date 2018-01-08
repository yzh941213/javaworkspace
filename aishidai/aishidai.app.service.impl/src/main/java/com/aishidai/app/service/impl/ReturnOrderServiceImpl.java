package com.aishidai.app.service.impl;

import com.pingplusplus.model.Refund;
import com.zhezhuo.biz.dao.*;
import com.zhezhuo.biz.manager.ReturnOrderManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.*;
import com.zhezhuo.model.query.ItemQuery;
import com.zhezhuo.model.query.TradeOrderQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public class ReturnOrderServiceImpl implements ReturnOrderManager {

    @Autowired
    ReturnOrderDAO returnOrderDAO;
    @Autowired
    ReOrderRecordDAO reOrderRecordDAO;
    @Autowired
    TradeOrderDAO tradeOrderDAO;
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    SkuDAO skuDAO;
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    PingChangeServiceImpl pingChangeManager;

    private static Logger logger = LoggerFactory.getLogger(ReturnOrderServiceImpl.class);

    
    @Transactional
    public Result<Long> operateStatus(ReOrderRecordDO reOrderRecordDO) {
        Result<Long> result = new Result<Long>();
        try {
            ReturnOrderDO returnOrderDO = returnOrderDAO.queryReturnOrdreDetail(reOrderRecordDO.getReturnOrderId());
            TradeOrderDO tradeOrderDO = tradeOrderDAO.queryTradeOrderDetail(returnOrderDO.getOrderId());
            ReOrderRecordDO recordDO = reOrderRecordDAO.queryRecordByPayId(reOrderRecordDO.getReturnOrderId());
            String pId = tradeOrderDO.getPayId();
            if (reOrderRecordDO.getStatus() == 7) {//退款关闭退货单
                if (recordDO  != null) {
                    result.setResult(-1l);
                    result.setErrorInfo("退款操作已经完成,请等待支付平台修改退款单状态");
                    return result;
                }
                if (returnOrderDO == null) {
                    result.setResult(-1l);
                    result.setErrorInfo("找不到退款订单");
                    return result;
                }
                if (tradeOrderDO == null || tradeOrderDO.getPayId() == "0") {
                    result.setResult(-1l);
                    result.setErrorInfo("没有该订单的付款回执");
                    return result;
                }

                if (tradeOrderDO.getParentOrderId() > 0) {
                    pId = tradeOrderDAO.queryTradeOrderDetail(tradeOrderDO.getParentOrderId()).getPayId();
                }
                Refund refund = pingChangeManager.refund(reOrderRecordDO.getReturnOrderId(),
                        Double.valueOf(reOrderRecordDO.getReturnMoney()), pId);
                logger.warn("refund---------", refund.toString());
                if (refund == null ) {
                    result.setResult(-1l);
                    result.setErrorInfo(refund.getFailureMsg());
                    return result;
                }
                result.setSuccessInfo(refund.getFailureMsg() == null ? "" : refund.getFailureMsg());
                reOrderRecordDO.setPayId(refund.getId());

                //没有子订单的订单申请退款,在退款后直接关闭
                if (tradeOrderDO.getParentOrderId() == 0) {
                    TradeOrderQuery query = new TradeOrderQuery();
                    query.setStatuss(6);
                    query.setOrderId(tradeOrderDO.getOrderId());
                    Long aLong = tradeOrderDAO.updateTradeOrderStatus(query);
                    logger.info("aLong------------  "+aLong);
                    if (aLong == null || aLong.longValue() <= 0) {
                        result.setResult(-1l);
                        result.setErrorInfo("关闭订单失败");
                        return result;
                    }
                }
            }
            //卖家收货并物流审核通过的时候库存加回去, 退款审核通过需把库存加回去
            if (reOrderRecordDO.getStatus() == 4 || (reOrderRecordDO.getStatus() == 1 && returnOrderDO.getType() == 2)) {
                Integer integer = skuDAO.updateStock(tradeOrderDO);
                if (integer == null || integer.intValue() <= 0) {
                    result.setResult(-1l);
                    result.setErrorInfo("回收库存失败");
                    return result;
                }
            }
            //修改退货单状态除了打款关闭订单
            if (reOrderRecordDO.getStatus() < 7) {
                Integer row1 = returnOrderDAO.updateStatus(reOrderRecordDO);
                if (row1 == null || row1.intValue() != 1) {
                    throw new Exception();
                }
            }
            //当是关闭订单并打款时先判断打款的流水记录是否存在
            if (reOrderRecordDO.getStatus() == 7) {
                if (recordDO  != null) {
                    reOrderRecordDO.setRecordId(recordDO.getRecordId());
                    Integer row = reOrderRecordDAO.updatePayId(reOrderRecordDO);
                    if (row != 1) {
                        throw new RuntimeException();
                    }
                    result.setSuccess(true);
                    result.setResult(1l);
                    return result;
                }
                reOrderRecordDO.setShopTime(String.valueOf(System.currentTimeMillis() / 1000));
                reOrderRecordDO.setIsDeleted(1);
            }
            Long row2 = reOrderRecordDAO.createRecord(reOrderRecordDO);

            if (row2 == null || row2.longValue() <= 0) {
                throw new Exception();
            }
            result.setSuccess(true);
            result.setResult(1l);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    
    public List<ReOrderRecordDO> queryRecord(long returnOrderId) {
        try {
            List<ReOrderRecordDO> recordDOs = reOrderRecordDAO.queryRecord(returnOrderId);
            return recordDOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public List<ReturnOrderDO> queryReturnOrderList(ItemQuery query) {
        try {
            List<ReturnOrderDO> returnOrderDOs = returnOrderDAO.queryReturnOrderList(query);
            query.setTotalItem(returnOrderDAO.queryReturnOrderCount(query));
            for (ReturnOrderDO returnOrder: returnOrderDOs) {
                TradeOrderDO tradeOrderDO = tradeOrderDAO.queryTradeOrderDetail(returnOrder.getOrderId());
                if (tradeOrderDO.getParentOrderId() != null && tradeOrderDO.getParentOrderId().longValue() > 0) {
                    returnOrder.setOrderId(tradeOrderDO.getParentOrderId());
                }
                if (tradeOrderDO != null) {
                    ItemDO itemDO = itemDAO.queryItemDOById(tradeOrderDO.getItemId());
                    SkuDO skuDO = skuDAO.querySkuDO(tradeOrderDO);
                    if (itemDO != null) {
                        returnOrder.setItemId(tradeOrderDO.getItemId());
                        returnOrder.setItemName(itemDO.getItemName());
                    }
                    if (skuDO != null) {
                        returnOrder.setItemImage(skuDO.getImage());
                    }
                    returnOrder.setColorName(propertyDAO.queryPropertyNameById(tradeOrderDO.getColorId()));
                    returnOrder.setSizeName(propertyDAO.queryPropertyNameById(tradeOrderDO.getSizeId()));

                }

            }
            return returnOrderDOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public ReturnOrderDO queryReturnOrderDetail(long returnOrderId) {
        try {
            ReturnOrderDO returnOrderDO = returnOrderDAO.queryReturnOrdreDetail(returnOrderId);

            TradeOrderDO tradeOrderDO = tradeOrderDAO.queryTradeOrderDetail(returnOrderDO.getOrderId());
            if (tradeOrderDO.getParentOrderId() != null && tradeOrderDO.getParentOrderId().longValue() > 0) {
                returnOrderDO.setOrderId(tradeOrderDO.getParentOrderId());
            }
            ReOrderRecordDO reOrderRecordDO = reOrderRecordDAO.querySendRecord(returnOrderId);
            if (reOrderRecordDO != null) {
                returnOrderDO.setExpressCompany(reOrderRecordDO.getExpressCompany());
                returnOrderDO.setTrackingNum(reOrderRecordDO.getTrackingNum());
            }
            ReOrderRecordDO offRecord = reOrderRecordDAO.queryOffRecord(returnOrderId);
            if (offRecord != null) {
                returnOrderDO.setReturnMoney(offRecord.getReturnMoney());
            }
            List<ReOrderRecordDO> recordDOs = reOrderRecordDAO.queryRecord(returnOrderId);
            returnOrderDO.setRecordDOs(recordDOs);
            return returnOrderDO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
