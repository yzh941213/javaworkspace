package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/21.
 * 退货单
 */
public class ReturnOrderDO implements Serializable {


    private static final long serialVersionUID = -2832936307191355826L;
    private Long returnOrderId;
    private Long applyUserId;
    private Long orderId;
    private Integer number;
    private String money;
    private String image;
    private String applyReason;
    private Integer status;
    private Integer type;
    private Integer isReceive;
    private String created;
    private String upated;
    private String applyExplain;
    private Integer isDeleted;
    private String returnMoney;
    private Integer isInvoice;
    private String itemName;
    private Long itemId;
    private String colorName;
    private String sizeName;
    private String itemImage;

    private String expressCompany;
    private String trackingNum;
    private String applyUserName;


    private List<ReOrderRecordDO> recordDOs;

    public Long getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(Long returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getImage() {
        if (image == null) {
            return "";
        }
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsReceive() {
        if (isReceive == null) {
            return 0;
        }
        return isReceive;
    }

    public void setIsReceive(Integer isReceive) {
        this.isReceive = isReceive;
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

    public String getApplyExplain() {
        return applyExplain;
    }

    public void setApplyExplain(String applyExplain) {
        this.applyExplain = applyExplain;
    }

    public Integer getIsDeleted() {
        if (isDeleted == null) {
            return  0;
        }
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }

    public List<ReOrderRecordDO> getRecordDOs() {
        return recordDOs;
    }

    public void setRecordDOs(List<ReOrderRecordDO> recordDOs) {
        this.recordDOs = recordDOs;
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

    public String getItemName() {
        if (itemName == null) {
            return "";
        }
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getColorName() {
        if (colorName == null) {
            return "";
        }
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        if (sizeName == null) {
            return "";
        }
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getItemImage() {
        if (itemImage == null) {
            return "";
        }
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
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

    public String getApplyUserName() {
        if (applyUserName == null) {
            return "";
        }
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public Long getItemId() {
        if (itemId == null) {
            return 0l;
        }
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
