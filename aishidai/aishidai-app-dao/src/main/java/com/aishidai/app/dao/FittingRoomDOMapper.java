package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.FittingRoomDO;
import com.aishidai.app.model.pojo.FittingRoomDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FittingRoomDOMapper {
    int countByExample(FittingRoomDOExample example);

    int deleteByExample(FittingRoomDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FittingRoomDO record);

    int insertSelective(FittingRoomDO record);

    List<FittingRoomDO> selectByExample(FittingRoomDOExample example);

    FittingRoomDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FittingRoomDO record, @Param("example") FittingRoomDOExample example);

    int updateByExample(@Param("record") FittingRoomDO record, @Param("example") FittingRoomDOExample example);

    int updateByPrimaryKeySelective(FittingRoomDO record);

    int updateByPrimaryKey(FittingRoomDO record);
}