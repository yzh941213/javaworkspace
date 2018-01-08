package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
public class AdviseDO implements Serializable{


    private static final long serialVersionUID = -4806756299186689748L;
    private Long adviseId;
    private Long userId;
    private String adviseText;
    private String mobile;
    private String created;
    private String updated;
    private String feature;
    private Integer isDeleted;
    private Integer status;

    public Long getAdviseId() {
        return adviseId;
    }

    public void setAdviseId(Long adviseId) {
        this.adviseId = adviseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAdviseText() {
        return adviseText;
    }

    public void setAdviseText(String adviseText) {
        this.adviseText = adviseText;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
