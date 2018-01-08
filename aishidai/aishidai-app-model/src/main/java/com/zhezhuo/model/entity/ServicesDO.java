package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class ServicesDO implements Serializable {
	private Long orderId;
	private String services;
	private String servicesName;
	private Long applyId;
	private String applyIdName;
	private Integer ordersType;
	private Long shopId;
	private String shopIdName;
	private Long usersId;
	private String usersIdName;
	private Date created;
	private String endTime;
	private Integer status;
	private String result;
	private Integer number;
	private String phone;
	
	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getCraftsmenTel() {
		return craftsmenTel;
	}

	public void setCraftsmenTel(String craftsmenTel) {
		this.craftsmenTel = craftsmenTel;
	}

	private String shopTel;
	private String craftsmenTel;
	
	private String distributorIdName;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Integer getOrdersType() {
		return ordersType;
	}

	public void setOrdersType(Integer ordersType) {
		this.ordersType = ordersType;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getUsersId() {
		return usersId;
	}

	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServicesName() {
		return servicesName;
	}

	public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}

	public String getApplyIdName() {
		return applyIdName;
	}

	public void setApplyIdName(String applyIdName) {
		this.applyIdName = applyIdName;
	}

	public String getShopIdName() {
		return shopIdName;
	}

	public void setShopIdName(String shopIdName) {
		this.shopIdName = shopIdName;
	}

	public String getUsersIdName() {
		return usersIdName;
	}

	public void setUsersIdName(String usersIdName) {
		this.usersIdName = usersIdName;
	}

	public String getDistributorIdName() {
		return distributorIdName;
	}

	public void setDistributorIdName(String distributorIdName) {
		this.distributorIdName = distributorIdName;
	}

}
