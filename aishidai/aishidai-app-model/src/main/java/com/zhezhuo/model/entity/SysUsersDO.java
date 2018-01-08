package com.zhezhuo.model.entity;


import java.io.Serializable;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/8.
 */
public class SysUsersDO implements Serializable {


    private static final long serialVersionUID = 8870824873617887234L;
    private Long userId;
    private Long roleId;
    private Long groupId;
    private String userName;
    private String nickName;
    private String password;
    private String name;
    private Integer sex;
    private String mobile;
    private String email;
    private String created;
    private String updated;
    private Integer status;
    private String avatar;
    private String feature;
    private Integer isDeleted;

    private List<ResourceDO> resourceDOs;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ResourceDO> getResourceDOs() {
        if (resourceDOs == null) {
            return resourceDOs;
        }
        return resourceDOs;
    }

    public void setResourceDOs(List<ResourceDO> resourceDOs) {
        this.resourceDOs = resourceDOs;
    }
}

