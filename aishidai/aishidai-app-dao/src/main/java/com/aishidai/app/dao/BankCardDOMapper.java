package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.BankCardDO;
import com.aishidai.app.model.pojo.BankCardDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankCardDOMapper {
    int countByExample(BankCardDOExample example);

    int deleteByExample(BankCardDOExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(BankCardDO record);

    int insertSelective(BankCardDO record);

    List<BankCardDO> selectByExample(BankCardDOExample example);

    BankCardDO selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") BankCardDO record, @Param("example") BankCardDOExample example);

    int updateByExample(@Param("record") BankCardDO record, @Param("example") BankCardDOExample example);

    int updateByPrimaryKeySelective(BankCardDO record);

    int updateByPrimaryKey(BankCardDO record);
}