package com.aishidai.app.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.ShopsDOCustomMapper;
import com.aishidai.app.dao.ShopsDOMapper;
import com.aishidai.app.model.pojo.ShopsDO;
import com.aishidai.app.model.pojo.ShopsDOCustom;
import com.aishidai.app.model.pojo.ShopsDOExample;
import com.aishidai.app.model.query.QueryShop;
import com.aishidai.app.model.query.ShopsQuery;
import com.aishidai.app.service.ShopService;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopsDOMapper shopsDOMapper;
	@Autowired
	private ShopsDOCustomMapper shopsDOCustomMapper;
	
	public ShopsDOCustom queryShopsDOById(long id) throws Exception  {
		return shopsDOCustomMapper.selectByPrimaryKey(id);
	}

	
	public boolean editShopsDO(ShopsDO ShopsDO) throws Exception {
		return shopsDOMapper.updateByPrimaryKeySelective(ShopsDO) > 0;
	}
	
	
	public List<ShopsDO> selectShopBydistributorId(long distributorId)
			throws Exception {

		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andDistributorIdEqualTo(distributorId);
		return shopsDOMapper.selectByExample(example);
	}

	
	public List<ShopsDO> queryByNameHqOSNLike(String name) throws Exception{
		
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(name)) {
			criteria.andShopsNameLike("%" + name + "%");
		} 
		criteria.andDeviceIsEqualTo(1);
		criteria.andIsDeletedEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryByNameHqSNLike(String name) throws Exception{
		
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(name)) {
			criteria.andShopsNameLike("%" + name + "%");
		} 
		criteria.andDeviceIsEqualTo(0);
		criteria.andIsDeletedEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryByNameOSNLike(ShopsDO shopsDO) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(shopsDO.getShopsName())) {
			criteria.andShopsNameLike("%" + shopsDO.getShopsName() + "%");
		} 
		criteria.andDeviceIsEqualTo(1);
		criteria.andDistributorIdEqualTo(shopsDO.getDistributorId());
		criteria.andIsDeletedEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryByNameSNLike(ShopsDO shopsDO) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(shopsDO.getShopsName())) {
			criteria.andShopsNameLike("%" + shopsDO.getShopsName() + "%");
		} 
		criteria.andDeviceIsEqualTo(0);
		criteria.andDistributorIdEqualTo(shopsDO.getDistributorId());
		criteria.andIsDeletedEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryOtherShopsDOByDistributorId(long DistributorId) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		criteria.andDistributorIdEqualTo(DistributorId);
		criteria.andDeviceIsEqualTo(1);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryShopsDOByDistributorId(long DistributorId) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		criteria.andDistributorIdEqualTo(DistributorId);
		criteria.andDeviceIsEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	
	public List<ShopsDO> queryShopsDOList() throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		criteria.andDeviceIsEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}
	
	public List<ShopsDO> queryOtherShopsDOList(ShopsQuery query) throws Exception {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		criteria.andDeviceIsEqualTo(1);
		return shopsDOMapper.selectByExample(example);
	}

	public List<ShopsDO> queryShopsDOByUserId(long userId) throws Exception  {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(userId);
		
		return shopsDOMapper.selectByExample(example);
	}

	public List<ShopsDOCustom> queryShopsDOList(ShopsQuery query) throws Exception {
		return shopsDOCustomMapper.selectShopsDOList(query);
	}
	
	public long queryShopsDOListCount(ShopsQuery query) {
		return shopsDOCustomMapper.selectShopsDOListCount(query);
	}
	
	public ShopsDO queryShopsDOByDeviceId(long deviceId) {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceIdEqualTo(deviceId);
	    List<ShopsDO> list = shopsDOMapper.selectByExample(example);
		if (list.isEmpty() && list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}


	public boolean insertShops(ShopsDO shopsDO) {
		return shopsDOCustomMapper.insertShops(shopsDO) >0 ;
	}


	public List<ShopsDO> shopList(QueryShop queryShop) {
		return shopsDOCustomMapper.shopList(queryShop);
	}
}
