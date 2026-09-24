package com.mongpro.mongo_project.Redis;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Disabled
    @Test
    public void redisT(){
        redisTemplate.opsForValue().set("name","shyam");
        redisTemplate.opsForValue().get("name");
        int i=1;
    }

}
