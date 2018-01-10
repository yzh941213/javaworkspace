package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SubsiteDO;
import com.aishidai.app.model.pojo.SubsiteDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubsiteDOMapper {
    int countByExample(SubsiteDOExample example);

    int deleteByExample(SubsiteDOExample example);

    int deleteByPrimaryKey(Long subId);

    int insert(SubsiteDO record);

    int insertSelective(SubsiteDO record);

    List<SubsiteDO> selectByExample(SubsiteDOExample example);

    SubsiteDO selectByPrimaryKey(Long subId);

    int updateByExampleSelective(@Param("record") SubsiteDO record, @Param("example") SubsiteDOExample example);

    int updateByExample(@Param("record") SubsiteDO record, @Param("example") SubsiteDOExample example);

    int updateByPrimaryKeySelective(SubsiteDO record);

    int updateByPrimaryKey(SubsiteDO record);
}