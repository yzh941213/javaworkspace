package com.aishidai.app.model.pojo;

public class TCashDO {
    private Long caId;

    private Long userId;

    private String cash;

    private Integer status;

    private Long created;

    private Long updated;

    private Long cashEx;

    private Integer isDeleted;

    public Long getCaId() {
        return caId;
    }

    public void setCaId(Long caId) {
        this.caId = caId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash == null ? null : cash.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Long getCashEx() {
        return cashEx;
    }

    public void setCashEx(Long cashEx) {
        this.cashEx = cashEx;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}