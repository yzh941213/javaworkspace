package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemMetaPropertyDO;
import com.aishidai.app.model.pojo.ItemMetaPropertyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemMetaPropertyDOMapper {
    int countByExample(ItemMetaPropertyDOExample example);

    int deleteByExample(ItemMetaPropertyDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemMetaPropertyDO record);

    int insertSelective(ItemMetaPropertyDO record);

    List<ItemMetaPropertyDO> selectByExample(ItemMetaPropertyDOExample example);

    ItemMetaPropertyDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemMetaPropertyDO record, @Param("example") ItemMetaPropertyDOExample example);

    int updateByExample(@Param("record") ItemMetaPropertyDO record, @Param("example") ItemMetaPropertyDOExample example);

    int updateByPrimaryKeySelective(ItemMetaPropertyDO record);

    int updateByPrimaryKey(ItemMetaPropertyDO record);
}