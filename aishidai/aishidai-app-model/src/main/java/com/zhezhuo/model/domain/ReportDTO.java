package com.zhezhuo.model.domain;

import java.math.BigDecimal;

/**
 * 经销商个数、店铺个数、用户数、创客人数、手艺人数、平台销售额、订单数、服务次数、服务金额、分成、总额、余额。
 * 
 * @author adrian
 * 
 */
public class ReportDTO {

	private Long distributorCount;// 经销商数量
	private Long shopCount;// 店铺数量
	private Long makerCount;// 创客数量
	private Long craftsmenCount;// 手艺人数量

	private Long userCount;// 总用户数
	
	private Long orderCount;// 订单总数
	private BigDecimal salesAmount = new BigDecimal(0);// 销售额
	private Long orderUserCount;// 下单用户总数

	//private Long userCountServices;// 总用户数
	private Long orderCountServices;// 订单总数
	private Long orderUserCountServices;// 下单用户总数
	private BigDecimal servicesAmount = new BigDecimal(0);// 预约支付额

	private BigDecimal mySalesAmount = new BigDecimal(0);// 我的销售分成
	private BigDecimal myServicesAmount = new BigDecimal(0);// 我的服务分成

	private BigDecimal amount = new BigDecimal(0);// 总收入（总资产/总金额）
	private BigDecimal balance = new BigDecimal(0);// 余额

	public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public Long getOrderUserCount() {
		return orderUserCount;
	}

	public void setOrderUserCount(Long orderUserCount) {
		this.orderUserCount = orderUserCount;
	}

//	public Long getUserCountServices() {
//		return userCountServices;
//	}
//
//	public void setUserCountServices(Long userCountServices) {
//		this.userCountServices = userCountServices;
//	}

	public Long getOrderCountServices() {
		return orderCountServices;
	}

	public void setOrderCountServices(Long orderCountServices) {
		this.orderCountServices = orderCountServices;
	}

	public Long getOrderUserCountServices() {
		return orderUserCountServices;
	}

	public void setOrderUserCountServices(Long orderUserCountServices) {
		this.orderUserCountServices = orderUserCountServices;
	}

	public Long getDistributorCount() {
		return distributorCount;
	}

	public void setDistributorCount(Long distributorCount) {
		this.distributorCount = distributorCount;
	}

	public Long getShopCount() {
		return shopCount;
	}

	public void setShopCount(Long shopCount) {
		this.shopCount = shopCount;
	}

	public Long getMakerCount() {
		return makerCount;
	}

	public void setMakerCount(Long makerCount) {
		this.makerCount = makerCount;
	}

	public Long getCraftsmenCount() {
		return craftsmenCount;
	}

	public void setCraftsmenCount(Long craftsmenCount) {
		this.craftsmenCount = craftsmenCount;
	}

	public BigDecimal getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(BigDecimal salesAmount) {
		this.salesAmount = salesAmount;
	}

	public BigDecimal getServicesAmount() {
		return servicesAmount;
	}

	public void setServicesAmount(BigDecimal servicesAmount) {
		this.servicesAmount = servicesAmount;
	}

	public BigDecimal getMySalesAmount() {
		return mySalesAmount;
	}

	public void setMySalesAmount(BigDecimal mySalesAmount) {
			this.mySalesAmount = mySalesAmount;
	}

	public BigDecimal getMyServicesAmount() {
		return myServicesAmount;
	}

	public void setMyServicesAmount(BigDecimal myServicesAmount) {
		this.myServicesAmount = myServicesAmount;
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

}
