package com.zhezhuo.biz.manager;

/**
 * Created by Shaka on 15/4/22.
 */
public interface CacheManager {

    public boolean put(String key, Object value);

    public boolean put(String namespace, String key, Object value);

    public Object get(String key);

    public Object get(String namespace, String key);

    boolean invaild(String key);
}
