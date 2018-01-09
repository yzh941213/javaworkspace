package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UsersDO;
import com.aishidai.app.model.pojo.UsersDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersDOMapper {
    int countByExample(UsersDOExample example);

    int deleteByExample(UsersDOExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UsersDO record);

    int insertSelective(UsersDO record);

    List<UsersDO> selectByExample(UsersDOExample example);

    UsersDO selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UsersDO record, @Param("example") UsersDOExample example);

    int updateByExample(@Param("record") UsersDO record, @Param("example") UsersDOExample example);

    int updateByPrimaryKeySelective(UsersDO record);

    int updateByPrimaryKey(UsersDO record);
}