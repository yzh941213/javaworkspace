package com.aishidai.app.model.pojo;


public class ShopsDOCustom extends ShopsDO{
	
    private String distributorName;
    private String deviceNum;
    
    
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
}