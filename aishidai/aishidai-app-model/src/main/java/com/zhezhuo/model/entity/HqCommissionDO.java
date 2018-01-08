package com.zhezhuo.model.entity;

import java.util.Date;

public class HqCommissionDO {

	private String id;
	private int hqCommission;
	private int distributorCommission;
	private Long distributorId;
	private String distributorName;
	private Long createId;
	private String createName;
	private Date createTime;
	private Date updateTime;
	private int deleteIs;
	
	
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHqCommission() {
		return hqCommission;
	}
	public void setHqCommission(int hqCommission) {
		this.hqCommission = hqCommission;
	}
	public int getDistributorCommission() {
		return distributorCommission;
	}
	public void setDistributorCommission(int distributorCommission) {
		this.distributorCommission = distributorCommission;
	}
	public Long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	public Long getCreateId() {
		return createId;
	}
	public void setCreateId(Long createId) {
		this.createId = createId;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
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
