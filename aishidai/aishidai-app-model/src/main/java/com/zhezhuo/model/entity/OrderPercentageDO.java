package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分成
 */
public class OrderPercentageDO implements Serializable {

	private Long id;
	private Long orderId;
	private Integer type;
	private Long shopId;
	private Long deviceId;
	private BigDecimal amount;
	private BigDecimal sys;
	private BigDecimal distributor;
	private BigDecimal shop;
	private BigDecimal maker;
	private BigDecimal craftsman;
	private Integer status;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSys() {
		return sys;
	}

	public void setSys(BigDecimal sys) {
		this.sys = sys;
	}

	public BigDecimal getDistributor() {
		return distributor;
	}

	public void setDistributor(BigDecimal distributor) {
		this.distributor = distributor;
	}

	public BigDecimal getShop() {
		return shop;
	}

	public void setShop(BigDecimal shop) {
		this.shop = shop;
	}

	public BigDecimal getMaker() {
		return maker;
	}

	public void setMaker(BigDecimal maker) {
		this.maker = maker;
	}

	public BigDecimal getCraftsman() {
		return craftsman;
	}

	public void setCraftsman(BigDecimal craftsman) {
		this.craftsman = craftsman;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
