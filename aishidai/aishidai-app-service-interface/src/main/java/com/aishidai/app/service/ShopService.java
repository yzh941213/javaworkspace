package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.query.QueryShop;
import com.aishidai.app.model.query.ShopsQuery;


@Service
public interface ShopService {

	
	
	ShopsDO queryShopsDOById(long shopsId) throws Exception ;
	
	boolean editShopsDO(ShopsDO ShopsDO) throws Exception ;
	
	List<ShopsDO> queryShopsDOByUserId(long userId) throws Exception ;
	
	List<ShopsDO> queryShopsDOAll(ShopsQuery query) throws Exception ;
	
	
	List<ShopsDO> queryByNameHqOSNLike(String name) throws Exception;
	
	List<ShopsDO> queryByNameHqSNLike(String name) throws Exception;
	
	List<ShopsDO> queryByNameOSNLike(ShopsDO shopsDO) throws Exception;
	
	List<ShopsDO> queryByNameSNLike(ShopsDO shopsDO) throws Exception;
	
	
	List<ShopsDO> queryOtherShopsDOByDistributorId(ShopsQuery query) throws Exception;

	List<ShopsDO> queryShopsDOByDistributorId(ShopsQuery query) throws Exception ;

	List<ShopsDO> queryOtherShopsDOList(ShopsQuery query) throws Exception ;
	
	
	List<ShopsDO> queryShopsDOList(ShopsQuery query) throws Exception ;
	
	List<ShopsDO> selectShopBydistributorId(long distributorId) throws Exception ;
	
	/*List<ShopsDO> queryByNameOthershopLike(ShopsQuery query)throws Exception;*/

	

	ShopsDO queryShopsDOByShopsName(String name) throws Exception;

	List<ShopsDO> queryShopsDOByDeviceId(long deviceId);

	boolean insertShops(ShopsDO shopsDO);

	List<ShopsDO> shopList(QueryShop queryShop);
	
	/*ShopsDO queryByDeviceId(long deviceId) throws Exception;*/

}
