package com.aishidai.app.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.DeviceMakerDOCustomMapper;
import com.aishidai.app.dao.DeviceMakerDOMapper;
import com.aishidai.app.dao.MakerDOCustomMapper;
import com.aishidai.app.dao.MakerDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.DeviceMakerDOExample;
import com.aishidai.app.model.pojo.DistributorDOExample;
import com.aishidai.app.model.pojo.MakerDO;
import com.aishidai.app.model.pojo.MakerDOCustom;
import com.aishidai.app.model.pojo.MakerDOExample;
import com.aishidai.app.model.query.DeviceMakerQuery;
import com.aishidai.app.model.query.MakerQuery;
import com.aishidai.app.service.MakerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakerServiceImpl implements MakerService {
	@Autowired
	private MakerDOMapper makerDOMapper;
	@Autowired
	private MakerDOCustomMapper makerDOCustomMapper;
	@Autowired
	private DeviceMakerDOMapper deviceMakerDOMapper;
	@Autowired
	private DeviceMakerDOCustomMapper deviceMakerDOCustomMapper;
	public List<MakerDO> queryMakerDOList(MakerQuery query) {
//		return makerDOMapper.queryMakerDOList(query);
		return null;
	}

	
	public MakerDOCustom queryMakerDOById(long id) {
		return makerDOCustomMapper.selectByPrimaryKey(id);
	}

	
	public boolean editMakerDO(MakerDO makerDO) {
		return makerDOMapper.updateByPrimaryKeySelective(makerDO) > 0;
	}
	
	public List<MakerDO> queryMakerDOByDistributorId(long distributorId) {
		
		MakerDOExample example = new MakerDOExample();
		MakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andDistributorIdEqualTo(distributorId);
		criteria.andStatusEqualTo(0);
		return makerDOMapper.selectByExample(example);
	}

	public List<MakerDO> queryMakerDOAll() {
		MakerDOExample example = new MakerDOExample();
		MakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
        return makerDOMapper.selectByExample(null);
	}
	
	public List<MakerDO> queryMakerDOByNameLike(MakerDO makerDO) throws Exception {
		MakerDOExample example = new MakerDOExample();
		MakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
		
		String name = null;
		if (StringUtils.isNotBlank(makerDO.getName())) {
			name = "%" + makerDO.getName() + "%";
		}
		if (StringUtils.isNotBlank(name)) {
			criteria.andNameLike(name);
			criteria.andDistributorIdEqualTo(makerDO.getDistributorId());
		}
		return makerDOMapper.selectByExample(example);
	}
	
	public boolean addDeviceMaker(List<DeviceMakerDO> list,long userId,
			long makerId) throws Exception {
		
		DeviceMakerDO deviceMakerDO = new DeviceMakerDO();
		long result_row = 0;
	
		DeviceMakerDOExample example = new DeviceMakerDOExample();
		DeviceMakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andMakerIdEqualTo(makerId);
		
		List<DeviceMakerDO> list_maker = deviceMakerDOMapper.selectByExample(example);
		for (int i = 0; i < list_maker.size(); i++) {
			criteria.andMakerIdEqualTo(makerId);
			int result_ = deviceMakerDOMapper.deleteByExample(example);
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCreateId(userId);
			list.get(i).setIsDelete(0);
			list.get(i).setMakerId(makerId);
			result_row = deviceMakerDOCustomMapper.insetDeviceMaker(deviceMakerDO);
		}
		return result_row <= 0 ? false:true;
	}

	/*
	public List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker)
			throws Exception {
		
		return makerDOMapper.selectDeviceMaker(query_maker);
	}
	*/
	
	public List<MakerDO> queryMakerDOBySysUserId(long userId) {
		MakerDOExample example = new MakerDOExample();
		MakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(userId);
		criteria.andStatusEqualTo(0);
		return makerDOMapper.selectByExample(example);
	}



	public long insertMaker(MakerDO makerDO) {
		return makerDOCustomMapper.insertMaker(makerDO);
	}


	public boolean editDeviceMaker(List<DeviceMakerDO> list, long userId,
			long id) {
		DeviceMakerDO deviceMakerDO = new DeviceMakerDO();
		long result_row = 0;
	
		DeviceMakerDOExample example = new DeviceMakerDOExample();
		DeviceMakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andMakerIdEqualTo(id);
		
		List<DeviceMakerDO> list_maker = deviceMakerDOMapper.selectByExample(example);
		for (int i = 0; i < list_maker.size(); i++) {
			criteria.andMakerIdEqualTo(id);
			int result_ = deviceMakerDOMapper.deleteByExample(example);
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCreateId(userId);
			list.get(i).setIsDelete(0);
			list.get(i).setMakerId(id);
			result_row = deviceMakerDOCustomMapper.insetDeviceMaker(deviceMakerDO);
		}
		return result_row <= 0 ? false:true;
	}

}
