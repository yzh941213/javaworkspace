package com.aishidai.app.model.query;


public class HqCommissionQuery extends QueryPage{

	private Long distributorId;
	private Long userId;
	
	public Long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
