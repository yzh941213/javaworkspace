package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.CraftsmenDO;

public interface CraftsmenDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CraftsmenDO record);

    int insertSelective(CraftsmenDO record);

    CraftsmenDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CraftsmenDO record);

    int updateByPrimaryKey(CraftsmenDO record);
}