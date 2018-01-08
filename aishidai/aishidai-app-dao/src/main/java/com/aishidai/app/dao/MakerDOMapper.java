package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MakerDO;

public interface MakerDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MakerDO record);

    int insertSelective(MakerDO record);

    MakerDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MakerDO record);

    int updateByPrimaryKey(MakerDO record);
}