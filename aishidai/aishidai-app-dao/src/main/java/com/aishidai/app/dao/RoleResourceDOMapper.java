package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.RoleResourceDO;
import com.aishidai.app.model.pojo.RoleResourceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceDOMapper {
    int countByExample(RoleResourceDOExample example);

    int deleteByExample(RoleResourceDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceDO record);

    int insertSelective(RoleResourceDO record);

    List<RoleResourceDO> selectByExample(RoleResourceDOExample example);

    RoleResourceDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleResourceDO record, @Param("example") RoleResourceDOExample example);

    int updateByExample(@Param("record") RoleResourceDO record, @Param("example") RoleResourceDOExample example);

    int updateByPrimaryKeySelective(RoleResourceDO record);

    int updateByPrimaryKey(RoleResourceDO record);
    
    long insertRoleResourceDO(RoleResourceDO record);
    
    
}