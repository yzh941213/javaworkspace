package com.aishidai.app.model.vo;

import com.aishidai.app.model.pojo.ItemDO;

public class ItemVO extends ItemDO {
  private  String  maxPrice;
  private  String  minPrice;
  private String  maxSalesPrice;
  private String  minSalesPrice;

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxSalesPrice() {
        return maxSalesPrice;
    }

    public void setMaxSalesPrice(String maxSalesPrice) {
        this.maxSalesPrice = maxSalesPrice;
    }

    public String getMinSalesPrice() {
        return minSalesPrice;
    }

    public void setMinSalesPrice(String minSalesPrice) {
        this.minSalesPrice = minSalesPrice;
    }
}
