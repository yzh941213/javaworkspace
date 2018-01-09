package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.FavoriteDO;
import com.aishidai.app.model.pojo.FavoriteDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavoriteDOMapper {
    int countByExample(FavoriteDOExample example);

    int deleteByExample(FavoriteDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FavoriteDO record);

    int insertSelective(FavoriteDO record);

    List<FavoriteDO> selectByExample(FavoriteDOExample example);

    FavoriteDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FavoriteDO record, @Param("example") FavoriteDOExample example);

    int updateByExample(@Param("record") FavoriteDO record, @Param("example") FavoriteDOExample example);

    int updateByPrimaryKeySelective(FavoriteDO record);

    int updateByPrimaryKey(FavoriteDO record);
}