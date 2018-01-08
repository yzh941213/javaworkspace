package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MemberDO;

public interface MemberDOMapper {
    int deleteByPrimaryKey(Long memberId);

    int insert(MemberDO record);

    int insertSelective(MemberDO record);

    MemberDO selectByPrimaryKey(Long memberId);

    int updateByPrimaryKeySelective(MemberDO record);

    int updateByPrimaryKey(MemberDO record);
}