package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserSizeDO;
import com.aishidai.app.model.pojo.UserSizeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSizeDOMapper {
    int countByExample(UserSizeDOExample example);

    int deleteByExample(UserSizeDOExample example);

    int deleteByPrimaryKey(Long sizeId);

    int insert(UserSizeDO record);

    int insertSelective(UserSizeDO record);

    List<UserSizeDO> selectByExample(UserSizeDOExample example);

    UserSizeDO selectByPrimaryKey(Long sizeId);

    int updateByExampleSelective(@Param("record") UserSizeDO record, @Param("example") UserSizeDOExample example);

    int updateByExample(@Param("record") UserSizeDO record, @Param("example") UserSizeDOExample example);

    int updateByPrimaryKeySelective(UserSizeDO record);

    int updateByPrimaryKey(UserSizeDO record);
}