package com.buercorp.wangyu.service.impl;

import com.buercorp.wangyu.service.UserCacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA 2023.
 *
 * @Author : LiYiYu
 * @create 2024/5/7 17:09
 */
@SpringBootTest
class UserCacheServiceImplTest {
    @Autowired
    private UserCacheService userCacheService;
    @Test
    void getUser() {
        userCacheService.getUser(1L);
    }

    @Test
    void insertUser() {
    }

    @Test
    void updateUserName() {
    }

    @Test
    void findUsers() {
    }

    @Test
    void deleteUser() {
    }
}