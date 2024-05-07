package com.buercorp.wangyu.controller;

import com.buercorp.wangyu.service.SpringCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class SpringCacheController {
    @Autowired
    public SpringCacheService springCacheService;
    private long userId = 33333;
    public void SpringCache() {
        springCacheService.testString(userId);
    }

}
