package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopDO implements Serializable {
	
	private static final long serialVersionUID = 1552857653404523002L;
	private Long shopsId;
	private String shopsName;
	private Long distributorId;
	private String distributorIdName;
	private String introduce;
	private String shopsUrl;
	private String telephone;
	private Integer hot;
	private String activity;
	private Date created;
	private Date updated;
	private Integer status;
	private Integer isDeleted;
	private Long sysUserId;
	private Integer reserveNumber;
	private String wechatUrl;
	private String province;
	private String city;
	private String address;
	private String area;
	private String shopHoursOpen;
	private String shopHoursClose;
	private String services;
	private String servicesName;
	private String servicesType;
	private String servicesTypeName;
	private Integer audit;
	private Long deviceId;
	private int deviceIs;
	
	private String deviceNum;//返回设备的编号
	
	private String lat;
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public int getDeviceIs() {
		return deviceIs;
	}

	public void setDeviceIs(int deviceIs) {
		this.deviceIs = deviceIs;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	private BigDecimal amount;
	private BigDecimal balance;


	public String getWechatUrl() {
		return wechatUrl;
	}

	public void setWechatUrl(String wechatUrl) {
		this.wechatUrl = wechatUrl;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Long getShopsId() {
		return shopsId;
	}

	public void setShopsId(Long shopsId) {
		this.shopsId = shopsId;
	}

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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getShopsUrl() {
		return shopsUrl;
	}

	public void setShopsUrl(String shopsUrl) {
		this.shopsUrl = shopsUrl;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Integer getReserveNumber() {
		return reserveNumber;
	}

	public void setReserveNumber(Integer reserveNumber) {
		this.reserveNumber = reserveNumber;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShopHoursOpen() {
		return shopHoursOpen;
	}

	public void setShopHoursOpen(String shopHoursOpen) {
		this.shopHoursOpen = shopHoursOpen;
	}

	public String getShopHoursClose() {
		return shopHoursClose;
	}

	public void setShopHoursClose(String shopHoursClose) {
		this.shopHoursClose = shopHoursClose;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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

	public String getServicesName() {
		return servicesName;
	}

	public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}

	public String getServicesTypeName() {
		return servicesTypeName;
	}

	public void setServicesTypeName(String servicesTypeName) {
		this.servicesTypeName = servicesTypeName;
	}

	public String getDistributorIdName() {
		return distributorIdName;
	}

	public void setDistributorIdName(String distributorIdName) {
		this.distributorIdName = distributorIdName;
	}

}
