package com.aishidai.app.model.pojo;

public class ShopCartDO {
    private Long shopCartId;

    private Long itemId;

    private Long userId;

    private Integer number;

    private Integer created;

    private Integer updated;

    private Byte isBuy;

    private Integer buyTime;

    private Byte isDeleted;

    private String pictureUrl;

    private Integer type;

    private Integer skuId;

    private String stratification;

    public Long getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Long shopCartId) {
        this.shopCartId = shopCartId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Byte getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Byte isBuy) {
        this.isBuy = isBuy;
    }

    public Integer getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Integer buyTime) {
        this.buyTime = buyTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getStratification() {
        return stratification;
    }

    public void setStratification(String stratification) {
        this.stratification = stratification == null ? null : stratification.trim();
    }
}