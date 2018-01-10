package com.aishidai.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.query.ShopsQuery;


@Service
public interface ShopService {

	
	
	ShopsDO queryShopsDOById(long shopId) throws Exception ;
	
	Long editShopsDO(ShopsDO ShopsDO) throws Exception ;
	
	Integer editShopStatus(ShopsDO ShopsDO) throws Exception ;
	
	Integer editShopAudit(ShopsDO ShopsDO) throws Exception ;
	
	Integer editShopIsDeleted(ShopsDO ShopsDO) throws Exception ;
	
	Long editShopSysUserId(ShopsDO ShopsDO) throws Exception ;
	
	List<ShopsDO> queryShopsDOBySysUserId(int sysUserId) throws Exception ;
	
	List<ShopsDO> queryShopsDOUnemployed(ShopsDO ShopsDO) throws Exception ;
	
	List<ShopsDO> queryShopsDOAll(ShopsQuery query) throws Exception ;
	
	List<ShopsDO> queryByNameshopLike(String shopName) throws Exception;

	List<ShopsDO> queryOtherShopsDOByDistributorId(ShopsQuery query) throws Exception;

	List<ShopsDO> queryShopsDOByDistributorId(ShopsQuery query) throws Exception ;

	List<ShopsDO> queryOtherShopsDOList(ShopsQuery query) throws Exception ;
	
	
	List<ShopsDO> queryShopsDOList(ShopsQuery query) throws Exception ;
	
	List<ShopsDO> selectShopBydistributorId(long distributorId) throws Exception ;
	
	List<ShopsDO> queryByNameOthershopLike(ShopsQuery query)throws Exception;

	List<ShopsDO> queryByNameShopLike(ShopsQuery query) throws Exception;

	ShopsDO queryShopsDOByShopsName(String shopsName) throws Exception;
	
	ShopsDO queryByDeviceId(long deviceId) throws Exception;

}
