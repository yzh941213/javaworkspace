package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.MemberDO;
import com.aishidai.app.model.pojo.MemberDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberDOMapper {
    int countByExample(MemberDOExample example);

    int deleteByExample(MemberDOExample example);

    int deleteByPrimaryKey(Long memberId);

    int insert(MemberDO record);

    int insertSelective(MemberDO record);

    List<MemberDO> selectByExample(MemberDOExample example);

    MemberDO selectByPrimaryKey(Long memberId);

    int updateByExampleSelective(@Param("record") MemberDO record, @Param("example") MemberDOExample example);

    int updateByExample(@Param("record") MemberDO record, @Param("example") MemberDOExample example);

    int updateByPrimaryKeySelective(MemberDO record);

    int updateByPrimaryKey(MemberDO record);
}