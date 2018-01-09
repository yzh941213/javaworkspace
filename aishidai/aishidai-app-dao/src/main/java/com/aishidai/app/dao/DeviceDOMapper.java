package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DeviceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceDOMapper {
    int countByExample(DeviceDOExample example);

    int deleteByExample(DeviceDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceDO record);

    int insertSelective(DeviceDO record);

    List<DeviceDO> selectByExample(DeviceDOExample example);

    DeviceDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceDO record, @Param("example") DeviceDOExample example);

    int updateByExample(@Param("record") DeviceDO record, @Param("example") DeviceDOExample example);

    int updateByPrimaryKeySelective(DeviceDO record);

    int updateByPrimaryKey(DeviceDO record);
}