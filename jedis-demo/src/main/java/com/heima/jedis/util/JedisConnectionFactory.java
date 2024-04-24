package com.heima.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName: JedisConnectionFactory
 * Description:
 * Date: 2023/04/14 AM 10:41:58
 * <p>
 * project: jedis-demo
 * package: com.heima.jedis.util
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
public class JedisConnectionFactory {

    private static final JedisPool JEDIS_POOL;

    static {
        // 配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMaxIdle(0);
        poolConfig.setMaxWaitMillis(1000);
        JEDIS_POOL = new JedisPool(poolConfig, "192.168.0.20", 6379, 1000, "123321");
    }

    public static Jedis getJedis() {
        return JEDIS_POOL.getResource();
    }
}
