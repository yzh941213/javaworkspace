package com.zhezhuo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Shaka on 15/11/10.
 */
public class CommentDO implements Serializable{

    private long id;

    private long userId;

    private long replyUserId;

    private long topicId;

    private long replyCommentId;

    private String comment;

    private int status;

    private String picList;

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

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }
}
