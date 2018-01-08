package com.aishidai.app.service;

/**
 * Created by Shaka on 15/4/22.
 */
public interface CacheService {

    public boolean put(String key, Object value);

    public boolean put(String namespace, String key, Object value);

    public Object get(String key);

    public Object get(String namespace, String key);

    boolean invaild(String key);
}
