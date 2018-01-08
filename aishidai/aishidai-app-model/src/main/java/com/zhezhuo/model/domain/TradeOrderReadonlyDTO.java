package com.zhezhuo.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by 蝈蝈 on 2016/9/28.
 */
public class TradeOrderReadonlyDTO implements Serializable {

	private Long orderId;

	private String orderNum;

	private String created;

	private String Price;

	private Integer number;

	private int status;

	private String statusDesc;

	private BigDecimal distributorAmount;
	private BigDecimal shopAmount;
	private BigDecimal makerAmount;
	// private BigDecimal craftsmenAmount;
	private BigDecimal sysAmount;
	private Long distributorId;
	private String distributorIdName;
	private Long shopId;
	private String shopIdName;
	private Long makerId;
	private String makerIdName;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public BigDecimal getDistributorAmount() {
		return distributorAmount;
	}

	public void setDistributorAmount(BigDecimal distributorAmount) {
		this.distributorAmount = distributorAmount;
	}

	public BigDecimal getShopAmount() {
		return shopAmount;
	}

	public void setShopAmount(BigDecimal shopAmount) {
		this.shopAmount = shopAmount;
	}

	public BigDecimal getMakerAmount() {
		return makerAmount;
	}

	public void setMakerAmount(BigDecimal makerAmount) {
		this.makerAmount = makerAmount;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getMakerId() {
		return makerId;
	}

	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}

	public BigDecimal getSysAmount() {
		return sysAmount;
	}

	public void setSysAmount(BigDecimal sysAmount) {
		this.sysAmount = sysAmount;
	}

	public String getDistributorIdName() {
		return distributorIdName;
	}

	public void setDistributorIdName(String distributorIdName) {
		this.distributorIdName = distributorIdName;
	}

	public String getShopIdName() {
		return shopIdName;
	}

	public void setShopIdName(String shopIdName) {
		this.shopIdName = shopIdName;
	}

	public String getMakerIdName() {
		return makerIdName;
	}

	public void setMakerIdName(String makerIdName) {
		this.makerIdName = makerIdName;
	}

	// public BigDecimal getCraftsmenAmount() {
	// return craftsmenAmount;
	// }
	//
	// public void setCraftsmenAmount(BigDecimal craftsmenAmount) {
	// this.craftsmenAmount = craftsmenAmount;
	// }

}
