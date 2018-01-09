package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.pojo.ItemDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemDOMapper {
    int countByExample(ItemDOExample example);

    int deleteByExample(ItemDOExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(ItemDO record);

    int insertSelective(ItemDO record);

    List<ItemDO> selectByExampleWithBLOBs(ItemDOExample example);

    List<ItemDO> selectByExample(ItemDOExample example);

    ItemDO selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") ItemDO record, @Param("example") ItemDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemDO record, @Param("example") ItemDOExample example);

    int updateByExample(@Param("record") ItemDO record, @Param("example") ItemDOExample example);

    int updateByPrimaryKeySelective(ItemDO record);

    int updateByPrimaryKeyWithBLOBs(ItemDO record);

    int updateByPrimaryKey(ItemDO record);
}