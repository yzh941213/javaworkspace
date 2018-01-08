package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DataCollectDO;

public interface DataCollectDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataCollectDO record);

    int insertSelective(DataCollectDO record);

    DataCollectDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataCollectDO record);

    int updateByPrimaryKey(DataCollectDO record);
}