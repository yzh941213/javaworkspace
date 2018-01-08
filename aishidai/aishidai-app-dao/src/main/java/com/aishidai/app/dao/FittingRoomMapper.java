package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.FittingRoom;

public interface FittingRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FittingRoom record);

    int insertSelective(FittingRoom record);

    FittingRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FittingRoom record);

    int updateByPrimaryKey(FittingRoom record);
}