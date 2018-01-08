package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ReturnOrderDO;

public interface ReturnOrderDOMapper {
    int deleteByPrimaryKey(Long returnOrderId);

    int insert(ReturnOrderDO record);

    int insertSelective(ReturnOrderDO record);

    ReturnOrderDO selectByPrimaryKey(Long returnOrderId);

    int updateByPrimaryKeySelective(ReturnOrderDO record);

    int updateByPrimaryKey(ReturnOrderDO record);
}