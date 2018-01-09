package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemSuitDO;
import com.aishidai.app.model.pojo.ItemSuitDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemSuitDOMapper {
    int countByExample(ItemSuitDOExample example);

    int deleteByExample(ItemSuitDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSuitDO record);

    int insertSelective(ItemSuitDO record);

    List<ItemSuitDO> selectByExample(ItemSuitDOExample example);

    ItemSuitDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSuitDO record, @Param("example") ItemSuitDOExample example);

    int updateByExample(@Param("record") ItemSuitDO record, @Param("example") ItemSuitDOExample example);

    int updateByPrimaryKeySelective(ItemSuitDO record);

    int updateByPrimaryKey(ItemSuitDO record);
}