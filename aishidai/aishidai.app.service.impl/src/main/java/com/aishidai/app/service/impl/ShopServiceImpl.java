package com.aishidai.app.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.ShopsDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.ShopsDOExample;
import com.aishidai.app.model.query.ShopsQuery;
import com.aishidai.app.service.ShopService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopsDOMapper shopsDOMapper;

	
	public ShopsDO queryShopsDOById(long id) throws Exception  {
		return shopsDOMapper.selectByPrimaryKey(id);
	}

	
	public boolean editShopsDO(ShopsDO ShopsDO) throws Exception {
		return shopsDOMapper.updateByPrimaryKeySelective(ShopsDO) > 0;
	}
	
	
	public List<ShopsDO> queryShopsDOAll(ShopsQuery query) throws Exception  {
//        return shopsDOMapper.queryShopsDOAll(query);
        return null;
	}

	
	public List<ShopsDO> selectShopBydistributorId(long distributorId)
			throws Exception {

		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andDistributorIdEqualTo(distributorId);
		return shopsDOMapper.selectByExample(example);
	}

	
	public List<ShopsDO> queryByNameshopLike(String shopsName) throws Exception{
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(shopsName)) {
			shopsName = "%" + shopsName + "%";
		}
		if (StringUtils.isNotBlank(shopsName)) {
			criteria.andShopsNameLike(shopsName);
		} 
		return shopsDOMapper.selectByExample(example);
	}

	
	public List<ShopsDO> queryOtherShopsDOByDistributorId(long DistributorId) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo((byte)0);
		criteria.andDistributorIdEqualTo(DistributorId);
		criteria.andDeviceIsEqualTo(1);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryShopsDOByDistributorId(long DistributorId) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo((byte)0);
		criteria.andDistributorIdEqualTo(DistributorId);
		criteria.andDeviceIsEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	
	public List<ShopsDO> queryShopsDOList() throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo((byte)0);
		criteria.andDeviceIsEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryOtherShopsDOList(ShopsQuery query) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo((byte)0);
		criteria.andDeviceIsEqualTo(1);
		return shopsDOMapper.selectByExample(example);
	}

	
	public List<ShopsDO> queryByNameOthershopLike(String name)
			throws Exception {
		
		return null;
	}

	
	/*public List<ShopsDO> queryByNameShopLike(ShopsQuery query) throws Exception {
		// TODO Auto-generated method stub
		List<ShopsDO> list = shopsDOMapper.selectByNameShopLike(query);
		return list;
	}*/

	
	/*public ShopsDO queryByDeviceId(long deviceId)throws Exception  {
		// TODO Auto-generated method stub
		return shopsDOMapper.selectByDeviceId(deviceId);
	}*/
	
	public List<ShopsDO> queryShopsDOBySysUserId(long sysUserId) throws Exception  {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(sysUserId);
		List<ShopsDO> list= shopsDOMapper.selectByExample(example);
		return list;
	}


	public List<ShopsDO> queryOtherShopsDOByDistributorId(ShopsQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ShopsDO> queryShopsDOByDistributorId(ShopsQuery query)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ShopsDO> queryShopsDOList(ShopsQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ShopsDO> queryByNameShopLike(ShopsQuery query) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public ShopsDO queryShopsDOByShopsName(String shopsName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
