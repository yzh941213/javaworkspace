package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.CommissionMoneyDO;

public interface CommissionMoneyDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommissionMoneyDO record);

    int insertSelective(CommissionMoneyDO record);

    CommissionMoneyDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommissionMoneyDO record);

    int updateByPrimaryKey(CommissionMoneyDO record);
}