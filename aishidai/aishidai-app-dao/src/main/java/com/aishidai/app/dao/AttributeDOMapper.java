package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.AttributeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeDOMapper {
    int countByExample(AttributeDOExample example);

    int deleteByExample(AttributeDOExample example);

    int deleteByPrimaryKey(Integer attributeId);

    int insert(AttributeDO record);

    int insertSelective(AttributeDO record);

    List<AttributeDO> selectByExample(AttributeDOExample example);

    AttributeDO selectByPrimaryKey(Integer attributeId);

    int updateByExampleSelective(@Param("record") AttributeDO record, @Param("example") AttributeDOExample example);

    int updateByExample(@Param("record") AttributeDO record, @Param("example") AttributeDOExample example);

    int updateByPrimaryKeySelective(AttributeDO record);

    int updateByPrimaryKey(AttributeDO record);

    List<AttributeDO> getAllSubclassByAttrIdI(Integer attributeId);
}