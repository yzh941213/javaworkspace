package com.zhezhuo.model.entity;

import java.util.Date;

public class FavoriteDO {
    private Long id;

    private Long userId;

    private Short relType;

    private Long relId;

    private Integer status;

    private Date created;

    private Date updated;

    private Short favType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getRelType() {
        return relType;
    }

    public void setRelType(Short relType) {
        this.relType = relType;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Short getFavType() {
        return favType;
    }

    public void setFavType(Short favType) {
        this.favType = favType;
    }
}