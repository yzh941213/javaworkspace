package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.CommissionMoneyDO;
import com.aishidai.app.model.pojo.CommissionMoneyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommissionMoneyDOMapper {
    int countByExample(CommissionMoneyDOExample example);

    int deleteByExample(CommissionMoneyDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommissionMoneyDO record);

    int insertSelective(CommissionMoneyDO record);

    List<CommissionMoneyDO> selectByExample(CommissionMoneyDOExample example);

    CommissionMoneyDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommissionMoneyDO record, @Param("example") CommissionMoneyDOExample example);

    int updateByExample(@Param("record") CommissionMoneyDO record, @Param("example") CommissionMoneyDOExample example);

    int updateByPrimaryKeySelective(CommissionMoneyDO record);

    int updateByPrimaryKey(CommissionMoneyDO record);
}