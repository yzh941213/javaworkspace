package com.aishidai.app.dao;

import com.aishidai.app.model.pojo.OtherShopCommissionDO;

public interface OtherShopCommissionDOMapper {
    int deleteByPrimaryKey(String id);

    int insert(OtherShopCommissionDO record);

    int insertSelective(OtherShopCommissionDO record);

    OtherShopCommissionDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OtherShopCommissionDO record);

    int updateByPrimaryKey(OtherShopCommissionDO record);
}