package com.hmdp.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.hmdp.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.LOGIN_USER_KEY;
import static com.hmdp.utils.RedisConstants.LOGIN_USER_TTL;

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
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(@Nullable HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Object handler) throws Exception {
//        HttpSession session = request.getSession();
       /* // 获取请求头中的token
        String token = request.getHeader("authorization");
        if (StrUtil.isBlank(token)){
            log.warn("请先登录{}", request.getRequestURI());
            // 没有，需要拦截，设置状态码
            Objects.requireNonNull(response).setStatus(401);
            // 拦截
            return false;
        }
        // 基于token获取redis中的用户信息
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash()
                // 获取指定key的所有键值对
                .entries(LOGIN_USER_KEY + token);
        if (userMap.isEmpty()) {
            log.warn("请先登录{}", request.getRequestURI());
            // 没有，需要拦截，设置状态码
            Objects.requireNonNull(response).setStatus(401);
            // 拦截
            return false;
        }
        // 将查询到的Hash数据转为UserDTO对象
        UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);
        // 将用户信息保存到ThreadLocal
        UserHolder.saveUser(userDTO);
        // 刷新token有效期
        stringRedisTemplate.expire(LOGIN_USER_KEY + token,LOGIN_USER_TTL, TimeUnit.MINUTES);*/

                // 1.判断是否需要拦截（ThreadLocal中是否有用户）
        if (UserHolder.getUser() == null) {
            log.warn("请先登录 当前路径{}", request.getRequestURI());
            // 没有，需要拦截，设置状态码
            Objects.requireNonNull(response).setStatus(401);
            // 拦截
            return false;
        }
        // 有用户，则放行
        log.warn("拦截器放行{}",UserHolder.getUser());
        return true;
    }
}
