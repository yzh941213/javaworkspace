package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.TCashDO;
import com.aishidai.app.model.pojo.TCashDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCashDOMapper {
    int countByExample(TCashDOExample example);

    int deleteByExample(TCashDOExample example);

    int deleteByPrimaryKey(Long caId);

    int insert(TCashDO record);

    int insertSelective(TCashDO record);

    List<TCashDO> selectByExample(TCashDOExample example);

    TCashDO selectByPrimaryKey(Long caId);

    int updateByExampleSelective(@Param("record") TCashDO record, @Param("example") TCashDOExample example);

    int updateByExample(@Param("record") TCashDO record, @Param("example") TCashDOExample example);

    int updateByPrimaryKeySelective(TCashDO record);

    int updateByPrimaryKey(TCashDO record);
}