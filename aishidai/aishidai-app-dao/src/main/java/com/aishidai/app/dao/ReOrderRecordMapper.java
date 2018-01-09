package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ReOrderRecord;
import com.aishidai.app.model.pojo.ReOrderRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReOrderRecordMapper {
    int countByExample(ReOrderRecordExample example);

    int deleteByExample(ReOrderRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(ReOrderRecord record);

    int insertSelective(ReOrderRecord record);

    List<ReOrderRecord> selectByExample(ReOrderRecordExample example);

    ReOrderRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") ReOrderRecord record, @Param("example") ReOrderRecordExample example);

    int updateByExample(@Param("record") ReOrderRecord record, @Param("example") ReOrderRecordExample example);

    int updateByPrimaryKeySelective(ReOrderRecord record);

    int updateByPrimaryKey(ReOrderRecord record);
}