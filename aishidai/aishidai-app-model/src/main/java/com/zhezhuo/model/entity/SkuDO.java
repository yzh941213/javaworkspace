package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/8/22.
 */
public class SkuDO implements Serializable{


    private static final long serialVersionUID = -7820315282180897993L;

    private long skuId;
    private String price;
    private String salesPrice;
    private long colourId;
    private long sizeId;
    private String image;
    private String description;
    private String feature;
    private int stock;
    private int salseVolume;
    private String created;
    private String updated;
    private int status;
    private long itemId;

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public long getColourId() {
        return colourId;
    }

    public void setColourId(long colourId) {
        this.colourId = colourId;
    }

    public long getSizeId() {
        return sizeId;
    }

    public void setSizeId(long sizeId) {
        this.sizeId = sizeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSalseVolume() {
        return salseVolume;
    }

    public void setSalseVolume(int salseVolume) {
        this.salseVolume = salseVolume;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "SkuDO{" +
                "skuId=" + skuId +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", colourId=" + colourId +
                ", sizeId=" + sizeId +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", feature='" + feature + '\'' +
                ", stock=" + stock +
                ", salseVolume=" + salseVolume +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", status=" + status +
                ", itemId=" + itemId +
                '}';
    }
}
