package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.util.Date;

public class ShopCommissionDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String createName;

	private int barbershopCommission;

	private int distributorCommission;

	private Long shopId;

	private Long distributorId;
	
	private String distributorName;
	
	private String shopName;
	
	private Long createId;

	private Date createTime;

	private Date updateTime;
	
	private int deleteIs;
	
	private int makerCommission;

	private int type;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	public int getMakerCommission() {
		return makerCommission;
	}

	public void setMakerCommission(int makerCommission) {
		this.makerCommission = makerCommission;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public int getBarbershopCommission() {
		return barbershopCommission;
	}

	public void setBarbershopCommission(int barbershopCommission) {
		this.barbershopCommission = barbershopCommission;
	}

	public int getDistributorCommission() {
		return distributorCommission;
	}

	public void setDistributorCommission(int distributorCommission) {
		this.distributorCommission = distributorCommission;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getDeleteIs() {
		return deleteIs;
	}

	public void setDeleteIs(int deleteIs) {
		this.deleteIs = deleteIs;
	}

}
