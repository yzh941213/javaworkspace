package com.aishidai.app.model.pojo;

public class TradeOrderLogisticsDO {
    private Integer id;

    private String shipTime;

    private String expressCompany;

    private Integer trackingNum;

    private Integer addressId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime == null ? null : shipTime.trim();
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    public Integer getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(Integer trackingNum) {
        this.trackingNum = trackingNum;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}