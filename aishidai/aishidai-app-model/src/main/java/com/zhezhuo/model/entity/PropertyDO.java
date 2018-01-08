package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class PropertyDO implements Serializable {


    private static final long serialVersionUID = 3043978009538615639L;

    private long propertyId;
    private String proName;
    private String imgPath;
    private String description;
    private long parentId;
    private String alias;
    private String created;
    private String updated;
    private String feature;
    private int status;

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "PropertyDO{" +
                "propertyId=" + propertyId +
                ", proName='" + proName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", description='" + description + '\'' +
                ", parentId=" + parentId +
                ", alias='" + alias + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", feature='" + feature + '\'' +
                ", status=" + status +
                '}';
    }
}
