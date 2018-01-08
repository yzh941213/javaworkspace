package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.query.ShopQuery;

/**
 * 
 * @author 51147
 *
 */
public interface ShopDAO {
	
	/**
	 * 查询商铺列表（总的）
	 */
	List<ShopDO> queryShopDOList(ShopQuery query) throws Exception;

	/**
	 * 查询经销商下的店铺列表
	 * @param distributorId
	 * @return
	 * @throws Exception
	 */
	List<ShopDO> queryShopDOByDistributorId(ShopQuery query) throws Exception;
	
	/**
	 * 查询经销商下的异业店铺列表
	 * @param distributorId
	 * @return
	 * @throws Exception
	 */
	List<ShopDO> queryOtherShopDOByDistributorId(ShopQuery query) throws Exception;
	
	/**
	 * 查询异业店铺列表（总的）
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ShopDO> queryOtherShopDOList(ShopQuery query) throws Exception;
	
	/**
	 * 修改店铺/异业信息
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	long updateOtherShopORShopDO(ShopDO shopDO) throws Exception;
	
	/**
	 * 根据shopId获取详细
	 * @param shopId
	 * @return
	 * @throws Exception
	 */
	public ShopDO queryShopDOById(long shopId) throws Exception;

	/**
	 * 根据店铺绑定用户的id来查询店铺
	 * @param sysUserId
	 * @return
	 * @throws Exception
	 */
	ShopDO queryShopDOBySysUserId(long sysUserId) throws Exception;
	/**
	 * 修改商铺信息是否可预约
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	int updateShopDOStatus(ShopDO shopDO) throws Exception;
	/**
	 * 审核
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	int updateShopDOAudit(ShopDO shopDO) throws Exception;
	/**
	 * 删除和恢复店铺
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	int updateShopDOIsDeleted(ShopDO shopDO) throws Exception;

	/**
	 * 根据店铺绑定的账号修改信息
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	long updateShopDOSysUserId(ShopDO shopDO) throws Exception;
	/**
	 * 怎么用的？干啥用的
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	List<ShopDO> queryShopDOUnemployed(ShopDO shopDO) throws Exception;

	/**
	 * 查询全部商铺
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ShopDO> queryShopDOAll(ShopQuery query) throws Exception;

	/**
	 * 更改总收入
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	int updateShopDOAmount(ShopDO shopDO) throws Exception;
	/**
	 * 更改余额
	 * @param shopDO
	 * @return
	 * @throws Exception
	 */
	int updateShopDOBalance(ShopDO shopDO) throws Exception ;
	
	/**
	 * 根据店铺名称模糊查询店铺
	 * @param shopName
	 * @return
	 */
	List<ShopDO> queryByNameshopLike(String shopName) throws Exception;
	/**
	 * 查询店铺的数量（包括异业和店铺）
	 */
	long queryShopAndOtherShopCountBydistributorId(long distributorId) throws Exception;
	/**
	 * 
	 * @return
	 */
	long queryShopAndOtherShopCount() throws Exception;

	/**
	 * 根据distributorId查询旗下的所有店铺
	 * @param distributorId
	 * @return
	 */
	List<ShopDO> queryShopNameBydistributorId(long distributorId)throws Exception ;

	List<ShopDO> queryByNameOtherShopLike(ShopQuery query) throws Exception;

	List<ShopDO> selectByNameShopLike(ShopQuery query) throws Exception;

	ShopDO selectByDeviceId(long deviceId) throws Exception;
}
