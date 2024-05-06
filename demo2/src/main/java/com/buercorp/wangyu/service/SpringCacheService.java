package com.buercorp.wangyu.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
@Slf4j
public class SpringCacheService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Cacheable(value = "name", key = "'user:' + #userId")
    public String testString(long userId) {
        // 写入一条 String 数据
        stringRedisTemplate.opsForValue().set("user:" + userId, "xiao虎哥");
        // 获取 String 数据
        Object name = stringRedisTemplate.opsForValue().get("user:" + userId);
        log.info("获取 String 数据 = {}", name);
        return (String) name;
    }


    void testHash() {
        stringRedisTemplate.opsForHash().put("user:400", "name", "虎哥");
        stringRedisTemplate.opsForHash().put("user:400", "age", "21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entries = " + entries);
    }
}
