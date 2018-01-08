package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DeviceMakerDO;

public interface DeviceMakerDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeviceMakerDO record);

    int insertSelective(DeviceMakerDO record);

    DeviceMakerDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeviceMakerDO record);

    int updateByPrimaryKey(DeviceMakerDO record);
}