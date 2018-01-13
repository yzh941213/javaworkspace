package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.DeviceMakerDOExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeviceMakerDOMapper {
    int countByExample(DeviceMakerDOExample example);

    int deleteByExample(DeviceMakerDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceMakerDO record);

    int insertSelective(DeviceMakerDO record);

    List<DeviceMakerDO> selectByExample(DeviceMakerDOExample example);

    DeviceMakerDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceMakerDO record, @Param("example") DeviceMakerDOExample example);

    int updateByExample(@Param("record") DeviceMakerDO record, @Param("example") DeviceMakerDOExample example);

    int updateByPrimaryKeySelective(DeviceMakerDO record);

    int updateByPrimaryKey(DeviceMakerDO record);

}