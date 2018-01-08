package com.zhezhuo.biz.dao.impl;

import java.util.List;

import com.zhezhuo.biz.dao.BaseDAO;
import com.zhezhuo.biz.dao.DeviceDAO;
import com.zhezhuo.model.entity.DeviceDO;
import com.zhezhuo.model.query.DeviceQuery;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class DeviceDAOImpl extends BaseDAO implements DeviceDAO {
	public List<DeviceDO> queryDeviceDOList(DeviceQuery query) throws Exception {
		return null;
	}

	public DeviceDO queryDeviceDOById(long deviceId) throws Exception {
		return null;
	}

	public DeviceDO queryDeviceDOByProductNo(String productNo) throws Exception {
		return null;
	}

	public long editDeviceDO(DeviceDO deviceDO) throws Exception {
		return 0;
	}

	public int updateDeviceDOStatus(DeviceDO deviceDO) throws Exception {
		return 0;
	}

	public List<DeviceDO> queryDeviceDOByDistributorId(long distributorId) throws Exception {
		return null;
	}

	public List<DeviceDO> queryDeviceDOUnemployed(DeviceDO deviceDO) throws Exception {
		return null;
	}

	public int updateDeviceDOInvestDrop(DeviceDO deviceDO) throws Exception {
		return 0;
	}

	public int updateDeviceDOInvest(DeviceDO deviceDO) throws Exception {
		return 0;
	}

	public List<DeviceDO> queryDeviceList() throws Exception {
		return null;
	}

	public List<DeviceDO> queryDeviceDOLike(String deviceNum) {
		return null;
	}

	public List<DeviceDO> queryHqDeviceDOLike(DeviceQuery query) {
		return null;
	}
}
