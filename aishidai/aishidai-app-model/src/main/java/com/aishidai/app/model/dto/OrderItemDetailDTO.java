package com.aishidai.app.model.dto;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/29.
 */
public class OrderItemDetailDTO implements Serializable {

    private long itemId;
    private String thumbnail;
    private String itemName;
    private String salesPrice;
    private long number;
    private String color;
    private String size;
    private String itemCode;
    private Integer returnOrderStatus;
    private long supplier;


    public long getSupplier() {
		return supplier;
	}

	public void setSupplier(long supplier) {
		this.supplier = supplier;
	}

	public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getItemCode() {
        if (itemCode == null) {
            return "";
        }
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getReturnOrderStatus() {
        if (returnOrderStatus == null) {
            return -1;
        }
        return returnOrderStatus;
    }

    public void setReturnOrderStatus(Integer returnOrderStatus) {
        this.returnOrderStatus = returnOrderStatus;
    }
}
