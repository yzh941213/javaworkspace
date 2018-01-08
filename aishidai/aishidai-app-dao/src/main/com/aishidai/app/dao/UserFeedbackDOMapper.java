package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.UserFeedbackDO;

public interface UserFeedbackDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFeedbackDO record);

    int insertSelective(UserFeedbackDO record);

    UserFeedbackDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFeedbackDO record);

    int updateByPrimaryKey(UserFeedbackDO record);
}