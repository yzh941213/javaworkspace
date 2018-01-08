package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by anli on 2017/11/27.
 */
public class SubsiteDO implements Serializable {

	private static final long serialVersionUID = 1811801437649489503L;

	private Long subId;
	private Long userId;
	private String subNumber;
	private String created;
	private String updated;
	private String subType;
	private Integer status;
	private String expirationStart;
	private String expirationEnd;
	
	private Long shopsId;

	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSubNumber() {
		return subNumber;
	}

	public void setSubNumber(String subNumber) {
		this.subNumber = subNumber;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getExpirationStart() {
		return expirationStart;
	}

	public void setExpirationStart(String expirationStart) {
		this.expirationStart = expirationStart;
	}

	public String getExpirationEnd() {
		return expirationEnd;
	}

	public void setExpirationEnd(String expirationEnd) {
		this.expirationEnd = expirationEnd;
	}
	

	public Long getShopsId() {
		return shopsId;
	}

	public void setShopsId(Long shopsId) {
		this.shopsId = shopsId;
	}
}
