package com.aishidai.app.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aishidai.app.dao.DeviceDOMapper;
import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.pojo.DeviceDOExample;
import com.aishidai.app.model.query.DeviceQuery;
import com.aishidai.app.service.DeviceService;



import java.util.List;
@Service
public class DeviceServiceImpl implements DeviceService {
	
	@Autowired
	private DeviceDOMapper deviceDOMapper;

	
	public List<DeviceDO> queryDeviceDOList(DeviceQuery query) throws Exception{
//		return deviceDOMapper.queryDeviceDOList(query);
		return null;
	}
	
	
	public List<DeviceDO> queryDeviceList() throws Exception {
		return deviceDOMapper.selectByExample(null);
	}
	
	public DeviceDO queryDeviceDOById(long deviceId)  throws Exception{
		return deviceDOMapper.selectByPrimaryKey(deviceId);
	}

	
	public boolean editDeviceDO(DeviceDO deviceDO) throws Exception {
		return deviceDOMapper.updateByPrimaryKeySelective(deviceDO)>0;
	}

	
	public List<DeviceDO> queryDeviceDOByDistributorId(long distributorId)throws Exception{
		
		DeviceDOExample example =  new DeviceDOExample();
		DeviceDOExample.Criteria criteria = example.createCriteria();
		criteria.andDistributorIdEqualTo(distributorId);
		return deviceDOMapper.selectByExample(example);
	}

	public List<DeviceDO> queryDeviceDOByProductNo(String productNo) throws Exception {
		DeviceDOExample example =  new DeviceDOExample();
		DeviceDOExample.Criteria criteria = example.createCriteria();
		criteria.andProductNoEqualTo(productNo);
		return deviceDOMapper.selectByExample(example);
	}

	
	public List<DeviceDO> queryDeviceDOLike(String deviceNum) throws Exception{
		// TODO Auto-generated method stub
		DeviceDOExample example =  new DeviceDOExample();
		DeviceDOExample.Criteria criteria = example.createCriteria();
		
		if (StringUtils.isNotBlank(deviceNum)) {
			deviceNum = "%" + deviceNum + "%";
		}
		if (StringUtils.isNotBlank(deviceNum)) {
			criteria.andProductNoLike(deviceNum);
		} 
		return deviceDOMapper.selectByExample(example);
	}


	
	public List<DeviceDO> queryHqDeviceDOLike(DeviceQuery query) throws Exception {
		
		return null;
	}



}
