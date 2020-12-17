package com.cache;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Cache<T> {

    private Map<String, T> cache = Maps.newHashMap();

    public T get(String key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    public void evictCache(String key) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    public void evictCache() {
        cache.clear();
    }
}
