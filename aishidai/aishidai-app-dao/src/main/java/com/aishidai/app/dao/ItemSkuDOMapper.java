package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ItemSkuDO;
import com.aishidai.app.model.pojo.ItemSkuDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemSkuDOMapper {
    int countByExample(ItemSkuDOExample example);

    int deleteByExample(ItemSkuDOExample example);

    int deleteByPrimaryKey(Long skuId);

    int insert(ItemSkuDO record);

    int insertSelective(ItemSkuDO record);

    List<ItemSkuDO> selectByExample(ItemSkuDOExample example);

    ItemSkuDO selectByPrimaryKey(Long skuId);

    int updateByExampleSelective(@Param("record") ItemSkuDO record, @Param("example") ItemSkuDOExample example);

    int updateByExample(@Param("record") ItemSkuDO record, @Param("example") ItemSkuDOExample example);

    int updateByPrimaryKeySelective(ItemSkuDO record);

    int updateByPrimaryKey(ItemSkuDO record);
}