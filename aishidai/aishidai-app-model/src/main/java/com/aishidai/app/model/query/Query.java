package com.aishidai.app.model.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaka on 15/4/5.
 */
public class Query<T> extends Paginator implements Serializable {
	
    private static final long serialVersionUID = 4451298449115632795L;

    public static final List<Integer> DEFAULT_STATUS = new ArrayList<Integer>(){};

    static {
        DEFAULT_STATUS.add(new Integer(1));
    }

    /**
     *
     */
    private long userId;

    private long relId;

    /**
     * 状态字段
     */
    private List<Integer> status;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRelId() {
        return relId;
    }

    public void setRelId(long relId) {
        this.relId = relId;
    }

    public List<Integer> getStatus() {
        if(status == null){
            return DEFAULT_STATUS;
        }

        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }
}
