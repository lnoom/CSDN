package com.example;

import com.exmple.RedisApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-20 10:59
 */
@SpringBootTest(classes = RedisApplication.class)
public class RedisApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void set() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("name1","奇遇少年");
    }
//    @Test
//    void set() {
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        ops.set("name","奇遇少年");
//    }

}
