package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
public class NoticeTypeDO implements Serializable {

    private static final long serialVersionUID = -4894002211874089595L;
    private long noticeTypeId;
    private String typeName;
    private String typeNick;
    private String userId;
    private String feature;
    private long created;
    private long updated;
    private int isDeleted;

    public long getNoticeTypeId() {
        return noticeTypeId;
    }

    public void setNoticeTypeId(long noticeTypeId) {
        this.noticeTypeId = noticeTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeNick() {
        return typeNick;
    }

    public void setTypeNick(String typeNick) {
        this.typeNick = typeNick;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
