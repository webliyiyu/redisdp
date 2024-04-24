package cn.itcast.redisdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Description:
 * Date: 2023/04/20 PM 2:06:38
 * <p>
 * project: redis-demo1
 * package: cn.itcast.redisdemo.web
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/get/{key}")
    public String hi(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/set/{key}/{value}")
    public String hi(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }
}
