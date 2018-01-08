package com.zhezhuo.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhezhuo.biz.dao.SubsiteDAO;
import com.zhezhuo.biz.manager.SubsiteManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.SubsiteDO;
import com.zhezhuo.model.query.SubsiteQuery;

import org.springframework.beans.factory.annotation.Autowired;



public class SubsiteManagerImpl implements SubsiteManager {

	@Autowired
	private SubsiteDAO subsiteDAO;

	@Override
	public Result<Integer> editSubsite(SubsiteDO subsiteDO) throws Exception {
		Result<Integer> result = new Result<Integer>();
		Integer consequence = subsiteDAO.editSubsite(subsiteDO);
		//设置返回的结果
		result.setSuccess(true);
		result.setResult(consequence);
		return result;
	}

	@Override
	public SubsiteDO querySubsiteBysubNUM(String subNUM) throws Exception {
		// TODO Auto-generated method stub
		SubsiteDO subsiteDO = subsiteDAO.querySubsiteBysubNUM(subNUM);
		return subsiteDO;
	}
	
	@Override
	public Result<List<SubsiteDO>> querySubsiteByshopsIdList(SubsiteQuery query) throws Exception {
		// TODO Auto-generated method stub
		
		List<SubsiteDO> list = subsiteDAO.querySubsiteByshopsIdList(query);
		Result<List<SubsiteDO>> result = new Result<List<SubsiteDO>>();
		
		if (list.isEmpty() || list == null) {
			//设置不为空
			list = new ArrayList<SubsiteDO>();
		}
		
		result.setSuccess(true);
		result.setResult(list);
		return result;
	}

	@Override
	public List<SubsiteDO> selectSubsiteByShopIds(long shopsId)
			throws Exception {
		List<SubsiteDO> list = subsiteDAO.selectSubsiteByShopIds(shopsId);
		if (list.isEmpty() || list == null) {
			//设置不为空
			list = new ArrayList<SubsiteDO>();
		}
		return list;
	}

	@Override
	public List<SubsiteDO> selectSubsiteList(SubsiteQuery query) {
		// TODO Auto-generated method stub
		List<SubsiteDO> list = subsiteDAO.querySubsiteList(query);
		return list;
	}

	@Override
	public List<SubsiteDO> selectSubsiteByStatus(int status) {
		// TODO Auto-generated method stub
		List<SubsiteDO> list = subsiteDAO.selectSubsiteByStatus(status);
		return list;
	}
}
