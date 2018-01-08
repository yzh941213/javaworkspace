package com.zhezhuo.model;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Shaka on 15/4/1.
 */
public class UserDO implements Serializable{
    private static final long serialVersionUID = -5125910606728626304L;
    private long id;
    private String name;
    private String password;
    private String newpasswd;
    private SocialUserEnum socialUserEnum;
    @JSONField(serialize = false, deserialize = false)
    private int socialUserEnumId;
    private String socialUserId;
    private List<MaterialDO> materialDOList;
    private String mobile;
    private String phone;
    private String nick;
    private String email;
    private Date gmtCreate;
    private Date gmtModified;
    private int status;
    private String avatar;
    private String feature;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocialUserEnum getSocialUserEnum() {
        return socialUserEnum;
    }

    public void setSocialUserEnum(SocialUserEnum socialUserEnum) {
        this.socialUserEnum = socialUserEnum;
    }

    public String getSocialUserId() {
        return socialUserId;
    }

    public void setSocialUserId(String socialUserId) {
        this.socialUserId = socialUserId;
    }

    public List<MaterialDO> getMaterialDOList() {
        return materialDOList;
    }

    public void setMaterialDOList(List<MaterialDO> materialDOList) {
        this.materialDOList = materialDOList;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getSocialUserEnumId() {
        return socialUserEnum != null? socialUserEnum.getId(): -1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpasswd() {
        return newpasswd;
    }

    public void setNewpasswd(String newpasswd) {
        this.newpasswd = newpasswd;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
