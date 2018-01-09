package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.HqCommissionDO;
import com.aishidai.app.model.pojo.HqCommissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HqCommissionDOMapper {
    int countByExample(HqCommissionDOExample example);

    int deleteByExample(HqCommissionDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(HqCommissionDO record);

    int insertSelective(HqCommissionDO record);

    List<HqCommissionDO> selectByExample(HqCommissionDOExample example);

    HqCommissionDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HqCommissionDO record, @Param("example") HqCommissionDOExample example);

    int updateByExample(@Param("record") HqCommissionDO record, @Param("example") HqCommissionDOExample example);

    int updateByPrimaryKeySelective(HqCommissionDO record);

    int updateByPrimaryKey(HqCommissionDO record);
}