package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 会员
 * @author Administrator
 *
 */
public class MemberDO implements Serializable{

	private Long memberId;
	private Long userId;
	private Date created;
	private Date update;
	private Integer memberType;
	
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdate() {
		return update;
	}
	public void setUpdate(Date update) {
		this.update = update;
	}
	public Integer getMemberType() {
		return memberType;
	}
	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}
	
	
	
	

}
