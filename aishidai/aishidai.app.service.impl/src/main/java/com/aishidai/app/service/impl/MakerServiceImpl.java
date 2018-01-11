package com.aishidai.app.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.MakerDOCustomMapper;
import com.aishidai.app.dao.MakerDOMapper;
import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.DistributorDOExample;
import com.aishidai.app.model.pojo.MakerDO;
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
	
	public List<MakerDO> queryMakerDOList(MakerQuery query) {
//		return makerDOMapper.queryMakerDOList(query);
		return null;
	}

	
	public MakerDO queryMakerDOById(long id) {
		return makerDOMapper.selectByPrimaryKey(id);
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
	
	public List<MakerDO> queryMakerDOByNameLike(String name) throws Exception {
		MakerDOExample example = new MakerDOExample();
		MakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
		if (StringUtils.isNotBlank(name)) {
			name = "%" + name + "%";
		}
		if (StringUtils.isNotBlank(name)) {
			criteria.andNameLike(name);
		}

		return makerDOMapper.selectByExample(example);
	}
	
	/*public boolean addDeviceMaker(List<DeviceMakerDO> list,long sysUserId,long makerId) throws Exception {
		// TODO Auto-generated method stub
		DeviceMakerDO deviceMakerDO = new DeviceMakerDO();
		long result_row = 0;
		if (makerId == 0) {
			for (int i = 0; i < list.size(); i++) {
				deviceMakerDO = list.get(i);
				deviceMakerDO.setCreateId(sysUserId);
				deviceMakerDO.setDeleteIs(0);
				result_row = makerDOMapper.insetDeviceMaker(deviceMakerDO);
			}
		}else{
			DeviceMakerQuery query = new DeviceMakerQuery();
			query.setMakerId(makerId);
			List<DeviceMakerDO> list_maker = makerDOMapper.selectDeviceMaker(query);
			for (int i = 0; i < list_maker.size(); i++) {
				makerDOMapper.delDeviceMaker(list_maker.get(i));
			}
			for (int i = 0; i < list.size(); i++) {
				deviceMakerDO = list.get(i);
				deviceMakerDO.setCreateId(sysUserId);
				deviceMakerDO.setDeleteIs(0);
				deviceMakerDO.setMakerId(makerId);
				result_row = makerDOMapper.insetDeviceMaker(deviceMakerDO);
			}
		}
		return result_row == 0 ? false:true;
	}

	
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


	public List<DeviceMakerDO> queryDeviceMaker(DeviceMakerQuery query_maker)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
