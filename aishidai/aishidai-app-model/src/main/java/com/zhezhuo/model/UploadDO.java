package com.zhezhuo.model;

import com.zhezhuo.model.util.CacheKeyBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Shaka on 15/6/12.
 */
public class UploadDO implements Serializable, CacheKeyBuilder<UploadDO>{

    private static final long serialVersionUID = 4202148627474658409L;
    private long id;
    private int type;
    private String path;
    private String local;
    private String description;
    private int status;
    private Date gmtCreate;
    private Date gmtModified;
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UploadDO{" +
                "id=" + id +
                ", type=" + type +
                ", path='" + path + '\'' +
                ", local='" + local + '\'' +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    @Override
    public String getCacheKey(UploadDO uploadDO) {
        return null;
    }

    @Override
    public String getCacheKey() {
        return null;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
