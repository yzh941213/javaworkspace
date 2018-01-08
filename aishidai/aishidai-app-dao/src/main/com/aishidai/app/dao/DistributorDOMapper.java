package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DistributorDO;

public interface DistributorDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DistributorDO record);

    int insertSelective(DistributorDO record);

    DistributorDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DistributorDO record);

    int updateByPrimaryKey(DistributorDO record);
}