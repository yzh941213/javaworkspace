package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.member;

public interface memberMapper {
    int deleteByPrimaryKey(Long memberId);

    int insert(member record);

    int insertSelective(member record);

    member selectByPrimaryKey(Long memberId);

    int updateByPrimaryKeySelective(member record);

    int updateByPrimaryKey(member record);
}