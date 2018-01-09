package com.aishidai.app.model.pojo;

import java.util.Date;

public class ItemDO {
    private Long itemId;

    private Long nameId;

    private String price;

    private String salesPrice;

    private String image;

    private String categoryId;

    private String itemCode;

    private Integer salseVolume;

    private Date created;

    private Date updated;

    private Short recommend;

    private String itemName;

    private String itemTag;

    private Integer itemStatus;

    private Integer deleteIs;

    private Integer itemModel;

    private Long shopId;

    private Integer audit;

    private String summary;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getNameId() {
        return nameId;
    }

    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice == null ? null : salesPrice.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public Integer getSalseVolume() {
        return salseVolume;
    }

    public void setSalseVolume(Integer salseVolume) {
        this.salseVolume = salseVolume;
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

    public Short getRecommend() {
        return recommend;
    }

    public void setRecommend(Short recommend) {
        this.recommend = recommend;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemTag() {
        return itemTag;
    }

    public void setItemTag(String itemTag) {
        this.itemTag = itemTag == null ? null : itemTag.trim();
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Integer getDeleteIs() {
        return deleteIs;
    }

    public void setDeleteIs(Integer deleteIs) {
        this.deleteIs = deleteIs;
    }

    public Integer getItemModel() {
        return itemModel;
    }

    public void setItemModel(Integer itemModel) {
        this.itemModel = itemModel;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}