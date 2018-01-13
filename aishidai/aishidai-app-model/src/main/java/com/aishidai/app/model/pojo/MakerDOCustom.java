package com.aishidai.app.model.pojo;

import java.util.List;


public class MakerDOCustom extends MakerDO{
	
    private List<DeviceMakerDO> DeviceList;

	public List<DeviceMakerDO> getDeviceList() {
		return DeviceList;
	}

	public void setDeviceList(List<DeviceMakerDO> deviceList) {
		DeviceList = deviceList;
	}
    
}