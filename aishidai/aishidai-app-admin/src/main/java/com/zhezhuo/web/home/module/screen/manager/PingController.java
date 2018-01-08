//package com.zhezhuo.web.home.module.screen.manager;
//
//import com.alibaba.fastjson.JSONObject;
//import com.pingplusplus.model.Refund;
//import com.zhezhuo.biz.dao.ReturnOrderDAO;
//import com.zhezhuo.biz.dao.TradeOrderDAO;
//import com.zhezhuo.biz.manager.impl.PingChangeManagerImpl;
//import com.zhezhuo.model.entity.ReturnOrderDO;
//import com.zhezhuo.model.entity.TradeOrderDO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * Created by 蝈蝈 on 2017/1/16.
// * 退款
// */
//@Controller
//@RequestMapping("/manager/ping")
//public class PingController {
//
//    @Autowired
//    ReturnOrderDAO returnOrderDAO;
//
//    @Autowired
//    TradeOrderDAO tradeOrderDAO;
//
//    @Autowired
//    PingChangeManagerImpl pingChangeManager;
//
//    @RequestMapping("/refund.do")
//    @ResponseBody
//    public String pingRefund(@RequestParam(value = "returnOrderId", defaultValue = "0") long returnOrderId,
//                             @RequestParam(value = "mount", defaultValue = "0.00") String mount) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("success", false);
//        if (Long.valueOf(returnOrderId) <= 0) {
//            jsonObject.put("message", "请填写正确的退款订单号");
//            return jsonObject.toString();
//        }
//        if (Double.valueOf(mount) <= 0) {
//            jsonObject.put("message", "请填写退款金额");
//            return jsonObject.toString();
//        }
//        ReturnOrderDO returnOrderDO = returnOrderDAO.queryReturnOrdreDetail(returnOrderId);
//        if (returnOrderDO == null) {
//            jsonObject.put("message", "找不到退款订单");
//            return jsonObject.toString();
//        }
//        TradeOrderDO tradeOrderDO = tradeOrderDAO.queryTradeOrderDetail(returnOrderDO.getOrderId());
//        if (tradeOrderDO == null || tradeOrderDO.getPayId() == "0") {
//            jsonObject.put("message", "没有该订单的付款回执");
//            return jsonObject.toString();
//        }
//        Refund refund = pingChangeManager.refund(returnOrderId, Double.valueOf(mount), tradeOrderDO.getPayId());
//        if (refund == null) {
//            jsonObject.put("message", "退款失败,请及时联系运维查看问题");
//            return jsonObject.toString();
//        }
//        jsonObject.put("success", true);
//        jsonObject.put("message", "退款申请成功");
//        jsonObject.put("data", JSONObject.toJSON(refund).toString());
//        return jsonObject.toString();
//    }
//}
