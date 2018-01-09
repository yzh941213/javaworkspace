package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserFeedbackDO;
import com.aishidai.app.model.pojo.UserFeedbackDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFeedbackDOMapper {
    int countByExample(UserFeedbackDOExample example);

    int deleteByExample(UserFeedbackDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFeedbackDO record);

    int insertSelective(UserFeedbackDO record);

    List<UserFeedbackDO> selectByExample(UserFeedbackDOExample example);

    UserFeedbackDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFeedbackDO record, @Param("example") UserFeedbackDOExample example);

    int updateByExample(@Param("record") UserFeedbackDO record, @Param("example") UserFeedbackDOExample example);

    int updateByPrimaryKeySelective(UserFeedbackDO record);

    int updateByPrimaryKey(UserFeedbackDO record);
}