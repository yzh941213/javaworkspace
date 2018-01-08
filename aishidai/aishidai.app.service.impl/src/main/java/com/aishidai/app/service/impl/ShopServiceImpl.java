package com.aishidai.app.service.impl;

import com.zhezhuo.biz.dao.ShopDAO;
import com.zhezhuo.biz.manager.ShopManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ShopDO;
import com.zhezhuo.model.query.ShopQuery;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 店铺/异业，管理类
 * @author 51147
 *
 */
public class ShopServiceImpl implements ShopManager {
	
	@Autowired
	private ShopDAO shopDAO;

	@Override
	public Result<ShopDO> queryShopDOById(long shopId) throws Exception  {
		Result<ShopDO> result = new Result<ShopDO>();
		ShopDO shopDO = shopDAO.queryShopDOById(shopId);
		result.setSuccess(true);
		result.setResult(shopDO);
		return result;
	}

	@Override
	public Result<Long> editShopDO(ShopDO shopDO) throws Exception {
		Result<Long> result = new Result<Long>();
		long row = shopDAO.updateOtherShopORShopDO(shopDO);
		result.setSuccess(true);
		result.setResult(row);
		if (row == 0) {
			result.setSuccess(false);
			result.setErrorInfo("数据操作失败");
		}
		return result;
	}

	@Override
	public Result<Integer> editShopStatus(ShopDO shopDO) throws Exception  {
		Result<Integer> result = new Result<Integer>();
		int row = shopDAO.updateShopDOStatus(shopDO);
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}
	//审核
	@Override
	public Result<Integer> editShopAudit(ShopDO shopDO)  throws Exception {
		Result<Integer> result = new Result<Integer>();
	
		int row = shopDAO.updateShopDOAudit(shopDO);
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		
		return result;
	}


	@Override
	public Result<Integer> editShopIsDeleted(ShopDO shopDO)  throws Exception {
		Result<Integer> result = null;
		int row = shopDAO.updateShopDOIsDeleted(shopDO);
		result = new Result<Integer>();
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		
		return result;
	}

	@Override
	public Result<Long> editShopSysUserId(ShopDO shopDO) throws Exception {
		Result<Long> result = null;
		
		long row = shopDAO.updateShopDOSysUserId(shopDO);
		result = new Result<Long>();
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}

	@Override
	public Result<ShopDO> queryShopDOBySysUserId(Long sysUserId) throws Exception  {
		Result<ShopDO> result = new Result<ShopDO>();
		ShopDO shopDO = shopDAO.queryShopDOBySysUserId(sysUserId);
		result.setSuccess(true);
		result.setResult(shopDO);
		return result;
	}

	@Override
	public Result<List<ShopDO>> queryShopDOUnemployed(ShopDO shopDO) throws Exception  {
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
		
		List<ShopDO> list = shopDAO.queryShopDOUnemployed(shopDO);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		
		return result;
	}
	
	@Override
	public Result<List<ShopDO>> queryShopDOAll(ShopQuery query) throws Exception  {
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
     
        List<ShopDO> list = shopDAO.queryShopDOAll(query);
        if (list.isEmpty() || list == null) {
            list = new ArrayList<ShopDO>();
        }
        result.setResult(list);
        result.setSuccess(true);
        return result;
	}

	@Override
	public Result<List<ShopDO>> queryShopNameBydistributorId(long distributorId) throws Exception  {
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
		
		List<ShopDO> list = shopDAO.queryShopNameBydistributorId(distributorId);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		
		return result;
		
	}

	/*@Override
	public ShopDO queryShopDOByShopsName(String shopsName) throws Exception {
		// TODO Auto-generated method stub
		ShopDO shopDO = shopDAO.queryShopDOByShopsName(shopsName);
		return shopDO;
	}*/

	@Override
	public List<ShopDO> queryByNameshopLike(String shopsName) throws Exception{
		// TODO Auto-generated method stub
		List<ShopDO> list = shopDAO.queryByNameshopLike(shopsName);
		return list;
	}

	@Override
	public Result<List<ShopDO>> queryOtherShopDOByDistributorId(
			ShopQuery query) throws Exception {
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
		
		List<ShopDO> list = shopDAO.queryOtherShopDOByDistributorId(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}

	
	
	
	
	@Override
	public Result<List<ShopDO>> queryShopDOByDistributorId(ShopQuery query) throws Exception {
		// TODO Auto-generated method stub
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
		List<ShopDO> list = shopDAO.queryShopDOByDistributorId(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}
	
	@Override
	public Result<List<ShopDO>> queryShopDOList(ShopQuery query) throws Exception {
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
		List<ShopDO> list = shopDAO.queryShopDOList(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}
	@Override
	public Result<List<ShopDO>> queryOtherShopDOList(ShopQuery query) throws Exception {
		// TODO Auto-generated method stub
		Result<List<ShopDO>> result = new Result<List<ShopDO>>();
		List<ShopDO> list = shopDAO.queryOtherShopDOList(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}

	@Override
	public List<ShopDO> queryByNameOthershopLike(ShopQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		List<ShopDO> list = shopDAO.queryByNameOtherShopLike(query);
		return list;
	}

	@Override
	public List<ShopDO> queryByNameShopLike(ShopQuery query) throws Exception {
		// TODO Auto-generated method stub
		List<ShopDO> list = shopDAO.selectByNameShopLike(query);
		return list;
	}

	@Override
	public ShopDO queryByDeviceId(long deviceId)throws Exception  {
		// TODO Auto-generated method stub
		return shopDAO.selectByDeviceId(deviceId);
	}

}
