package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.query.ShopQuery;

/**
 * 
 * @author 51147
 *
 */
public interface ShopManager {

	
	/**
	 * 根据Id查询商铺
	 */
	public Result<ShopDO> queryShopDOById(long shopId) throws Exception ;
	/**
	 * 修改店铺信息
	 */
	public Result<Long> editShopDO(ShopDO shopDO) throws Exception ;
	/**
	 * 修改店铺是否可预约
	 */
	public Result<Integer> editShopStatus(ShopDO shopDO) throws Exception ;
	/**
	 * 审核处理
	 */
	public Result<Integer> editShopAudit(ShopDO shopDO) throws Exception ;
	/**
	 * 删除和恢复
	 */
	public Result<Integer> editShopIsDeleted(ShopDO shopDO) throws Exception ;
	/**
	 * 
	 */
	public Result<Long> editShopSysUserId(ShopDO shopDO) throws Exception ;
	/**
	 * 根据登录账号查询商铺信息
	 */
	public Result<ShopDO> queryShopDOBySysUserId(Long sysUserId) throws Exception ;
	/**
	 * 不知道为何用？
	 */
	public Result<List<ShopDO>> queryShopDOUnemployed(ShopDO shopDO) throws Exception ;
	/**
	 * 查询所有商铺
	 */
	public Result<List<ShopDO>> queryShopDOAll(ShopQuery query) throws Exception ;
	
	/**
	 * 根据店铺名称模糊查询
	 */
	List<ShopDO> queryByNameshopLike(String shopName) throws Exception;

	/**
	 * 查询经销商下的异业店铺
	 */
	Result<List<ShopDO>> queryOtherShopDOByDistributorId(ShopQuery query) throws Exception;

	
	/**
	 * 查询经销商下的店铺列表
	 */
	Result<List<ShopDO>> queryShopDOByDistributorId(ShopQuery query) throws Exception ;
	/**
	 * 查询全部异业列表
	 */
	Result<List<ShopDO>> queryOtherShopDOList(ShopQuery query) throws Exception ;
	
	/**
	 * 查询全部店铺列表
	 */
	Result<List<ShopDO>> queryShopDOList(ShopQuery query) throws Exception ;
	
	public Result<List<ShopDO>> queryShopNameBydistributorId(long distributorId) throws Exception ;
	
	List<ShopDO> queryByNameOthershopLike(ShopQuery query)throws Exception;

	List<ShopDO> queryByNameShopLike(ShopQuery query) throws Exception;
	/**
	 * 根据店铺名称查询店铺的信息
	 */
//	public ShopDO queryShopDOByShopsName(String shopsName) throws Exception;
	
	public ShopDO queryByDeviceId(long deviceId) throws Exception;
}
