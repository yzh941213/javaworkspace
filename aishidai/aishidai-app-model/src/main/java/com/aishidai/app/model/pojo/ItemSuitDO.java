package com.aishidai.app.model.pojo;

public class ItemSuitDO {
    private Long id;

    private String suitImage;

    private Long skuId;

    private String stratification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuitImage() {
        return suitImage;
    }

    public void setSuitImage(String suitImage) {
        this.suitImage = suitImage == null ? null : suitImage.trim();
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getStratification() {
        return stratification;
    }

    public void setStratification(String stratification) {
        this.stratification = stratification == null ? null : stratification.trim();
    }
}