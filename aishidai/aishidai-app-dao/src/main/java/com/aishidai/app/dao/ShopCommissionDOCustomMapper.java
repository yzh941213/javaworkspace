package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.ShopCommissionDO;
import com.aishidai.app.model.pojo.ShopCommissionDOCustom;
import com.aishidai.app.model.query.ShopCommissionQuery;


public interface ShopCommissionDOCustomMapper {

	long insertShopCommissionDO(ShopCommissionDO shopCommissionDO);

	List<ShopCommissionDOCustom> selectShopCommissionDOList(ShopCommissionQuery query);

	long selectShopCommissionDOListCount(ShopCommissionQuery query);
   
}