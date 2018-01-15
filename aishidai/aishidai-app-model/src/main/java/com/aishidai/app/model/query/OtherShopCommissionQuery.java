package com.aishidai.app.model.query;



public class OtherShopCommissionQuery extends QueryPage {
	
	
	private Long distributorId;
	private Integer type;
	private Long otherShopId;
	private Long userId;
	
	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getOtherShopId() {
		return otherShopId;
	}

	public void setOtherShopId(Long otherShopId) {
		this.otherShopId = otherShopId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
