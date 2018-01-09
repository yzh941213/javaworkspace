package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.PersonalUrlDO;
import com.aishidai.app.model.pojo.PersonalUrlDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonalUrlDOMapper {
    int countByExample(PersonalUrlDOExample example);

    int deleteByExample(PersonalUrlDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PersonalUrlDO record);

    int insertSelective(PersonalUrlDO record);

    List<PersonalUrlDO> selectByExample(PersonalUrlDOExample example);

    PersonalUrlDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PersonalUrlDO record, @Param("example") PersonalUrlDOExample example);

    int updateByExample(@Param("record") PersonalUrlDO record, @Param("example") PersonalUrlDOExample example);

    int updateByPrimaryKeySelective(PersonalUrlDO record);

    int updateByPrimaryKey(PersonalUrlDO record);
}