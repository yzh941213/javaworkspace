package system.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import system.redis.MyRedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * user:yzh
 * date:2017年10月19日15:41:57
 * info:自定义cache缓存类
 * qq:963485106
 */
public class MyCache implements Cache{

    private String name;
    private Map<String,Object>cache = new HashMap<>();

    public MyCache(){

    }

    public MyCache(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        return cache;
    }

    /**
     * get value by key
     * @param o
     * @return
     */
    @Override
    public ValueWrapper get(Object o) {
        ValueWrapper result = null;
        Object value = cache.get(o);
        if(null !=value){
           result = new SimpleValueWrapper(value);
        }
        return result;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
       return null;
    }

    /**
     * put key value
     * @param o
     * @param o1
     */
    @Override
    public void put(Object o, Object o1) {
        cache.put(o.toString(),o1);
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    /**
     * 根据key删除缓存
     * @param o
     */
    @Override
    public void evict(Object o) {
        cache.remove(o.toString());
    }

    @Override
    public void clear() {

    }
}
