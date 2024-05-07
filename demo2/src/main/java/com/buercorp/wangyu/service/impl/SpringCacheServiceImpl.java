//package com.buercorp.wangyu.service.impl;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//@Service
//@Slf4j
//public class SpringCacheServiceImpl {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Cacheable(value = "userName", key = "#userId", condition = "#userId != null")
//    public String testString(long userId) {
//        log.info("缓存中没有执行的业务：{}", userId);
//        return "22222";
//    }
//
//
//    void testHash() {
//        stringRedisTemplate.opsForHash().put("user:400", "name", "虎哥");
//        stringRedisTemplate.opsForHash().put("user:400", "age", "21");
//
//        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
//        System.out.println("entries = " + entries);
//    }
//}
