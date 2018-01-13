package com.aishidai.app.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.ShopsDOCustomMapper;
import com.aishidai.app.dao.ShopsDOMapper;
import com.aishidai.app.model.pojo.ShopsDO;
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
		criteria.andDeviceIsEqualTo(0);
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
		criteria.andDeviceIsEqualTo(1);
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


	public ShopsDO queryShopsDOByShopsName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ShopsDO> queryShopsDOByDeviceId(long deviceId) {
		ShopsDOExample example = new ShopsDOExample();
		ShopsDOExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceIdEqualTo(deviceId);
		criteria.andIsDeletedEqualTo(0);
		return shopsDOMapper.selectByExample(example);
	}


	public boolean insertShops(ShopsDO shopsDO) {
		return shopsDOCustomMapper.insertShops(shopsDO) >0 ;
	}


	public List<ShopsDO> shopList(QueryShop queryShop) {
		return shopsDOCustomMapper.shopList(queryShop);
	}

}
