package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/11/22.
 * 权限、资源
 */
public class ResourceDO implements Serializable {


    private static final long serialVersionUID = 8910163218877596523L;
    private Long id;
    private String name;
    private String url;
    private String resUrl;
    private Long categoryId;
    private Long parentId;
    private String description;
    private Long createrId;
    private String image;
    private String created;
    private String updated;
    private String feature;
    private Integer isDeleted;

    private long role_res_id;

    private int isTrue;

    private List<ResourceDO> resourceDOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        if (url == null) {
            return "";
        }
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResUrl() {
        if (resUrl == null) {
            return "";
        }
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ResourceDO> getResourceDOs() {
        if (resourceDOs == null) {
            return new ArrayList<ResourceDO>();
        }
        return resourceDOs;
    }

    public void setResourceDOs(List<ResourceDO> resourceDOs) {
        this.resourceDOs = resourceDOs;
    }

    public int getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(int isTrue) {
        this.isTrue = isTrue;
    }

    public long getRole_res_id() {
        return role_res_id;
    }

    public void setRole_res_id(long role_res_id) {
        this.role_res_id = role_res_id;
    }
}
