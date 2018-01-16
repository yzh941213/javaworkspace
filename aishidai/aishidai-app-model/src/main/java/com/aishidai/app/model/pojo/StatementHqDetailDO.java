package com.aishidai.app.model.pojo;

import java.util.List;


//总部的查询详情报表的javabean
public class StatementHqDetailDO {

	private long userId;
	private long orderNum;//订单编号
	private long orderCreatTime;//订单创建时间
	private String buyDitch;//购买渠道，IOS app,Android app,微商城

	private Double totalMoney;//消费总额
	private Double distributorMonry;//经销商分成总额
	private Double shopMoney;//店铺分成总额
	private Double makerMoney;//创客分成总额
	private String othersName;//异业店铺名称
	private Double othershopMoney;//异业店铺分成总额
	
	private List<ItemsDetail> details;
	
	public List<ItemsDetail> getDetails() {
		return details;
	}
	public void setDetails(List<ItemsDetail> details) {
		this.details = details;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public long getOrderCreatTime() {
		return orderCreatTime;
	}
	public void setOrderCreatTime(long orderCreatTime) {
		this.orderCreatTime = orderCreatTime;
	}
	public String getBuyDitch() {
		return buyDitch;
	}
	public void setBuyDitch(String buyDitch) {
		this.buyDitch = buyDitch;
	}
	
	
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public Double getDistributorMonry() {
		return distributorMonry;
	}
	public void setDistributorMonry(Double distributorMonry) {
		this.distributorMonry = distributorMonry;
	}
	public Double getShopMoney() {
		return shopMoney;
	}
	public void setShopMoney(Double shopMoney) {
		this.shopMoney = shopMoney;
	}
	public Double getMakerMoney() {
		return makerMoney;
	}
	public void setMakerMoney(Double makerMoney) {
		this.makerMoney = makerMoney;
	}
	public String getOthersName() {
		return othersName;
	}
	public void setOthersName(String othersName) {
		this.othersName = othersName;
	}
	public Double getOthershopMoney() {
		return othershopMoney;
	}
	public void setOthershopMoney(Double othershopMoney) {
		this.othershopMoney = othershopMoney;
	}
	
}
