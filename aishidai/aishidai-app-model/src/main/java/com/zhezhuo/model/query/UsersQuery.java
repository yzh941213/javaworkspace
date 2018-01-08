package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;
import com.zhezhuo.model.util.CacheKeyBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaka on 15/6/9.
 */
public class UsersQuery extends Query implements Serializable, CacheKeyBuilder {

    private static final long serialVersionUID = 9007961251280264879L;

    @Override
    public String getCacheKey(Object o) {
        return null;
    }
    @Override
    public String getCacheKey() {
        return null;
    }

    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
