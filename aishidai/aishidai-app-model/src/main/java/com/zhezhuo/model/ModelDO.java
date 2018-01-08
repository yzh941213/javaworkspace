package com.zhezhuo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Shaka on 15/5/5.
 */
public class ModelDO implements Serializable{
    private static final long serialVersionUID = -6292815153750167911L;
    private long id;
    private long userId;
    private String name;
    private int modelType;
    private byte[] image;
    private String imagePath;
    private String feature;
    private String desc;
    private Date gmtCreate;
    private Date gmtModified;
    private int status;
    private int recommend;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "ModelDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", modelType=" + modelType +
                ", image=" + Arrays.toString(image) +
                ", imgaePath='" + imagePath + '\'' +
                ", feature='" + feature + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", status=" + status +
                ", recommend=" + recommend +
                '}';
    }
}
