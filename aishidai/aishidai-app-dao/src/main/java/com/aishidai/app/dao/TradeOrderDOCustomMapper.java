package com.aishidai.app.dao;


import com.aishidai.app.model.pojo.TradeOrderDO;

import java.util.List;

public interface TradeOrderDOCustomMapper {
    List<TradeOrderDO> orderList(TradeOrderDO tradeOrderDO);
}