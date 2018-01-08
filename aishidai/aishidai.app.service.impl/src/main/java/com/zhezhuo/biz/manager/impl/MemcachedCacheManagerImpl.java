package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.manager.CacheManager;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;


/**
 * Created by Shaka on 15/4/22.
 */
public class MemcachedCacheManagerImpl implements CacheManager {

    MemcachedClient memCachedClient;
    final int EXPIRED_TIME = 1800;

    static Logger logger = LoggerFactory.getLogger(MemcachedCacheManagerImpl.class);

    public void init() {
        try {
            memCachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    public boolean put(String key, Object value) {
        try {
            return memCachedClient.set(key, EXPIRED_TIME, value).get();
        } catch (InterruptedException e) {
            logger.error("", e);
        } catch (ExecutionException e) {
            logger.error("", e);
        }

        return false;
    }

    public boolean put(String namespace, String key, Object value) {
        return false;
    }

    public Object get(String key) {
        return memCachedClient.get(key);
    }

    public Object get(String namespace, String key) {
        return null;
    }

    @Override
    public boolean invaild(String key) {
        try {
            return memCachedClient.delete(key).get();
        } catch (InterruptedException e) {
            logger.error("", e);
        } catch (ExecutionException e) {
            logger.error("", e);
        }

        return false;
    }
}
