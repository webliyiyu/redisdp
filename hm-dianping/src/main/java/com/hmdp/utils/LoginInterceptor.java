package com.hmdp.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * ClassName: LoginInterceptor
 * Description: 登录校验拦截器
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.utils
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler) throws Exception {
//        HttpSession session = request.getSession();

        // 1.判断是否需要拦截（ThreadLocal中是否有用户）
        if (UserHolder.getUser() == null) {
            log.warn("请先登录{}", request.getRequestURI());
            // 没有，需要拦截，设置状态码
            Objects.requireNonNull(response).setStatus(401);
            // 拦截
            return false;
        }
        // 有用户，则放行
        return true;
    }
}
