package com.aishidai.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.CraftsmenDOCustomMapper;
import com.aishidai.app.dao.CraftsmenDOMapper;
import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOCustom;
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
	
	

	public CraftsmenDO queryByPrimaryKey(long craftsmenId) {

		return craftsmenDOMapper.selectByPrimaryKey(craftsmenId);
	}
	
	public boolean editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception{
		
		return craftsmenDOMapper.updateByPrimaryKeySelective(craftsmenDO)>0;
	}

	public List<CraftsmenDOCustom> queryCraftsmenDOList(CraftsmenQuery query) {
		
		return craftsmenDOCustomMapper.selectCraftsmenDOList(query);
	}
	
	public long addCraftsmenSysUser(CraftsmenDO craftsmenDO) {
		return craftsmenDOMapper.updateByPrimaryKeySelective(craftsmenDO);
	}
	

	public List<CraftsmenDO> queryCraftsmenDOBySysUserId(long sysUserId) {
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(sysUserId);
		criteria.andIsDeletedEqualTo(0);
		return craftsmenDOMapper.selectByExample(example);
	}


	public List<CraftsmenDO> queryCraftsmenExist(String craftsmanName,
			String telephone) throws Exception {
		// TODO Auto-generated method stub
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andCraftsmanNameEqualTo(craftsmanName);
		criteria.andTelephoneEqualTo(telephone);
		criteria.andIsDeletedEqualTo(0);
		return craftsmenDOMapper.selectByExample(example);
	}

	public boolean insertCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception {
		// TODO Auto-generated method stub
		return craftsmenDOCustomMapper.insertCraftsmenDO(craftsmenDO) > 0;
	}

	public CraftsmenDOCustom queryByPrimaryKeyCustom(long craftsmenId) {
		// TODO Auto-generated method stub
		return craftsmenDOCustomMapper.selectByPrimaryKeyCustom(craftsmenId);
	}

	public int selectCraftsmenDOListCount(CraftsmenQuery query) {
		// TODO Auto-generated method stub
		return craftsmenDOCustomMapper.selectCraftsmenDOListCount(query);
	}
	
}
