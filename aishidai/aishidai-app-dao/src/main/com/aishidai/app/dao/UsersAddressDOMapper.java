package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UsersAddressDO;

public interface UsersAddressDOMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(UsersAddressDO record);

    int insertSelective(UsersAddressDO record);

    UsersAddressDO selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(UsersAddressDO record);

    int updateByPrimaryKey(UsersAddressDO record);
}