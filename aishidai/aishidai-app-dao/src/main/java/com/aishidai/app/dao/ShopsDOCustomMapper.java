package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.ShopsDOCustom;
import com.aishidai.app.model.query.QueryShop;
import com.aishidai.app.model.query.ShopsQuery;


public interface ShopsDOCustomMapper {

	long insertShops(ShopsDO shopsDO);
    
	List<ShopsDO> shopList(QueryShop queryShop);

	List<ShopsDOCustom> selectShopsDOList(ShopsQuery query);

	long selectShopsDOListCount(ShopsQuery query);

	ShopsDOCustom selectByPrimaryKey(long id);
}