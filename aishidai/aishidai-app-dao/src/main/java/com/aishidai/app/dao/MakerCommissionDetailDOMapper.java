package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MakerCommissionDetailDO;

public interface MakerCommissionDetailDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(MakerCommissionDetailDO record);

    int insertSelective(MakerCommissionDetailDO record);

    MakerCommissionDetailDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MakerCommissionDetailDO record);

    int updateByPrimaryKey(MakerCommissionDetailDO record);
}