package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AnnounceDO;
import com.aishidai.app.model.pojo.AnnounceDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnounceDOMapper {
    int countByExample(AnnounceDOExample example);

    int deleteByExample(AnnounceDOExample example);

    int deleteByPrimaryKey(Integer anid);

    int insert(AnnounceDO record);

    int insertSelective(AnnounceDO record);

    List<AnnounceDO> selectByExampleWithBLOBs(AnnounceDOExample example);

    List<AnnounceDO> selectByExample(AnnounceDOExample example);

    AnnounceDO selectByPrimaryKey(Integer anid);

    int updateByExampleSelective(@Param("record") AnnounceDO record, @Param("example") AnnounceDOExample example);

    int updateByExampleWithBLOBs(@Param("record") AnnounceDO record, @Param("example") AnnounceDOExample example);

    int updateByExample(@Param("record") AnnounceDO record, @Param("example") AnnounceDOExample example);

    int updateByPrimaryKeySelective(AnnounceDO record);

    int updateByPrimaryKeyWithBLOBs(AnnounceDO record);

    int updateByPrimaryKey(AnnounceDO record);
}