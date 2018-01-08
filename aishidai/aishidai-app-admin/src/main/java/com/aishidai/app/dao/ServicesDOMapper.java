package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ServicesDO;

public interface ServicesDOMapper {
    int deleteByPrimaryKey(Long serviceId);

    int insert(ServicesDO record);

    int insertSelective(ServicesDO record);

    ServicesDO selectByPrimaryKey(Long serviceId);

    int updateByPrimaryKeySelective(ServicesDO record);

    int updateByPrimaryKey(ServicesDO record);
}