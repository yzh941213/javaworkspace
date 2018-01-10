package com.aishidai.app.model.pojo;

public class SubsiteDO {
    private Long subId;

    private Long userId;

    private String subNumber;

    private Integer created;

    private Integer updated;

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
        this.subNumber = subNumber == null ? null : subNumber.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
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
        this.expirationStart = expirationStart == null ? null : expirationStart.trim();
    }

    public String getExpirationEnd() {
        return expirationEnd;
    }

    public void setExpirationEnd(String expirationEnd) {
        this.expirationEnd = expirationEnd == null ? null : expirationEnd.trim();
    }

    public Long getShopsId() {
        return shopsId;
    }

    public void setShopsId(Long shopsId) {
        this.shopsId = shopsId;
    }
}