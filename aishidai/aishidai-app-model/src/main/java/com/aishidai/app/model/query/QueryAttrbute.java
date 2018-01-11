package com.aishidai.app.model.query;

import java.util.Date;

public class QueryAttrbute extends QueryPage {
    private Long attributeId;

    private String attrName;

    private String imgPath;

    private String description;

    private Integer parentId;

    private Date created;

    private Date updated;

    private Integer status;

    private Integer hot;

    private Integer stratification;

    private Integer category;

    private Integer deviceShop;

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getStratification() {
        return stratification;
    }

    public void setStratification(Integer stratification) {
        this.stratification = stratification;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getDeviceShop() {
        return deviceShop;
    }

    public void setDeviceShop(Integer deviceShop) {
        this.deviceShop = deviceShop;
    }
}
