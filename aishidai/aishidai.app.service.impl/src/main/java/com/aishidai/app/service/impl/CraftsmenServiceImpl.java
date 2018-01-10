package com.aishidai.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.CraftsmenDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.CraftsmenDO;
import com.aishidai.app.model.pojo.CraftsmenDOExample;
import com.aishidai.app.model.query.CraftsmenQuery;
import com.aishidai.app.service.CraftsmenService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CraftsmenServiceImpl implements CraftsmenService {
	
	@Autowired
	private CraftsmenDOMapper craftsmenDOMapper;

	
	public List<CraftsmenDO> queryCraftsmenDOList(CraftsmenQuery query) {
		List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDOMapper.queryCraftsmenDOList(query);
			result = new List<CraftsmenDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<CraftsmenDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public CraftsmenDO queryByPrimaryKey(long craftsmenId) {

		CraftsmenDO craftsmenDO = craftsmenDOMapper.selectByPrimaryKey(Integer
				.valueOf(craftsmenId + ""));

		return craftsmenDO;
	}

	
	public Long editCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception{
		long row = craftsmenDOMapper.updateByPrimaryKeySelective(craftsmenDO);
		return row;
	}

	
	public Integer updateCraftsmenStatus(CraftsmenDO craftsmenDO) {
		Integer> result = null;
		try {
			int row = craftsmenDOMapper.updateCraftsmenDOStatus(craftsmenDO);
			result = new Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Integer updateCraftsmenIsDeleted(CraftsmenDO craftsmenDO) {
		Integer> result = null;
		try {
			int row = craftsmenDOMapper.updateCraftsmenIsDeleted(craftsmenDO);
			result = new Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}
	
	
	public List<CraftsmenDO> queryCraftsmenDOByDistributorId(long distributorId) {
		
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andDistributorIdEqualTo(Integer.valueOf(distributorId + ""));
		List<CraftsmenDO> list = craftsmenDOMapper.selectByExample(example);
		return list;
	}

	
	public List<CraftsmenDO> queryCraftsmenDOByShopId(long shopId) {
		List<CraftsmenDO>> result = null;
		try {
			List<CraftsmenDO> list = craftsmenDOMapper.queryCraftsmenDOByShopId(shopId);
			result = new List<CraftsmenDO>>();
			if (list.isEmpty() || list == null) {
				list = new ArrayList<CraftsmenDO>();
			}
			result.setResult(list);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	
	public Long addCraftsmenSysUser(CraftsmenDO craftsmenDO) {

		long result = craftsmenDOMapper
				.updateByPrimaryKeySelective(craftsmenDO);
		return result;
	}

	
	

	
	public Integer updateCraftsmenAudit(CraftsmenDO craftsmenDO) {
		Integer> result = null;
		try {
			int row = craftsmenDOMapper.updateCraftsmenAudit(craftsmenDO);
			result = new Integer>();
			if (row == 0) {
				result.setSuccess(false);
				return result;
			}
			result.setSuccess(true);
			result.setResult(row);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setErrorInfo(e.getMessage());
			return result;
		}
		return result;
	}

	public List<CraftsmenDO> queryCraftsmenDOBySysUserId(Long sysUserId) {
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(Integer.valueOf(sysUserId+""));
		List<CraftsmenDO> list= craftsmenDOMapper.selectByExample(example);
		return list;
	}


	public List<CraftsmenDO> queryCraftsmenExist(String craftsmanName,
			String telephone) throws Exception {
		// TODO Auto-generated method stub
		CraftsmenDOExample example = new CraftsmenDOExample();
		CraftsmenDOExample.Criteria criteria = example.createCriteria();
		criteria.andCraftsmanNameEqualTo(craftsmanName);
		criteria.andTelephoneEqualTo(telephone);
		List<CraftsmenDO> list = craftsmenDOMapper.selectByExample(example);

		return list;
	}


	public Long insertCraftsmenDO(CraftsmenDO craftsmenDO) throws Exception {
		// TODO Auto-generated method stub
		Long result = craftsmenDOMapper.insertCraftsmenDO(craftsmenDO);
		return result;
	}
	
}
