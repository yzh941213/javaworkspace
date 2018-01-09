package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TradeOrderItemDO;
import com.aishidai.app.model.pojo.TradeOrderItemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderItemDOMapper {
    int countByExample(TradeOrderItemDOExample example);

    int deleteByExample(TradeOrderItemDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeOrderItemDO record);

    int insertSelective(TradeOrderItemDO record);

    List<TradeOrderItemDO> selectByExample(TradeOrderItemDOExample example);

    TradeOrderItemDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeOrderItemDO record, @Param("example") TradeOrderItemDOExample example);

    int updateByExample(@Param("record") TradeOrderItemDO record, @Param("example") TradeOrderItemDOExample example);

    int updateByPrimaryKeySelective(TradeOrderItemDO record);

    int updateByPrimaryKey(TradeOrderItemDO record);
}