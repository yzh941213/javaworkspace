package com.zhezhuo.model.query;

import com.zhezhuo.model.Query;

/**
 * Created by 蝈蝈 on 2016/8/16.
 */
public class AttributeQuery extends Query {

    private long parentId;
    private long flag;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }
}
