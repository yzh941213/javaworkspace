package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TradeOrderLogisticsDO;
import com.aishidai.app.model.pojo.TradeOrderLogisticsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderLogisticsDOMapper {
    int countByExample(TradeOrderLogisticsDOExample example);

    int deleteByExample(TradeOrderLogisticsDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeOrderLogisticsDO record);

    int insertSelective(TradeOrderLogisticsDO record);

    List<TradeOrderLogisticsDO> selectByExample(TradeOrderLogisticsDOExample example);

    TradeOrderLogisticsDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeOrderLogisticsDO record, @Param("example") TradeOrderLogisticsDOExample example);

    int updateByExample(@Param("record") TradeOrderLogisticsDO record, @Param("example") TradeOrderLogisticsDOExample example);

    int updateByPrimaryKeySelective(TradeOrderLogisticsDO record);

    int updateByPrimaryKey(TradeOrderLogisticsDO record);
}