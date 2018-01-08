package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.ReOrderRecordDO;

public interface ReOrderRecordDOMapper {
    int deleteByPrimaryKey(Long recordId);

    int insert(ReOrderRecordDO record);

    int insertSelective(ReOrderRecordDO record);

    ReOrderRecordDO selectByPrimaryKey(Long recordId);

    int updateByPrimaryKeySelective(ReOrderRecordDO record);

    int updateByPrimaryKey(ReOrderRecordDO record);
}