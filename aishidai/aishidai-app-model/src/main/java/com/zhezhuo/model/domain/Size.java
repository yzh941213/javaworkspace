package com.zhezhuo.model.domain;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/14.
 */
public class Size implements Serializable {


    private static final long serialVersionUID = 4504851863562600252L;
    private long sizeId;
    private String sizeName;
    private int stock;
    private long skuId;

    public long getSizeId() {
        return sizeId;
    }

    public void setSizeId(long sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }
}
