package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TradeOrderItemDO;

public interface TradeOrderItemDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TradeOrderItemDO record);

    int insertSelective(TradeOrderItemDO record);

    TradeOrderItemDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TradeOrderItemDO record);

    int updateByPrimaryKey(TradeOrderItemDO record);
}