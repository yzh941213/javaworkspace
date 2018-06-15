package system.redis;

import com.google.gson.Gson;
import org.springframework.data.redis.core.RedisTemplate;
import system.uitls.StringUtil;

public class MyRedisTemplate {

    private RedisTemplate<String,String> redisTemplate;

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void put(String key, Object value){
        if(!StringUtil.isEmpty(key) && StringUtil.isNotEmpty(value)){
            redisTemplate.opsForValue().set(key,new Gson().toJson(value));
        }
    }

    public String get(Object key){
        if(!StringUtil.isNotEmpty(key)){
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }


    public void remove(String key){
        if(!StringUtil.isNotEmpty(key)){
            redisTemplate.delete(key);
        }
    }
}
