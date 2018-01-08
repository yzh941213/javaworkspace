package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.ShopDAO;
import com.zhezhuo.biz.util.GaodeMapUtil;
import com.zhezhuo.model.GpsDO;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.query.ShopQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class ShopDAOImpl extends BaseDAO implements ShopDAO {
	public List<ShopDO> queryShopDOList(ShopQuery query) throws Exception {
		return null;
	}

	public List<ShopDO> queryShopDOByDistributorId(ShopQuery query) throws Exception {
		return null;
	}

	public List<ShopDO> queryOtherShopDOByDistributorId(ShopQuery query) throws Exception {
		return null;
	}

	public List<ShopDO> queryOtherShopDOList(ShopQuery query) throws Exception {
		return null;
	}

	public long updateOtherShopORShopDO(ShopDO shopDO) throws Exception {
		return 0;
	}

	public ShopDO queryShopDOById(long shopId) throws Exception {
		return null;
	}

	public ShopDO queryShopDOBySysUserId(long sysUserId) throws Exception {
		return null;
	}

	public int updateShopDOStatus(ShopDO shopDO) throws Exception {
		return 0;
	}

	public int updateShopDOAudit(ShopDO shopDO) throws Exception {
		return 0;
	}

	public int updateShopDOIsDeleted(ShopDO shopDO) throws Exception {
		return 0;
	}

	public long updateShopDOSysUserId(ShopDO shopDO) throws Exception {
		return 0;
	}

	public List<ShopDO> queryShopDOUnemployed(ShopDO shopDO) throws Exception {
		return null;
	}

	public List<ShopDO> queryShopDOAll(ShopQuery query) throws Exception {
		return null;
	}

	public int updateShopDOAmount(ShopDO shopDO) throws Exception {
		return 0;
	}

	public int updateShopDOBalance(ShopDO shopDO) throws Exception {
		return 0;
	}

	public List<ShopDO> queryByNameshopLike(String shopName) throws Exception {
		return null;
	}

	public long queryShopAndOtherShopCountBydistributorId(long distributorId) throws Exception {
		return 0;
	}

	public long queryShopAndOtherShopCount() throws Exception {
		return 0;
	}

	public List<ShopDO> queryShopNameBydistributorId(long distributorId) throws Exception {
		return null;
	}

	public List<ShopDO> queryByNameOtherShopLike(ShopQuery query) throws Exception {
		return null;
	}

	public List<ShopDO> selectByNameShopLike(ShopQuery query) throws Exception {
		return null;
	}

	public ShopDO selectByDeviceId(long deviceId) throws Exception {
		return null;
	}
}
