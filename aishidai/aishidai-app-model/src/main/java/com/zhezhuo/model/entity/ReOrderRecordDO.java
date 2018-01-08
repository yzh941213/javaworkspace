package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/21.
 * 退货单
 */
public class ReOrderRecordDO implements Serializable {


    private static final long serialVersionUID = 1018727716766019246L;
    private long recordId;
    private long operateUserId;
    private long returnOrderId;
    private int status;
    private String expressCompany;
    private String trackingNum;
    private String shopTime;
    private String payId;
    private String patyTime;
    private String rejectReason;
    private String comments;
    private String created;
    private String upated;
    private Integer userType;
    private String returnMoney;
    private Integer isDeleted;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public long getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(long operateUserId) {
        this.operateUserId = operateUserId;
    }

    public long getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(long returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getShopTime() {
        if (shopTime == null) {
            return String.valueOf(0);
        }
        return shopTime;
    }

    public void setShopTime(String shopTime) {
        this.shopTime = shopTime;
    }

    public String getPayId() {
        if (payId == null) {
            return "";
        }
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getPatyTime() {
        if (patyTime == null) {
            return String.valueOf(0);
        }
        return patyTime;
    }

    public void setPatyTime(String patyTime) {
        this.patyTime = patyTime;
    }

    public String getRejectReason() {
        if (rejectReason == null) {
            return "";
        }
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getComments() {
        if (comments == null) {
            return "";
        }
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpated() {
        return upated;
    }

    public void setUpated(String upated) {
        this.upated = upated;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getReturnMoney() {
        if (returnMoney == null) {
            return "0.00";
        }
        return returnMoney;
    }

    public void setReturnMoney(String returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
