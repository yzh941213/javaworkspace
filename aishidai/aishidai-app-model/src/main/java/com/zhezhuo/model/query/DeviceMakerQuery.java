package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

public class DeviceMakerQuery extends Query {

	private Long deviceId;
	private Long makerId;
	
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public Long getMakerId() {
		return makerId;
	}
	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}
	
	
	
}
