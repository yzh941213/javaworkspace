package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.ShopsDOCustom;
import com.aishidai.app.model.query.QueryShop;
import com.aishidai.app.model.query.ShopsQuery;


@Service
public interface ShopService {
	
	ShopsDOCustom queryShopsDOById(long shopsId) throws Exception ;
	
	boolean editShopsDO(ShopsDO ShopsDO) throws Exception ;
	
	List<ShopsDO> queryShopsDOByUserId(long userId) throws Exception ;
	
	List<ShopsDO> queryByNameHqOSNLike(String name) throws Exception;
	
	List<ShopsDO> queryByNameHqSNLike(String name) throws Exception;
	
	List<ShopsDO> queryByNameOSNLike(ShopsDO shopsDO) throws Exception;
	
	List<ShopsDO> queryByNameSNLike(ShopsDO shopsDO) throws Exception;

	List<ShopsDO> queryOtherShopsDOList(ShopsQuery query) throws Exception ;
	
	List<ShopsDOCustom> queryShopsDOList(ShopsQuery query) throws Exception ;
	
	List<ShopsDO> selectShopBydistributorId(long distributorId) throws Exception ;
	
	ShopsDO queryShopsDOByDeviceId(long deviceId);

	boolean insertShops(ShopsDO shopsDO);

	List<ShopsDO> shopList(QueryShop queryShop);

	long queryShopsDOListCount(ShopsQuery shopsQuery);

}
