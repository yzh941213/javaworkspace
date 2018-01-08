package com.zhezhuo.model.entity;

import java.util.Date;

public class CommentDO {
    private Long id;

    private Long userId;

    private Long destId;

    private Long itemId;

    private Long labelServiceId;

    private Long type;

    private Long labelCraftsmenId;

    private Long replayCommentId;

    private String comment;

    private Integer status;

    private Date updated;

    private Date created;

    private String picList;

    private Integer star;

    private Integer logisticsStar;

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

    public Long getDestId() {
        return destId;
    }

    public void setDestId(Long destId) {
        this.destId = destId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getLabelServiceId() {
        return labelServiceId;
    }

    public void setLabelServiceId(Long labelServiceId) {
        this.labelServiceId = labelServiceId;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getLabelCraftsmenId() {
        return labelCraftsmenId;
    }

    public void setLabelCraftsmenId(Long labelCraftsmenId) {
        this.labelCraftsmenId = labelCraftsmenId;
    }

    public Long getReplayCommentId() {
        return replayCommentId;
    }

    public void setReplayCommentId(Long replayCommentId) {
        this.replayCommentId = replayCommentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList == null ? null : picList.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getLogisticsStar() {
        return logisticsStar;
    }

    public void setLogisticsStar(Integer logisticsStar) {
        this.logisticsStar = logisticsStar;
    }
}