package com.aishidai.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.DeviceMakerDOMapper;
import com.aishidai.app.model.pojo.DeviceMakerDO;
import com.aishidai.app.model.pojo.DeviceMakerDOExample;
import com.aishidai.app.service.DeviceMakerServiec;

@Service
public class DeviceMakerServiecImpl implements DeviceMakerServiec {

	@Autowired
	private DeviceMakerDOMapper deviceMakerDOMapper;
	
	public List<DeviceMakerDO> selectByMakerId(Long id) {
		
		DeviceMakerDOExample example = new DeviceMakerDOExample();
		DeviceMakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andMakerIdEqualTo(id);
		criteria.andIsDeleteEqualTo(0);
		return deviceMakerDOMapper.selectByExample(example);
	}

	public List<DeviceMakerDO> selectBydeviceId(Long id) {
		DeviceMakerDOExample example = new DeviceMakerDOExample();
		DeviceMakerDOExample.Criteria criteria = example.createCriteria();
		criteria.andDeviceIdEqualTo(id);
		criteria.andIsDeleteEqualTo(0);
		return deviceMakerDOMapper.selectByExample(example);
	}

	
	
}
