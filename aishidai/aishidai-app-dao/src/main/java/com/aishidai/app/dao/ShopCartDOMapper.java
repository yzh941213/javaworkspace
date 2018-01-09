package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ShopCartDO;
import com.aishidai.app.model.pojo.ShopCartDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCartDOMapper {
    int countByExample(ShopCartDOExample example);

    int deleteByExample(ShopCartDOExample example);

    int deleteByPrimaryKey(Long shopCartId);

    int insert(ShopCartDO record);

    int insertSelective(ShopCartDO record);

    List<ShopCartDO> selectByExample(ShopCartDOExample example);

    ShopCartDO selectByPrimaryKey(Long shopCartId);

    int updateByExampleSelective(@Param("record") ShopCartDO record, @Param("example") ShopCartDOExample example);

    int updateByExample(@Param("record") ShopCartDO record, @Param("example") ShopCartDOExample example);

    int updateByPrimaryKeySelective(ShopCartDO record);

    int updateByPrimaryKey(ShopCartDO record);
}