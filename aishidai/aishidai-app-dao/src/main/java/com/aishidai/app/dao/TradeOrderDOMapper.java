package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TradeOrderDO;
import com.aishidai.app.model.pojo.TradeOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderDOMapper {
    int countByExample(TradeOrderDOExample example);

    int deleteByExample(TradeOrderDOExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(TradeOrderDO record);

    int insertSelective(TradeOrderDO record);

    List<TradeOrderDO> selectByExample(TradeOrderDOExample example);

    TradeOrderDO selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") TradeOrderDO record, @Param("example") TradeOrderDOExample example);

    int updateByExample(@Param("record") TradeOrderDO record, @Param("example") TradeOrderDOExample example);

    int updateByPrimaryKeySelective(TradeOrderDO record);

    int updateByPrimaryKey(TradeOrderDO record);
}