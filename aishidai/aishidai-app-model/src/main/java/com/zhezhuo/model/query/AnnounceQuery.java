package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;
import com.zhezhuo.model.util.CacheKeyBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaka on 15/6/9.
 */
public class AnnounceQuery extends Query implements Serializable, CacheKeyBuilder {

    private int statuss;
    private String keywords;

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
