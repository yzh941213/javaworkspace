package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MakerDOMapper {
    int countByExample(MakerDOExample example);

    int deleteByExample(MakerDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MakerDO record);

    int insertSelective(MakerDO record);

    List<MakerDO> selectByExample(MakerDOExample example);

    MakerDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MakerDO record, @Param("example") MakerDOExample example);

    int updateByExample(@Param("record") MakerDO record, @Param("example") MakerDOExample example);

    int updateByPrimaryKeySelective(MakerDO record);

    int updateByPrimaryKey(MakerDO record);
}