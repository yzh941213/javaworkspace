package com.aishidai.app.model.dto;

import java.io.Serializable;
import java.util.List;

public class UsersListDTO implements Serializable{

    private static final long serialVersionUID = -8183369325122025437L;
    private Long userId;
    private String uname;
    private String unick;
    private int sex;
    private String avatar;
    private String trueName;
    private int parentId;
    private int status;
    private List<SubordinateDTO> subordinates;
    private String invitCode;

    private String parentName;
    private int subordCount;

    
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnick() {
        return unick;
    }

    public void setUnick(String unick) {
        this.unick = unick;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getSubordCount() {
        return subordCount;
    }

    public void setSubordCount(int subordCount) {
        this.subordCount = subordCount;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<SubordinateDTO> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<SubordinateDTO> subordinates) {
        this.subordinates = subordinates;
    }

    public String getInvitCode() {
        return invitCode;
    }

    public void setInvitCode(String invitCode) {
        this.invitCode = invitCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UsersListDTO{" +
                "userId=" + userId +
                ", uname='" + uname + '\'' +
                ", unick='" + unick + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", trueName='" + trueName + '\'' +
                ", parentId=" + parentId +
                ", subordinates=" + subordinates +
                ", invitCode='" + invitCode + '\'' +
                ", parentName='" + parentName + '\'' +
                ", subordCount=" + subordCount +
                '}';
    }
}
