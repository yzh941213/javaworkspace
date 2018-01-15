package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.CommentDO;
import com.aishidai.app.model.pojo.CommentDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentDOMapper {
    int countByExample(CommentDOExample example);

    int deleteByExample(CommentDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentDO record);

    int insertSelective(CommentDO record);

    List<CommentDO> selectByExample(CommentDOExample example);

    CommentDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentDO record, @Param("example") CommentDOExample example);

    int updateByExample(@Param("record") CommentDO record, @Param("example") CommentDOExample example);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKey(CommentDO record);
}