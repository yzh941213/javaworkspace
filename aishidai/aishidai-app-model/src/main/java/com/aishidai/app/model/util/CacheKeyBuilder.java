package com.aishidai.app.model.util;

/**
 * Created by Shaka on 15/5/31.
 */
public interface CacheKeyBuilder<T> {

    /**
     * 根据T来生成key
     * @param t
     * @return
     */
    String getCacheKey(T t);

    /**
     * 一般是根据self来生成key
     * @return
     */
    String getCacheKey();
}
