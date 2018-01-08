package com.zhezhuo.model.entity;

public class ItemsDetail {

	private String itemName;//商品名称
	private Double paymentMoney;//实付总额
	private int buyNum;//购买数量
	private Double discountsMoney;//优惠金额
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(Double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public Double getDiscountsMoney() {
		return discountsMoney;
	}
	public void setDiscountsMoney(Double discountsMoney) {
		this.discountsMoney = discountsMoney;
	}
	
}
