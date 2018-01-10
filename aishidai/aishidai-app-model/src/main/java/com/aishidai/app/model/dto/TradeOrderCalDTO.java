package com.aishidai.app.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TradeOrderCalDTO {
	private Long tradeOrderId;
	private BigDecimal amount;
	private Date tradeOrderDate;// 订单时间
	private Long percentageId;
	private Long userId;

	private Integer type;// 1购物 2服务
	private Long distributorId;
	private Long makerId;
	private Long shopsId;
	private Long craftsmenId;
	private Long sys;

	private BigDecimal distributorAmount;
	private BigDecimal makerAmount;
	private BigDecimal shopsAmount;
	private BigDecimal craftsmenAmount;
	private BigDecimal sysAmount;
	private Integer status;// -1取消 0正常

	private Date created;
	private Date updated;

	public Long getTradeOrderId() {
		return tradeOrderId;
	}

	public void setTradeOrderId(Long tradeOrderId) {
		this.tradeOrderId = tradeOrderId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getTradeOrderDate() {
		return tradeOrderDate;
	}

	public void setTradeOrderDate(Date tradeOrderDate) {
		this.tradeOrderDate = tradeOrderDate;
	}

	public Long getPercentageId() {
		return percentageId;
	}

	public void setPercentageId(Long percentageId) {
		this.percentageId = percentageId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Long getMakerId() {
		return makerId;
	}

	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}

	public Long getShopsId() {
		return shopsId;
	}

	public void setShopsId(Long shopsId) {
		this.shopsId = shopsId;
	}

	public Long getCraftsmenId() {
		return craftsmenId;
	}

	public void setCraftsmenId(Long craftsmenId) {
		this.craftsmenId = craftsmenId;
	}

	public Long getSys() {
		return sys;
	}

	public void setSys(Long sys) {
		this.sys = sys;
	}

	public BigDecimal getDistributorAmount() {
		return distributorAmount;
	}

	public void setDistributorAmount(BigDecimal distributorAmount) {
		this.distributorAmount = distributorAmount;
	}

	public BigDecimal getMakerAmount() {
		return makerAmount;
	}

	public void setMakerAmount(BigDecimal makerAmount) {
		this.makerAmount = makerAmount;
	}

	public BigDecimal getShopsAmount() {
		return shopsAmount;
	}

	public void setShopsAmount(BigDecimal shopsAmount) {
		this.shopsAmount = shopsAmount;
	}

	public BigDecimal getCraftsmenAmount() {
		return craftsmenAmount;
	}

	public void setCraftsmenAmount(BigDecimal craftsmenAmount) {
		this.craftsmenAmount = craftsmenAmount;
	}

	public BigDecimal getSysAmount() {
		return sysAmount;
	}

	public void setSysAmount(BigDecimal sysAmount) {
		this.sysAmount = sysAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}
