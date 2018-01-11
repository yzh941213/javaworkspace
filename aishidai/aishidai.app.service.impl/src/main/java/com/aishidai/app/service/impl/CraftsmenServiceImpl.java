package com.aishidai.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.CraftsmenDOCustomMapper;
import com.aishidai.app.dao.CraftsmenDOMapper;
import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOExample;
import com.aishidai.app.model.query.CraftsmenQuery;
import com.aishidai.app.service.CraftsmenService;

import java.util.List;

@Service
public class CraftsmenServiceImpl implements CraftsmenService {
	
	@Autowired
	private CraftsmenDOMapper craftsmenDOMapper;
	@Autowired
	private CraftsmenDOCustomMapper craftsmenDOCustomMapper;
	
	public List<CraftsmenDO> queryCraftsmenDOList(CraftsmenQuery query) {
	
		/*return craftsmenDOMapper.queryCraftsmenDOList(query);*/
		return null;
	}

	public CraftsmenDO queryByPrimaryKey(long craftsmenId) {

		return craftsmenDOMapper.selectByPrimaryKey(craftsmenId);
	}
	
	public boolean editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception{
		
		return craftsmenDOMapper.updateByPrimaryKeySelective(craftsmenDO)>0;
	}

	public List<CraftsmenDO> queryCraftsmenDOByDistributorId(long distributorId) {
		
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andDistributorIdEqualTo(distributorId);
		criteria.andIsDeletedEqualTo((byte)0);
		List<CraftsmenDO> list = craftsmenDOMapper.selectByExample(example);
		return list;
	}
	
	public List<CraftsmenDO> queryCraftsmenDOByShopId(long shopId) {
		
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andShopsIdEqualTo(shopId);
		criteria.andIsDeletedEqualTo((byte)0);
		return craftsmenDOMapper.selectByExample(example);
	}
	
	public long addCraftsmenSysUser(CraftsmenDO craftsmenDO) {
		return craftsmenDOMapper.updateByPrimaryKeySelective(craftsmenDO);
	}
	

	public List<CraftsmenDO> queryCraftsmenDOBySysUserId(long sysUserId) {
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(Integer.valueOf(sysUserId+""));
		criteria.andIsDeletedEqualTo((byte)0);
		return craftsmenDOMapper.selectByExample(example);
	}


	public List<CraftsmenDO> queryCraftsmenExist(String craftsmanName,
			String telephone) throws Exception {
		// TODO Auto-generated method stub
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andCraftsmanNameEqualTo(craftsmanName);
		criteria.andTelephoneEqualTo(telephone);
		criteria.andIsDeletedEqualTo((byte)0);
		return craftsmenDOMapper.selectByExample(example);
	}

	public boolean insertCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception {
		// TODO Auto-generated method stub
		return craftsmenDOCustomMapper.insertCraftsmenDO(craftsmenDO) > 0;
	}
	
}
