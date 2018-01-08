package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class PropertyQuery extends Query {

    private long parentId;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
