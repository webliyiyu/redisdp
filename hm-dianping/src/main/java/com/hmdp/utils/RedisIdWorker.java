package com.hmdp.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: RedisIdWorker
 * Description:
 *
 * Date: 2023/04/14 PM 12:58:12
 * <p>
 * project: hm-dianping
 * package: com.hmdp.utils
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@Component
@Slf4j
public class RedisIdWorker {
    /**
     * 开始时间戳
     */
    private static final long BEGIN_TIMESTAMP = 1640995200L;
    /**
     * 序列号的位数
     */
    private static final int COUNT_BITS = 32;

    private final StringRedisTemplate stringRedisTemplate;

    public RedisIdWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 生成全局id
     *
     * @param keyPrefix
     * @return
     */
    public long nextId(String keyPrefix) {
        // 1.生成时间戳
        // 获取当前时间戳
        LocalDateTime now = LocalDateTime.now();
        // 将当前时间 now 转换为从1970-01-01T00:00:00Z（UTC）开始的秒数
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp = nowSecond - BEGIN_TIMESTAMP;

        // 2.生成序列号
        // 2.1.获取当前日期，精确到天
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        // 2.2.自增长  key 对应的值自增1
        Long count = stringRedisTemplate.opsForValue().increment("icr:" + keyPrefix + ":" + date);
        log.info("自增长count: {}", count);

        // 3.拼接并返回 << 32位
        return timestamp << COUNT_BITS | (count == null ? 0 : count);
    }
}
