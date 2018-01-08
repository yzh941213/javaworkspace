package com.zhezhuo.biz.manager;

import java.util.List;

import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.query.DeviceQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public interface DeviceManager {

	public Result<List<DeviceDO>> queryDeviceDOList(DeviceQuery query);

	public Result<DeviceDO> queryDeviceDOById(long deviceId);

	public Result<Long> editDeviceDO(DeviceDO deviceDO);

	public Result<Integer> updateDeviceStatus(DeviceDO deviceDO);

	public Result<List<DeviceDO>> queryDeviceDOByDistributorId(long distributorId);

	public Result<List<DeviceDO>> queryDeviceList() throws Exception ;
	
	public Result<List<DeviceDO>> queryDeviceDOUnemployed(DeviceDO deviceDO);

	public Result<Integer> updateDeviceDOInvest(DeviceDO deviceDO);

	public Result<Integer> updateDeviceDOInvestDrop(DeviceDO deviceDO);

	public Result<DeviceDO> queryDeviceDOByProductNo(String productNo);
	
	public Result<List<DeviceDO>> queryDeviceDOLike(String deviceNum);

	public Result<List<DeviceDO>> queryHqDeviceDOLike(DeviceQuery query);
	
	
}
