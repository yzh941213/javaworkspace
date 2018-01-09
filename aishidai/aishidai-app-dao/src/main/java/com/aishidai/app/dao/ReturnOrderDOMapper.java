package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ReturnOrderDO;
import com.aishidai.app.model.pojo.ReturnOrderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnOrderDOMapper {
    int countByExample(ReturnOrderDOExample example);

    int deleteByExample(ReturnOrderDOExample example);

    int deleteByPrimaryKey(Long returnOrderId);

    int insert(ReturnOrderDO record);

    int insertSelective(ReturnOrderDO record);

    List<ReturnOrderDO> selectByExample(ReturnOrderDOExample example);

    ReturnOrderDO selectByPrimaryKey(Long returnOrderId);

    int updateByExampleSelective(@Param("record") ReturnOrderDO record, @Param("example") ReturnOrderDOExample example);

    int updateByExample(@Param("record") ReturnOrderDO record, @Param("example") ReturnOrderDOExample example);

    int updateByPrimaryKeySelective(ReturnOrderDO record);

    int updateByPrimaryKey(ReturnOrderDO record);
}