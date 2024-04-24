package com.hmdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.entity.User;

import javax.servlet.http.HttpSession;

/**
 * ClassName: IUserService
 * Description: 服务类
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.service
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public interface IUserService extends IService<User> {

    /**
     * 发送短信
     *
     * @param phone   {@link String}
     * @param session {@link HttpSession}
     * @return {@link Result}
     */
    Result sendCode(String phone, HttpSession session);

    /**
     * 登录
     *
     * @param loginForm {@link LoginFormDTO}
     * @param session   {@link HttpSession}
     * @return {@link Result}
     */
    Result login(LoginFormDTO loginForm, HttpSession session);

    /**
     * 签名
     *
     * @return {@link Result}
     */
    Result sign();

    /**
     * 签名数量
     *
     * @return {@link Result}
     */
    Result signCount();

}
