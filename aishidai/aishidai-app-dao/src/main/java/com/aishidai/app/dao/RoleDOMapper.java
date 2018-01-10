package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.RoleDO;
import com.aishidai.app.model.pojo.RoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDOMapper {
    int countByExample(RoleDOExample example);

    int deleteByExample(RoleDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    List<RoleDO> selectByExample(RoleDOExample example);

    RoleDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);
    
    
    long insertRole(RoleDO record);
    
}