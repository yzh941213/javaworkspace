package com.aishidai.app.model.query;



public class CraftsmenQuery extends QueryPage {
	
	private Long distributorId;
	private Long shopsId;
	private Long userId;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	public Long getShopsId() {
		return shopsId;
	}
	public void setShopsId(Long shopsId) {
		this.shopsId = shopsId;
	}
	
	
	
}
