package com.web.entity;

public class Person {
	private Integer personAutoid;
	private String name;
	private String account;
	private String password;
	private String telphone;
	private String personType;
	
	public Integer getPersonAutoid() {
		return personAutoid;
	}
	public void setPersonAutoid(Integer personAutoid) {
		this.personAutoid = personAutoid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
}
