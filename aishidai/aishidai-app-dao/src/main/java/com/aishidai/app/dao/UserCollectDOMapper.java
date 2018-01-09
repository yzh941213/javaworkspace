package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserCollectDO;
import com.aishidai.app.model.pojo.UserCollectDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCollectDOMapper {
    int countByExample(UserCollectDOExample example);

    int deleteByExample(UserCollectDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCollectDO record);

    int insertSelective(UserCollectDO record);

    List<UserCollectDO> selectByExample(UserCollectDOExample example);

    UserCollectDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCollectDO record, @Param("example") UserCollectDOExample example);

    int updateByExample(@Param("record") UserCollectDO record, @Param("example") UserCollectDOExample example);

    int updateByPrimaryKeySelective(UserCollectDO record);

    int updateByPrimaryKey(UserCollectDO record);
}