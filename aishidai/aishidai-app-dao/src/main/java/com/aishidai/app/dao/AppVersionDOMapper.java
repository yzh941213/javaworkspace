package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AppVersionDO;
import com.aishidai.app.model.pojo.AppVersionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppVersionDOMapper {
    int countByExample(AppVersionDOExample example);

    int deleteByExample(AppVersionDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppVersionDO record);

    int insertSelective(AppVersionDO record);

    List<AppVersionDO> selectByExample(AppVersionDOExample example);

    AppVersionDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppVersionDO record, @Param("example") AppVersionDOExample example);

    int updateByExample(@Param("record") AppVersionDO record, @Param("example") AppVersionDOExample example);

    int updateByPrimaryKeySelective(AppVersionDO record);

    int updateByPrimaryKey(AppVersionDO record);
}