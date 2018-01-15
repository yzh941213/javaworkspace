package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AppPanelContentDO;
import com.aishidai.app.model.pojo.AppPanelContentDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppPanelContentDOMapper {
    int countByExample(AppPanelContentDOExample example);

    int deleteByExample(AppPanelContentDOExample example);

    int deleteByPrimaryKey(Long panelContentId);

    int insert(AppPanelContentDO record);

    int insertSelective(AppPanelContentDO record);

    List<AppPanelContentDO> selectByExample(AppPanelContentDOExample example);

    AppPanelContentDO selectByPrimaryKey(Long panelContentId);

    int updateByExampleSelective(@Param("record") AppPanelContentDO record, @Param("example") AppPanelContentDOExample example);

    int updateByExample(@Param("record") AppPanelContentDO record, @Param("example") AppPanelContentDOExample example);

    int updateByPrimaryKeySelective(AppPanelContentDO record);

    int updateByPrimaryKey(AppPanelContentDO record);
}