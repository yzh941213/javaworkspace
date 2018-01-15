package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AppPanelDO;
import com.aishidai.app.model.pojo.AppPanelDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppPanelDOMapper {
    int countByExample(AppPanelDOExample example);

    int deleteByExample(AppPanelDOExample example);

    int deleteByPrimaryKey(Long panelId);

    int insert(AppPanelDO record);

    int insertSelective(AppPanelDO record);

    List<AppPanelDO> selectByExample(AppPanelDOExample example);

    AppPanelDO selectByPrimaryKey(Long panelId);

    int updateByExampleSelective(@Param("record") AppPanelDO record, @Param("example") AppPanelDOExample example);

    int updateByExample(@Param("record") AppPanelDO record, @Param("example") AppPanelDOExample example);

    int updateByPrimaryKeySelective(AppPanelDO record);

    int updateByPrimaryKey(AppPanelDO record);
}