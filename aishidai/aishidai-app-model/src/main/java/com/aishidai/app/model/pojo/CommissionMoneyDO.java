package com.aishidai.app.model.pojo;

import java.util.Date;

public class CommissionMoneyDO {
    private Long id;

    private Long orderId;

    private String hqAmount;

    private String distributorAmount;

    private String othershopAmount;

    private String makerAmount;

    private String shopAmount;

    private Date created;

    private Date updated;

    private Integer type;

    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getHqAmount() {
        return hqAmount;
    }

    public void setHqAmount(String hqAmount) {
        this.hqAmount = hqAmount == null ? null : hqAmount.trim();
    }

    public String getDistributorAmount() {
        return distributorAmount;
    }

    public void setDistributorAmount(String distributorAmount) {
        this.distributorAmount = distributorAmount == null ? null : distributorAmount.trim();
    }

    public String getOthershopAmount() {
        return othershopAmount;
    }

    public void setOthershopAmount(String othershopAmount) {
        this.othershopAmount = othershopAmount == null ? null : othershopAmount.trim();
    }

    public String getMakerAmount() {
        return makerAmount;
    }

    public void setMakerAmount(String makerAmount) {
        this.makerAmount = makerAmount == null ? null : makerAmount.trim();
    }

    public String getShopAmount() {
        return shopAmount;
    }

    public void setShopAmount(String shopAmount) {
        this.shopAmount = shopAmount == null ? null : shopAmount.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}