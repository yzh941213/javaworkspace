package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CraftsmenDOMapper {
    int countByExample(CraftsmenDOExample example);

    int deleteByExample(CraftsmenDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CraftsmenDO record);

    int insertSelective(CraftsmenDO record);

    List<CraftsmenDO> selectByExample(CraftsmenDOExample example);

    CraftsmenDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CraftsmenDO record, @Param("example") CraftsmenDOExample example);

    int updateByExample(@Param("record") CraftsmenDO record, @Param("example") CraftsmenDOExample example);

    int updateByPrimaryKeySelective(CraftsmenDO record);

    int updateByPrimaryKey(CraftsmenDO record);
}