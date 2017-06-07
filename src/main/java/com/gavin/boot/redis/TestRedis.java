package com.gavin.boot.redis;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by gavin on 17-6-7.
 */
@Repository
public class TestRedis {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void set(String key, Long time, Item item) {
        Gson gson = new Gson();
        this.redisTemplate.opsForValue().set(key, gson.toJson(item),
                time, TimeUnit.MINUTES);
    }

    public Item get(String key) {
        Gson gson = new Gson();
        return gson.fromJson(this.redisTemplate.opsForValue().get(key), Item.class);
    }
}
