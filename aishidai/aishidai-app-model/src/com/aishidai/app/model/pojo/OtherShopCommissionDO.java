package com.aishidai.app.model.pojo;

import java.util.Date;

public class OtherShopCommissionDO {
    private String id;

    private Integer otherShopCommission;

    private Long distributorId;

    private String distributorName;

    private Integer distributorCommission;

    private Integer barbershopCommission;

    private String otherShopName;

    private String shopName;

    private Long shopId;

    private Long otherShopId;

    private Integer makerCommission;

    private Integer type;

    private Long createId;

    private String createName;

    private Date created;

    private Date updated;

    private Integer deleteIs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getOtherShopCommission() {
        return otherShopCommission;
    }

    public void setOtherShopCommission(Integer otherShopCommission) {
        this.otherShopCommission = otherShopCommission;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName == null ? null : distributorName.trim();
    }

    public Integer getDistributorCommission() {
        return distributorCommission;
    }

    public void setDistributorCommission(Integer distributorCommission) {
        this.distributorCommission = distributorCommission;
    }

    public Integer getBarbershopCommission() {
        return barbershopCommission;
    }

    public void setBarbershopCommission(Integer barbershopCommission) {
        this.barbershopCommission = barbershopCommission;
    }

    public String getOtherShopName() {
        return otherShopName;
    }

    public void setOtherShopName(String otherShopName) {
        this.otherShopName = otherShopName == null ? null : otherShopName.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOtherShopId() {
        return otherShopId;
    }

    public void setOtherShopId(Long otherShopId) {
        this.otherShopId = otherShopId;
    }

    public Integer getMakerCommission() {
        return makerCommission;
    }

    public void setMakerCommission(Integer makerCommission) {
        this.makerCommission = makerCommission;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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

    public Integer getDeleteIs() {
        return deleteIs;
    }

    public void setDeleteIs(Integer deleteIs) {
        this.deleteIs = deleteIs;
    }
}