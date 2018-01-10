package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.ShopsDO;
import org.springframework.stereotype.Service;


@Service
public interface ShopService {

	
/*	*//**
	 * 根据Id查询商铺
	 *//*
	public Result<ShopsDO> queryShopsDOById(long shopId) throws Exception ;
	*//**
	 * 修改店铺信息
	 *//*
	public Result<Long> editShopsDO(ShopsDO ShopsDO) throws Exception ;
	*//**
	 * 修改店铺是否可预约
	 *//*
	public Result<Integer> editShopStatus(ShopsDO ShopsDO) throws Exception ;
	*//**
	 * 审核处理
	 *//*
	public Result<Integer> editShopAudit(ShopsDO ShopsDO) throws Exception ;
	*//**
	 * 删除和恢复
	 *//*
	public Result<Integer> editShopIsDeleted(ShopsDO ShopsDO) throws Exception ;
	*//**
	 * 
	 *//*
	public Result<Long> editShopSysUserId(ShopsDO ShopsDO) throws Exception ;*/
	/**
	 * 根据登录账号查询商铺信息
	 */
	List<ShopsDO> queryShopsDOBySysUserId(int sysUserId) throws Exception ;
	/**
	 * 不知道为何用？
	 *//*
	public Result<List<ShopsDO>> queryShopsDOUnemployed(ShopsDO ShopsDO) throws Exception ;
	*//**
	 * 查询所有商铺
	 *//*
	public Result<List<ShopsDO>> queryShopsDOAll(ShopsQuery query) throws Exception ;
	
	*//**
	 * 根据店铺名称模糊查询
	 *//*
	List<ShopsDO> queryByNameshopLike(String shopName) throws Exception;

	*//**
	 * 查询经销商下的异业店铺
	 *//*
	Result<List<ShopsDO>> queryOtherShopsDOByDistributorId(ShopsQuery query) throws Exception;

	
	*//**
	 * 查询经销商下的店铺列表
	 *//*
	Result<List<ShopsDO>> queryShopsDOByDistributorId(ShopsQuery query) throws Exception ;
	*//**
	 * 查询全部异业列表
	 *//*
	Result<List<ShopsDO>> queryOtherShopsDOList(ShopsQuery query) throws Exception ;
	
	*//**
	 * 查询全部店铺列表
	 *//*
	Result<List<ShopsDO>> queryShopsDOList(ShopsQuery query) throws Exception ;
	
	public Result<List<ShopsDO>> queryShopNameBydistributorId(long distributorId) throws Exception ;
	
	List<ShopsDO> queryByNameOthershopLike(ShopsQuery query)throws Exception;

	List<ShopsDO> queryByNameShopLike(ShopsQuery query) throws Exception;
	*//**
	 * 根据店铺名称查询店铺的信息
	 *//*
//	public ShopsDO queryShopsDOByShopsName(String shopsName) throws Exception;
	
	public ShopsDO queryByDeviceId(long deviceId) throws Exception;*/
}
