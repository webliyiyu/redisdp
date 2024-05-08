package com.buercorp.wangyu.service.impl;

import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.service.UserCacheService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
class UserCacheServiceImplTest {
    @Autowired
    private UserCacheService userCacheService;
    @Test
    void getUser() {
        User user = userCacheService.getUser(9l);
        log.info("根据ID来获取用户getUser{}", user);
    }

    @Test
    void insertUser() {
        User user = userCacheService.insertUser(new User(6l, "小李子", 23));
        log.info("插入用户insertUser{}", user);
    }

    @Test
    void updateUserName() {
        userCacheService.updateUserName(8l, "小黑", 18);
        log.info("根据ID来获取修改用户User{}", userCacheService.getUser(8l));
    }

    @Test
    void findUsers() {
    }

    @Test
    void deleteUser() {
        int id = userCacheService.deleteUser(7l);
        log.info("根据ID：{}来删除用户", id);
    }
}