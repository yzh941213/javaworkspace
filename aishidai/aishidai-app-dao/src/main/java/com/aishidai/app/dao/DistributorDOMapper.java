package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DistributorDO;
import com.aishidai.app.model.pojo.DistributorDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistributorDOMapper {
    int countByExample(DistributorDOExample example);

    int deleteByExample(DistributorDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DistributorDO record);

    int insertSelective(DistributorDO record);

    List<DistributorDO> selectByExample(DistributorDOExample example);

    DistributorDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DistributorDO record, @Param("example") DistributorDOExample example);

    int updateByExample(@Param("record") DistributorDO record, @Param("example") DistributorDOExample example);

    int updateByPrimaryKeySelective(DistributorDO record);

    int updateByPrimaryKey(DistributorDO record);
}