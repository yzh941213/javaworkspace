package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MakerCommissionDetailDO;
import com.aishidai.app.model.pojo.MakerCommissionDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MakerCommissionDetailDOMapper {
    int countByExample(MakerCommissionDetailDOExample example);

    int deleteByExample(MakerCommissionDetailDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(MakerCommissionDetailDO record);

    int insertSelective(MakerCommissionDetailDO record);

    List<MakerCommissionDetailDO> selectByExample(MakerCommissionDetailDOExample example);

    MakerCommissionDetailDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MakerCommissionDetailDO record, @Param("example") MakerCommissionDetailDOExample example);

    int updateByExample(@Param("record") MakerCommissionDetailDO record, @Param("example") MakerCommissionDetailDOExample example);

    int updateByPrimaryKeySelective(MakerCommissionDetailDO record);

    int updateByPrimaryKey(MakerCommissionDetailDO record);
}