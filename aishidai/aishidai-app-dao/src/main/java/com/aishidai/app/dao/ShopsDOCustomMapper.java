package com.aishidai.app.dao;

import java.util.List;

import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.query.QueryShop;


public interface ShopsDOCustomMapper {

	long insertShops(ShopsDO shopsDO);
    
	List<ShopsDO> shopList(QueryShop queryShop);
}