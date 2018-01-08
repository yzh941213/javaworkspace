package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;
import com.zhezhuo.model.util.CacheKeyBuilder;

import java.io.Serializable;

/**
 * Created by Shaka on 15/6/9.
 */
public class NoticeQuery extends Query implements Serializable, CacheKeyBuilder {

    private int statuss;
    private String keywords;
    private long noticeType;
    private long receiveId;

    public long getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(long noticeType) {
        this.noticeType = noticeType;
    }

    public int getStatuss() {
        return statuss;
    }

    public void setStatuss(int statuss) {
        this.statuss = statuss;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(long receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * 根据T来生成key
     *
     * @param o
     * @return
     */
    @Override
    public String getCacheKey(Object o) {
        return null;
    }

    /**
     * 一般是根据self来生成key
     *
     * @return
     */
    @Override
    public String getCacheKey() {
        return null;
    }
}
