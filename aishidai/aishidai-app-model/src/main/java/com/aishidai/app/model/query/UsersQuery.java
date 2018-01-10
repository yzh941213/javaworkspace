package com.aishidai.app.model.query;

import com.aishidai.app.model.util.*;

import java.io.Serializable;

public class UsersQuery extends Query implements Serializable, CacheKeyBuilder {

    private static final long serialVersionUID = 9007961251280264879L;

    public String getCacheKey(Object o) {
        return null;
    }
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
