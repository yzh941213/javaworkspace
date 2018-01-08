package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TradeOrderLogisticsDO;

public interface TradeOrderLogisticsDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeOrderLogisticsDO record);

    int insertSelective(TradeOrderLogisticsDO record);

    TradeOrderLogisticsDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeOrderLogisticsDO record);

    int updateByPrimaryKey(TradeOrderLogisticsDO record);
}