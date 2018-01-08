package com.aishidai.app.model.pojo;

import java.util.Date;

public class MakerCommissionDetailDO {
    private String id;

    private Integer commission;

    private String makerName;

    private String makerId;

    private Integer type;

    private Long otherShopId;

    private Long shopId;

    private String createName;

    private Long createId;

    private Date created;

    private Date updated;

    private Integer deleteIs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName == null ? null : makerName.trim();
    }

    public String getMakerId() {
        return makerId;
    }

    public void setMakerId(String makerId) {
        this.makerId = makerId == null ? null : makerId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getOtherShopId() {
        return otherShopId;
    }

    public void setOtherShopId(Long otherShopId) {
        this.otherShopId = otherShopId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
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