package com.aishidai.app.model.pojo;

import java.util.List;


public class MakerDOCustom extends MakerDO{
	
    private List<DeviceMakerDO> DeviceList;

    private String distributorName;
    
	public List<DeviceMakerDO> getDeviceList() {
		return DeviceList;
	}

	public void setDeviceList(List<DeviceMakerDO> deviceList) {
		DeviceList = deviceList;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
    
}