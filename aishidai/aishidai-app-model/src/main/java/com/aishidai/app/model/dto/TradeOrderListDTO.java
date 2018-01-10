package com.aishidai.app.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/28.
 */
public class TradeOrderListDTO implements Serializable {


    private static final long serialVersionUID = 5901747257580511789L;

    private Long orderId;

    private String orderNum;

    private String created;

    private String Price;

    private String realname;

    private String mobile;

    private Integer number;

    private int status;

    private String statusDesc;

    private String shipExpense;

    private long itemId;

    private String trackingNum;

    private Long buyerUserId;

    private Long sellerUserId;

    private List<OrderItemDetailDTO> items;

    public List<OrderItemDetailDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDetailDTO> items) {
        this.items = items;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getShipExpense() {
        if (shipExpense == null) {
            return "0.00";
        }
        return shipExpense;
    }

    public void setShipExpense(String shipExpense) {
        this.shipExpense = shipExpense;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getTrackingNum() {
        if (trackingNum == null) {
            return "";
        }
        return trackingNum;
    }

    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }

    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Long getSellerUserId() {
        if (sellerUserId == null || sellerUserId.longValue() == 100000) {
            return 0l;
        }
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }
}
