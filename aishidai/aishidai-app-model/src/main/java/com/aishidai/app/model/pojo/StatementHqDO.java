package com.aishidai.app.model.pojo;

import java.util.Date;
import java.util.List;

//总部的第一张报表的javabean
public class StatementHqDO {

	private long userId;
	private String memberName;//用户名
	private String registertime;//注册时间
	private String username;//注册手机号
	private String deviceNum;//注册设备号
	private String registerShopName;//注册店铺
	private List<MakerDO> makers;//所属的创客
	private String memberType;
	private String distributorName;//所属的经销商
	private Double serviceMoney;//服务消费总额
	private Double itemMoney;//商品消费额
	private Double totalMoney;//总的消费总额
	
	
	
	
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public String getRegisterShopName() {
		return registerShopName;
	}
	public void setRegisterShopName(String registerShopName) {
		this.registerShopName = registerShopName;
	}
	public List<MakerDO> getMakers() {
		return makers;
	}
	public void setMakers(List<MakerDO> makers) {
		this.makers = makers;
	}
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
	public Double getServiceMoney() {
		return serviceMoney;
	}
	public void setServiceMoney(Double serviceMoney) {
		this.serviceMoney = serviceMoney;
	}
	
	public Double getItemMoney() {
		return itemMoney;
	}
	public void setItemMoney(Double itemMoney) {
		this.itemMoney = itemMoney;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
}
