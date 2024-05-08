package com.buercorp.wangyu.service;

import com.buercorp.wangyu.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserCacheService {
    User getUser(Long id);
    User insertUser(User user);
    void updateUserName(Long id, String userName, Integer age);
    List<User> findUsers(String userName);
    int deleteUser(Long id);

}
