package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ResourceDO;
import com.aishidai.app.model.pojo.ResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceDOMapper {
    int countByExample(ResourceDOExample example);

    int deleteByExample(ResourceDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ResourceDO record);

    int insertSelective(ResourceDO record);

    List<ResourceDO> selectByExample(ResourceDOExample example);

    ResourceDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ResourceDO record, @Param("example") ResourceDOExample example);

    int updateByExample(@Param("record") ResourceDO record, @Param("example") ResourceDOExample example);

    int updateByPrimaryKeySelective(ResourceDO record);

    int updateByPrimaryKey(ResourceDO record);
}