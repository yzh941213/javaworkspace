package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.DataCollectDO;
import com.aishidai.app.model.pojo.DataCollectDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataCollectDOMapper {
    int countByExample(DataCollectDOExample example);

    int deleteByExample(DataCollectDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataCollectDO record);

    int insertSelective(DataCollectDO record);

    List<DataCollectDO> selectByExample(DataCollectDOExample example);

    DataCollectDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataCollectDO record, @Param("example") DataCollectDOExample example);

    int updateByExample(@Param("record") DataCollectDO record, @Param("example") DataCollectDOExample example);

    int updateByPrimaryKeySelective(DataCollectDO record);

    int updateByPrimaryKey(DataCollectDO record);
}