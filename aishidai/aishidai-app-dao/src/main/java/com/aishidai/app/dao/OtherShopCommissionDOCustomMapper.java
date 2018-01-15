package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.OtherShopCommissionDO;
import com.aishidai.app.model.pojo.OtherShopCommissionDOCustom;
import com.aishidai.app.model.query.OtherShopCommissionQuery;


public interface OtherShopCommissionDOCustomMapper {

	int insertOtherShopCommissionDO(OtherShopCommissionDO otherShopCommissionDO);

	List<OtherShopCommissionDOCustom> selectOtherShopCommissionDOList(OtherShopCommissionQuery query);

	long selectOtherShopCommissionDOListCount(OtherShopCommissionQuery query);
    
}