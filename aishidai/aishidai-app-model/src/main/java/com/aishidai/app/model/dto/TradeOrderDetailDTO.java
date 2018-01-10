package com.aishidai.app.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/29.
 */
public class TradeOrderDetailDTO implements Serializable {


    private static final long serialVersionUID = -6553759877831642600L;
    private Long orderId;

    private Long itemId;

    private Long colorId;

    private Long sizeId;

    private Long price;

    private Integer number;

    private String orderNum;

    private String realname;

    private String country;

    private String province;

    private String city;

    private String area;

    private String address;

    private String mobile;

    private String statusDesc;

    private String created;

    private String expressCompany;

    private String trackingNum;

    private String remarks;

    private int isInvoice;

    private String invoiceTitle;

    private String settlementTime;

    private int status;

    private long buyerUserId;

    private String shipTime;

    private List<OrderItemDetailDTO> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<OrderItemDetailDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDetailDTO> items) {
        this.items = items;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated() {
        if ("1970-01-01 08:00:00".equals(created)) {
            return "";
        }
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getExpressCompany() {
        if (expressCompany == null) {
            return "";
        }
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
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

    public String getRemarks() {
        if (remarks == null) {
            return "";
        }
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(int isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getInvoiceTitle() {
        if (invoiceTitle == null) {
            return "";
        }
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getSettlementTime() {
        if ("1970-01-01 08:00:00".equals(settlementTime)) {
            return "";
        }
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }

    public long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getShipTime() {
        if ("1970-01-01 08:00:00".equals(shipTime)) {
            return "";
        }
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }
}
