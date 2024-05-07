package com.buercorp.wangyu.controller;

import com.buercorp.wangyu.common.CommonResult;
import com.buercorp.wangyu.pojo.User;
//import com.buercorp.wangyu.service.impl.UserCacheService;
import com.buercorp.wangyu.service.UserCacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.bytecode.analysis.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/cache")
@Slf4j
public class UserCacheController {

    @Autowired
    private UserCacheService userCacheService;

    /**
     * 根据ID获取User
     * http://localhost:8080/user/cache/getUser?id=3
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public CommonResult getUser(Long id) {
        User user = userCacheService.getUser(id);
        log.info("根据ID获取user:{}", user);
        return CommonResult.success(user);
    }

    /**
     * 插入一个新User
     * http://localhost:8080/user/cache/insertUser?userName=liyiyu&age=18
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public CommonResult insertUser(String userName, Integer age) {
        User user = User.builder()
                .userName(userName)
                .age(age)
                .build();
        User resultUser = userCacheService.insertUser(user);
        log.info("插入新user:{}", resultUser);
        return CommonResult.success(resultUser);
    }

    /**
     * 根据Id查找用户并更新username
     * http://localhost:8080/user/cache/updateUserName?id=2&userName=李可
     */
    @RequestMapping("/updateUserName")
    @ResponseBody
    public CommonResult updateUserName(Long id, String userName) {
        userCacheService.updateUserName(id, userName);
        log.info("根据Id：{}查找用户并更新username：{}", id, userName);
        return CommonResult.success();
    }

    /**
     * 根据Username查找UserList
     * http://localhost:8080/user/cache/findUsers?userName=yitian_cache
     */
    @RequestMapping("/findUsers")
    @ResponseBody
    public CommonResult findUsers(String userName) {
        List<User> users = userCacheService.findUsers(userName);
        log.info("根据Username查找UserList:{}", users);
        return CommonResult.success(users);
    }

    /**
     * 删除用户
     * http://localhost:8080/user/cache/deleteUser?id=1
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public CommonResult deleteUser(Long id) {
        int result = userCacheService.deleteUser(id);
        boolean flag = result == 1;
        String msg = flag ? "删除成功" : "删除失败";
        log.info("删除用户{}", msg);
        return CommonResult.success(msg);
    }
}
