package system.cache;

import org.springframework.cache.support.AbstractCacheManager;
import system.redis.MyRedisTemplate;

import java.util.Collection;

public class MyCacheManager extends AbstractCacheManager {
    private Collection<? extends MyCache> caches;


    public void setCaches(Collection<? extends MyCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends MyCache> loadCaches() {
        return this.caches;
    }
}
