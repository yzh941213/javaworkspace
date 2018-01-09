package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.RebateDO;
import com.aishidai.app.model.pojo.RebateDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RebateDOMapper {
    int countByExample(RebateDOExample example);

    int deleteByExample(RebateDOExample example);

    int deleteByPrimaryKey(Long rebateId);

    int insert(RebateDO record);

    int insertSelective(RebateDO record);

    List<RebateDO> selectByExample(RebateDOExample example);

    RebateDO selectByPrimaryKey(Long rebateId);

    int updateByExampleSelective(@Param("record") RebateDO record, @Param("example") RebateDOExample example);

    int updateByExample(@Param("record") RebateDO record, @Param("example") RebateDOExample example);

    int updateByPrimaryKeySelective(RebateDO record);

    int updateByPrimaryKey(RebateDO record);
}