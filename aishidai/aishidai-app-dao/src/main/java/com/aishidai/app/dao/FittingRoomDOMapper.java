package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.FittingRoomDO;

public interface FittingRoomDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FittingRoomDO record);

    int insertSelective(FittingRoomDO record);

    FittingRoomDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FittingRoomDO record);

    int updateByPrimaryKey(FittingRoomDO record);
}