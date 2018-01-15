package com.aishidai.app.model.query;



public class ShopsQuery extends QueryPage {
	
	private Long distributorId;//经销商的ID
	private Long userId;
	private String shopsName;
	private Integer isSuppliers;
	private Integer deviceIs;
	private String telephone;
	private Integer hot;
	private String services;
	private String servicesType;
	
	public String getShopsName() {
		return shopsName;
	}

	public void setShopsName(String shopsName) {
		this.shopsName = shopsName;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Integer getIsSuppliers() {
		return isSuppliers;
	}

	public void setIsSuppliers(Integer isSuppliers) {
		this.isSuppliers = isSuppliers;
	}

	public Integer getDeviceIs() {
		return deviceIs;
	}

	public void setDeviceIs(Integer deviceIs) {
		this.deviceIs = deviceIs;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getServicesType() {
		return servicesType;
	}

	public void setServicesType(String servicesType) {
		this.servicesType = servicesType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
