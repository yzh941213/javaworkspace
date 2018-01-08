package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserSizeDO;

public interface UserSizeDOMapper {
    int deleteByPrimaryKey(Long sizeId);

    int insert(UserSizeDO record);

    int insertSelective(UserSizeDO record);

    UserSizeDO selectByPrimaryKey(Long sizeId);

    int updateByPrimaryKeySelective(UserSizeDO record);

    int updateByPrimaryKey(UserSizeDO record);
}