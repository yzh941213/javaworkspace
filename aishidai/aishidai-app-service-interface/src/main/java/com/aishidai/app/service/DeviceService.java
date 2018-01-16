package com.aishidai.app.service;

import java.util.List;

import com.aishidai.app.model.pojo.DeviceDO;
import com.aishidai.app.model.query.DeviceQuery;


public interface DeviceService {

	List<DeviceDO> queryDeviceDOList(DeviceQuery query) throws Exception;

	DeviceDO queryDeviceDOById(long deviceId) throws Exception;

	boolean editDeviceDO(DeviceDO deviceDO) throws Exception;

	List<DeviceDO> queryDeviceDOByDistributorId(long distributorId) throws Exception;

	List<DeviceDO> queryDeviceList() throws Exception ;
	
	DeviceDO queryDeviceDOByProductNo(String productNo) throws Exception;
	
	List<DeviceDO> queryDeviceDOLike(String deviceNum) throws Exception;

	List<DeviceDO> queryHqDeviceDOLike(DeviceQuery query) throws Exception;
	
	
}
