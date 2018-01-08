package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class MakerDO implements Serializable {
	
	private Long id;
	private String name;
	private Long distributorId;
	private String distributorIdName;
	private String mobile;
	private String remark;
	private Date created;
	private Date updated;
	private Integer status;
	private Long sysUserId;
	private Integer orderPercentage;
	private Integer servicePercentage;
	private BigDecimal amount;
	private BigDecimal balance;
	private Integer audit;
	
	private List<OtherDeviceDO> deviceList;
	


	public List<OtherDeviceDO> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<OtherDeviceDO> deviceList) {
		this.deviceList = deviceList;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getDistributorIdName() {
		return distributorIdName;
	}

	public void setDistributorIdName(String distributorIdName) {
		this.distributorIdName = distributorIdName;
	}

	public Integer getOrderPercentage() {
		return orderPercentage;
	}

	public void setOrderPercentage(Integer orderPercentage) {
		this.orderPercentage = orderPercentage;
	}

	public Integer getServicePercentage() {
		return servicePercentage;
	}

	public void setServicePercentage(Integer servicePercentage) {
		this.servicePercentage = servicePercentage;
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Override
    public String toString() {
        return "Maker{" +
                "id=" + id +
                ", distributorId=" + distributorId +
                ", name='" + name +'\''+
                ", mobile='" + mobile + '\'' +
                ", remark='" + remark + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", status='" + status + '\'' +
                ", sysUserId=" + sysUserId +
                '}';
    }
}
