package com.zhezhuo.biz.manager.impl;

import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.biz.util.SerializeUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaka on 15/5/5.
 */
public class RedisCacheManagerImpl implements CacheManager {

    Jedis jedis;

    public void init() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @Override
    public boolean put(String key, Object value) {
        String result = jedis.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
        return ("OK".equalsIgnoreCase(result));
    }

    @Override
    public boolean put(String namespace, String key, Object value) {
        String result = jedis.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
        return ("OK".equalsIgnoreCase(result));
    }

    @Override
    public Object get(String key) {
        byte[] result = jedis.get(SerializeUtil.serialize(key));
        return SerializeUtil.unserialize(result);
    }

    @Override
    public Object get(String namespace, String key) {
        byte[] result = jedis.get(SerializeUtil.serialize(key));
        return SerializeUtil.unserialize(result);
    }

    @Override
    public boolean invaild(String key) {
        Long result = jedis.del(key);
        return result != null && result == 1;
    }
}
