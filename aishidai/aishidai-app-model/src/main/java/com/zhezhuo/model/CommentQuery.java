package com.zhezhuo.model;

/**
 * Created by Shaka on 15/11/11.
 */
public class CommentQuery extends Query {

    private long topicId;

    private long userId;

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
