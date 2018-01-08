package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SubsiteDO;

public interface SubsiteDOMapper {
    int deleteByPrimaryKey(Integer subId);

    int insert(SubsiteDO record);

    int insertSelective(SubsiteDO record);

    SubsiteDO selectByPrimaryKey(Integer subId);

    int updateByPrimaryKeySelective(SubsiteDO record);

    int updateByPrimaryKey(SubsiteDO record);
}