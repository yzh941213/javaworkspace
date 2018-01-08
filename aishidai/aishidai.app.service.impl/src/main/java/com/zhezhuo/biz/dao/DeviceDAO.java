package com.zhezhuo.biz.dao;

import java.util.List;

import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.query.DeviceQuery;

/**
 * Created by Shaka on 15/7/5.
 */
public interface DeviceDAO {

	public List<DeviceDO> queryDeviceDOList(DeviceQuery query) throws Exception;

	public DeviceDO queryDeviceDOById(long deviceId) throws Exception;
	
	public DeviceDO queryDeviceDOByProductNo(String productNo) throws Exception;

	public long editDeviceDO(DeviceDO deviceDO) throws Exception;

	public int updateDeviceDOStatus(DeviceDO deviceDO) throws Exception;

	public List<DeviceDO> queryDeviceDOByDistributorId(long distributorId) throws Exception;
	
	public List<DeviceDO> queryDeviceDOUnemployed(DeviceDO deviceDO) throws Exception;

	public int updateDeviceDOInvestDrop(DeviceDO deviceDO) throws Exception;

	public int updateDeviceDOInvest(DeviceDO deviceDO) throws Exception;

	
	public List<DeviceDO> queryDeviceList() throws Exception;

	public List<DeviceDO> queryDeviceDOLike(String deviceNum);

	public List<DeviceDO> queryHqDeviceDOLike(DeviceQuery query);

}
