package com.zhezhuo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Shaka on 15/7/16.
 */
public class FavoriteDO implements Serializable{

    private long id;
    private long userId;
    private int relType;
    private long relId;
    private int favType;
    private int categoryId;
    private int status;
    private Date gmtCreate;
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRelType() {
        return relType;
    }

    public void setRelType(int relType) {
        this.relType = relType;
    }

    public long getRelId() {
        return relId;
    }

    public void setRelId(long relId) {
        this.relId = relId;
    }

    public int getFavType() {
        return favType;
    }

    public void setFavType(int favType) {
        this.favType = favType;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "FavoriteDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", relType=" + relType +
                ", relId=" + relId +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
