package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.re_order_record;

public interface re_order_recordMapper {
    int deleteByPrimaryKey(Long recordId);

    int insert(re_order_record record);

    int insertSelective(re_order_record record);

    re_order_record selectByPrimaryKey(Long recordId);

    int updateByPrimaryKeySelective(re_order_record record);

    int updateByPrimaryKey(re_order_record record);
}