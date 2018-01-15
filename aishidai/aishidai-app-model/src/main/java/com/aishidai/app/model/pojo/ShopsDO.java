package com.aishidai.app.model.pojo;

import java.util.Date;

public class ShopsDO {
    private Long shopsId;

    private Long distributorId;

    private String shopsName;

    private String introduce;

    private String shopsUrl;

    private String telephone;

    private String area;

    private String address;

    private String province;

    private String city;

    private String activity;

    private Date created;

    private Date updated;

    private Long sysUserId;

    private String shopHoursOpen;

    private String shopHoursClose;

    private Integer isDeleted;

    private String services;

    private Integer hot;

    private String servicesType;

    private Long deviceId;

    private Integer deviceIs;

    private Integer audit;

    private Integer star;

    private String lat;

    private String lnt;

    private Integer isSuppliers;

    public Long getShopsId() {
        return shopsId;
    }

    public void setShopsId(Long shopsId) {
        this.shopsId = shopsId;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String getShopsName() {
        return shopsName;
    }

    public void setShopsName(String shopsName) {
        this.shopsName = shopsName == null ? null : shopsName.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getShopsUrl() {
        return shopsUrl;
    }

    public void setShopsUrl(String shopsUrl) {
        this.shopsUrl = shopsUrl == null ? null : shopsUrl.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
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

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getShopHoursOpen() {
        return shopHoursOpen;
    }

    public void setShopHoursOpen(String shopHoursOpen) {
        this.shopHoursOpen = shopHoursOpen == null ? null : shopHoursOpen.trim();
    }

    public String getShopHoursClose() {
        return shopHoursClose;
    }

    public void setShopHoursClose(String shopHoursClose) {
        this.shopHoursClose = shopHoursClose == null ? null : shopHoursClose.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services == null ? null : services.trim();
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getServicesType() {
        return servicesType;
    }

    public void setServicesType(String servicesType) {
        this.servicesType = servicesType == null ? null : servicesType.trim();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceIs() {
        return deviceIs;
    }

    public void setDeviceIs(Integer deviceIs) {
        this.deviceIs = deviceIs;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getLnt() {
        return lnt;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt == null ? null : lnt.trim();
    }

    public Integer getIsSuppliers() {
        return isSuppliers;
    }

    public void setIsSuppliers(Integer isSuppliers) {
        this.isSuppliers = isSuppliers;
    }
}