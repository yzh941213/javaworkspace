package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.SysUsersDO;
import com.aishidai.app.model.pojo.SysUsersDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUsersDOMapper {
	
    int countByExample(SysUsersDOExample example);

    int deleteByExample(SysUsersDOExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUsersDO record);
    
    int insertSelective(SysUsersDO record);

    List<SysUsersDO> selectByExample(SysUsersDOExample example);

    SysUsersDO selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") SysUsersDO record, @Param("example") SysUsersDOExample example);

    int updateByExample(@Param("record") SysUsersDO record, @Param("example") SysUsersDOExample example);

    int updateByPrimaryKeySelective(SysUsersDO record);

    int updateByPrimaryKey(SysUsersDO record);
    
    
    int insertSysUserDO(SysUsersDO record);
    
}