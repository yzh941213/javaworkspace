package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.PersonalUrlDO;

public interface PersonalUrlDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonalUrlDO record);

    int insertSelective(PersonalUrlDO record);

    PersonalUrlDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonalUrlDO record);

    int updateByPrimaryKey(PersonalUrlDO record);
}