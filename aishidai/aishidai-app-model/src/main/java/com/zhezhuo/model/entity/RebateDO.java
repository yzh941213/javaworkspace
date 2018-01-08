package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 蝈蝈 on 2016/12/13.
 */
public class RebateDO implements Serializable {


    private static final long serialVersionUID = 2955394634298656607L;
    private Long rebateId;
    private Integer number;
    private String name;
    private Long itemId;
    private String discount;
    private String startTime;
    private String endTime;
    private String created;
    private String updated;
    private Long creater;
    private int status;
    private int isDeleted;

    public Long getRebateId() {
        return rebateId;
    }

    public void setRebateId(Long rebateId) {
        this.rebateId = rebateId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStartTime() {
        if (startTime.equals("") || startTime == null) {
            return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        return startTime.substring(0,startTime.lastIndexOf("."));
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        if (endTime.equals("") || endTime == null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        return endTime.substring(0, endTime.lastIndexOf("."));
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreated() {
        return created.substring(0, created.lastIndexOf("."));
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated.substring(0, updated.lastIndexOf("."));
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
