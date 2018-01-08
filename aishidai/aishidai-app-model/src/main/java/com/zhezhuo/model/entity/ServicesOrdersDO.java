package com.zhezhuo.model.entity;

import java.util.Date;

public class ServicesOrdersDO {

	private Long id;
	private Long orderId;
	private Long sellerUserId;
	private Long buyerUserId;
	private String price;
	private int created;
	private int updated;
	private int payType;
	private int payTime;
	private int status;
	
	
	
	public Long getId() {
		return id;
	}
	public int getCreated() {
		return created;
	}
	public void setCreated(int created) {
		this.created = created;
	}
	public int getUpdated() {
		return updated;
	}
	public void setUpdated(int updated) {
		this.updated = updated;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getSellerUserId() {
		return sellerUserId;
	}
	public void setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
	}
	public Long getBuyerUserId() {
		return buyerUserId;
	}
	public void setBuyerUserId(Long buyerUserId) {
		this.buyerUserId = buyerUserId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getPayTime() {
		return payTime;
	}
	public void setPayTime(int payTime) {
		this.payTime = payTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
