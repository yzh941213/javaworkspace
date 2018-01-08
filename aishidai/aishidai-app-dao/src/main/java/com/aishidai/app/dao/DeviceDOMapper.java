package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DeviceDO;

public interface DeviceDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeviceDO record);

    int insertSelective(DeviceDO record);

    DeviceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeviceDO record);

    int updateByPrimaryKey(DeviceDO record);
}