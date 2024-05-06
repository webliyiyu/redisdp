package com.buercorp.wangyu;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;
@SpringBootTest
@Slf4j
public class SpringBootCacheTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


}
