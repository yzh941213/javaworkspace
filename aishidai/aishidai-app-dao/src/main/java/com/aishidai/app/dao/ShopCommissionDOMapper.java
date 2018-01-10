package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ShopCommissionDO;
import com.aishidai.app.model.pojo.ShopCommissionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCommissionDOMapper {
    int countByExample(ShopCommissionDOExample example);

    int deleteByExample(ShopCommissionDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopCommissionDO record);

    int insertSelective(ShopCommissionDO record);

    List<ShopCommissionDO> selectByExample(ShopCommissionDOExample example);

    ShopCommissionDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopCommissionDO record, @Param("example") ShopCommissionDOExample example);

    int updateByExample(@Param("record") ShopCommissionDO record, @Param("example") ShopCommissionDOExample example);

    int updateByPrimaryKeySelective(ShopCommissionDO record);

    int updateByPrimaryKey(ShopCommissionDO record);
}