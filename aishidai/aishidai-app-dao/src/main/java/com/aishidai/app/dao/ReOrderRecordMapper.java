package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ReOrderRecord;

public interface ReOrderRecordMapper {
    int deleteByPrimaryKey(Long recordId);

    int insert(ReOrderRecord record);

    int insertSelective(ReOrderRecord record);

    ReOrderRecord selectByPrimaryKey(Long recordId);

    int updateByPrimaryKeySelective(ReOrderRecord record);

    int updateByPrimaryKey(ReOrderRecord record);
}