package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.ShopsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopsDOMapper {
    int countByExample(ShopsDOExample example);

    int deleteByExample(ShopsDOExample example);

    int deleteByPrimaryKey(Long shopsId);

    int insert(ShopsDO record);

    int insertSelective(ShopsDO record);

    List<ShopsDO> selectByExample(ShopsDOExample example);

    ShopsDO selectByPrimaryKey(Long shopsId);

    int updateByExampleSelective(@Param("record") ShopsDO record, @Param("example") ShopsDOExample example);

    int updateByExample(@Param("record") ShopsDO record, @Param("example") ShopsDOExample example);

    int updateByPrimaryKeySelective(ShopsDO record);

    int updateByPrimaryKey(ShopsDO record);
}