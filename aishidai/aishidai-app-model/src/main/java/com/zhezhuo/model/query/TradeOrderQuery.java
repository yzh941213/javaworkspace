package com.zhezhuo.model.query;

import java.io.Serializable;
import java.math.BigDecimal;

import com.zhezhuo.model.Query;
import com.zhezhuo.model.util.CacheKeyBuilder;

/**
 * Created by Shaka on 15/6/9.
 */
public class TradeOrderQuery extends Query implements Serializable, CacheKeyBuilder {

	private int statuss;
	private String orderNum;
	private int statusEx;
	private int reverseStatus;
	private String trackingNum;
	private String expressCompany;
	private long orderId;
	private long sellerUserId;
	private String remarks;
	private String search;
	
	private long updated;

	private Long distributorId;
	private Long shopId;
	private Long makerId;
	private String deviceNo;
    private Long buyerUserId;
	private BigDecimal distributorAmount;
	private BigDecimal shopAmount;
	private BigDecimal makerAmount;
	private BigDecimal sysAmount;
	private Long shipTime;

	public Long getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
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

	public BigDecimal getSysAmount() {
		return sysAmount;
	}

	public void setSysAmount(BigDecimal sysAmount) {
		this.sysAmount = sysAmount;
	}

	public long getUpdated() {
		return updated;
	}

	public void setUpdated(long updated) {
		this.updated = updated;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public int getStatuss() {
		return statuss;
	}

	public void setStatuss(int statuss) {
		this.statuss = statuss;
	}

	public int getStatusEx() {
		return statusEx;
	}

	public void setStatusEx(int statusEx) {
		this.statusEx = statusEx;
	}

	public int getReverseStatus() {
		return reverseStatus;
	}

	public void setReverseStatus(int reverseStatus) {
		this.reverseStatus = reverseStatus;
	}

	public String getTrackingNum() {
		return trackingNum;
	}

	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(long sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * 根据T来生成key
	 *
	 * @param o
	 * @return
	 */
	@Override
	public String getCacheKey(Object o) {
		return null;
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

	/**
	 * 一般是根据self来生成key
	 *
	 * @return
	 */
	@Override
	public String getCacheKey() {
		return null;
	}

	public Long getShipTime() {
		return shipTime;
	}

	public void setShipTime(Long shipTime) {
		this.shipTime = shipTime;
	}

}
