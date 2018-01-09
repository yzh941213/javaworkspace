package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UsersAddressDO;
import com.aishidai.app.model.pojo.UsersAddressDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersAddressDOMapper {
    int countByExample(UsersAddressDOExample example);

    int deleteByExample(UsersAddressDOExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(UsersAddressDO record);

    int insertSelective(UsersAddressDO record);

    List<UsersAddressDO> selectByExample(UsersAddressDOExample example);

    UsersAddressDO selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") UsersAddressDO record, @Param("example") UsersAddressDOExample example);

    int updateByExample(@Param("record") UsersAddressDO record, @Param("example") UsersAddressDOExample example);

    int updateByPrimaryKeySelective(UsersAddressDO record);

    int updateByPrimaryKey(UsersAddressDO record);
}