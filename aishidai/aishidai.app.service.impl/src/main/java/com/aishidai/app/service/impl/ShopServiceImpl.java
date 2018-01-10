package com.aishidai.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.ShopsDOMapper;
import com.aishidai.app.model.pojo.ShopsDOExample;
import com.aishidai.app.service.ShopService;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopsDOMapper shopsDOMapper;

	
	/*public Result<ShopsDO> queryShopsDOById(long shopId) throws Exception  {
		Result<ShopsDO> result = new Result<ShopsDO>();
		ShopsDO ShopsDO = shopsDOMapper.queryShopsDOById(shopId);
		result.setSuccess(true);
		result.setResult(ShopsDO);
		return result;
	}

	
	public Result<Long> editShopsDO(ShopsDO ShopsDO) throws Exception {
		Result<Long> result = new Result<Long>();
		long row = shopsDOMapper.updateOtherShopORShopsDO(ShopsDO);
		result.setSuccess(true);
		result.setResult(row);
		if (row == 0) {
			result.setSuccess(false);
			result.setErrorInfo("数据操作失败");
		}
		return result;
	}

	
	public Result<Integer> editShopStatus(ShopsDO ShopsDO) throws Exception  {
		Result<Integer> result = new Result<Integer>();
		int row = shopsDOMapper.updateShopsDOStatus(ShopsDO);
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}
	//审核
	
	public Result<Integer> editShopAudit(ShopsDO ShopsDO)  throws Exception {
		Result<Integer> result = new Result<Integer>();
	
		int row = shopsDOMapper.updateShopsDOAudit(ShopsDO);
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		
		return result;
	}


	
	public Result<Integer> editShopIsDeleted(ShopsDO ShopsDO)  throws Exception {
		Result<Integer> result = null;
		int row = shopsDOMapper.updateShopsDOIsDeleted(ShopsDO);
		result = new Result<Integer>();
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		
		return result;
	}

	
	public Result<Long> editShopSysUserId(ShopsDO ShopsDO) throws Exception {
		Result<Long> result = null;
		
		long row = shopsDOMapper.updateShopsDOSysUserId(ShopsDO);
		result = new Result<Long>();
		if (row == 0) {
			result.setSuccess(false);
			return result;
		}
		result.setSuccess(true);
		result.setResult(row);
		return result;
	}

	
	

	
	public Result<List<ShopsDO>> queryShopsDOUnemployed(ShopsDO ShopsDO) throws Exception  {
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
		
		List<ShopsDO> list = shopsDOMapper.queryShopsDOUnemployed(ShopsDO);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopsDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		
		return result;
	}
	
	
	public Result<List<ShopsDO>> queryShopsDOAll(ShopsQuery query) throws Exception  {
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
     
        List<ShopsDO> list = shopsDOMapper.queryShopsDOAll(query);
        if (list.isEmpty() || list == null) {
            list = new ArrayList<ShopsDO>();
        }
        result.setResult(list);
        result.setSuccess(true);
        return result;
	}

	
	public Result<List<ShopsDO>> queryShopNameBydistributorId(long distributorId) throws Exception  {
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
		
		List<ShopsDO> list = shopsDOMapper.queryShopNameBydistributorId(distributorId);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopsDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		
		return result;
		
	}

	
	public List<ShopsDO> queryByNameshopLike(String shopsName) throws Exception{
		// TODO Auto-generated method stub
		List<ShopsDO> list = shopsDOMapper.queryByNameshopLike(shopsName);
		return list;
	}

	
	public Result<List<ShopsDO>> queryOtherShopsDOByDistributorId(
			ShopsQuery query) throws Exception {
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
		
		List<ShopsDO> list = shopsDOMapper.queryOtherShopsDOByDistributorId(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopsDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}

	
	
	
	
	
	public Result<List<ShopsDO>> queryShopsDOByDistributorId(ShopsQuery query) throws Exception {
		// TODO Auto-generated method stub
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
		List<ShopsDO> list = shopsDOMapper.queryShopsDOByDistributorId(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopsDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}
	
	
	public Result<List<ShopsDO>> queryShopsDOList(ShopsQuery query) throws Exception {
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
		List<ShopsDO> list = shopsDOMapper.queryShopsDOList(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopsDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}
	
	public Result<List<ShopsDO>> queryOtherShopsDOList(ShopsQuery query) throws Exception {
		// TODO Auto-generated method stub
		Result<List<ShopsDO>> result = new Result<List<ShopsDO>>();
		List<ShopsDO> list = shopsDOMapper.queryOtherShopsDOList(query);
		if (list.isEmpty() || list == null) {
			list = new ArrayList<ShopsDO>();
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}

	
	public List<ShopsDO> queryByNameOthershopLike(ShopsQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		List<ShopsDO> list = shopsDOMapper.queryByNameOtherShopLike(query);
		return list;
	}

	
	public List<ShopsDO> queryByNameShopLike(ShopsQuery query) throws Exception {
		// TODO Auto-generated method stub
		List<ShopsDO> list = shopsDOMapper.selectByNameShopLike(query);
		return list;
	}

	
	public ShopsDO queryByDeviceId(long deviceId)throws Exception  {
		// TODO Auto-generated method stub
		return shopsDOMapper.selectByDeviceId(deviceId);
	}
*/
	
	public List<ShopsDO> queryShopsDOBySysUserId(int sysUserId) throws Exception  {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(sysUserId);
		List<ShopsDO> list= shopsDOMapper.selectByExample(example);
		return list;
	}
	
}
