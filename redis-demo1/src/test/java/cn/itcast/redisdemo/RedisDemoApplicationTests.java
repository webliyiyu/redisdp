package cn.itcast.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * ClassName: RedisDemoApplicationTests
 * Description:
 * Date: 2023/04/20 PM 2:06:38
 * <p>
 * project: redis-demo1
 * package: cn.itcast.redisdemo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("num", "666");
    }

}
