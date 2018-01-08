package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/21.
 * 通告
 */
public class AnnounceDO implements Serializable {


    private static final long serialVersionUID = 6813992930918843576L;
    private long anId;
    private long userId;
    private String title;
    private String subtitle;
    private String image;
    private String summary;
    private String created;
    private String updated;
    private int status;
    private int isDeleted;

    public long getAnId() {
        return anId;
    }

    public void setAnId(long anId) {
        this.anId = anId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    @Override
    public String toString() {
        return "AnnounceDO{" +
                "annoId=" + anId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", image='" + image + '\'' +
                ", summary='" + summary + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", status=" + status +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
