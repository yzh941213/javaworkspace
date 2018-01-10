package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SysusersRoleDO;
import com.aishidai.app.model.pojo.SysusersRoleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysusersRoleDOMapper {
    int countByExample(SysusersRoleDOExample example);

    int deleteByExample(SysusersRoleDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysusersRoleDO record);

    int insertSelective(SysusersRoleDO record);

    List<SysusersRoleDO> selectByExample(SysusersRoleDOExample example);

    SysusersRoleDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysusersRoleDO record, @Param("example") SysusersRoleDOExample example);

    int updateByExample(@Param("record") SysusersRoleDO record, @Param("example") SysusersRoleDOExample example);

    int updateByPrimaryKeySelective(SysusersRoleDO record);

    int updateByPrimaryKey(SysusersRoleDO record);
    
    long isSuperAdmin(String userId);
    
    long insertSysusersRoleDO(SysusersRoleDO record);
    
}