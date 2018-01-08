package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TradeOrderDO;

public interface TradeOrderDOMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(TradeOrderDO record);

    int insertSelective(TradeOrderDO record);

    TradeOrderDO selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(TradeOrderDO record);

    int updateByPrimaryKey(TradeOrderDO record);
}