package com.buercorp.wangyu.config;//package com.buercorp.wangyu.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
///**
// * ClassName: RedisConfig
// * Description:
// * Date: 2023/04/14 AM 11:30:28
// * <p>
// * project: redis-demo
// * package: com.heima.redis.config
// * email: 1085844536@qq.com
// * version:
// *
// * @author WangGuojian
// */
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        // 创建 RedisTemplate 对象
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        // 设置连接工厂
//        template.setConnectionFactory(connectionFactory);
//        // 创建 JSON 序列化工具
//        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//        // 设置 key 的序列化工具
//        template.setKeySerializer(RedisSerializer.string());
//        template.setHashKeySerializer(RedisSerializer.string());
//        // 设置 Value 的序列化
//        template.setValueSerializer(jsonRedisSerializer);
//        template.setHashValueSerializer(jsonRedisSerializer);
//        // 返回
//        return template;
//    }
//}




import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Redis的配置信息
 *
 * @author Administrator
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        log.info("Redis的KeySerializer设置为：{}", StringRedisSerializer.class);
        // 默认的Key序列化器为：JdkSerializationRedisSerializer
        // 将key的序列化器改为StringRedisSerializer，以便可以在Redis的key设置什么就显示什么，不进行转化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    /**
     * 缓存管理
     *
     * @return 返回缓存管理信息
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 缓存配置
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                // 默认没有特殊指定的缓存，设置失效时间为1天
                .entryTtl(Duration.ofDays(1))
                // 在缓存名称前加上前缀
                .computePrefixWith(cacheName -> "default:" + cacheName)
                .disableCachingNullValues()
                // 设置value的序列化方式
                .serializeValuesWith(RedisSerializationContext.
                        SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()))
                // 设置key的序列化方式
                .serializeKeysWith(RedisSerializationContext.
                        SerializationPair
                        .fromSerializer(RedisSerializer.string()));
        log.info("设置redis缓存的默认失效时间，失效时间默认为：{}天", defaultCacheConfig.getTtl().toDays());
        // 针对不同cacheName，设置不同的失效时间，map的key是缓存名称（注解设定的value/cacheNames），value是缓存的失效配置
        Map<String, RedisCacheConfiguration> initialCacheConfiguration = new HashMap<String, RedisCacheConfiguration>(8);
        // 设定失效时间为1小时
        initialCacheConfiguration.put("redisCache", getDefaultSimpleConfiguration().entryTtl(Duration.ofHours(1)));
        // 设定失效时间为10分钟
        initialCacheConfiguration.put("userName", getDefaultSimpleConfiguration().entryTtl(Duration.ofMinutes(10)));
        // 设定失效时间为12小时
        initialCacheConfiguration.put("userCache2", getDefaultSimpleConfiguration().entryTtl(Duration.ofHours(12)));
        // ...如果有其他的不同cacheName需要控制失效时间，以此类推即可进行添加
        return RedisCacheManager.builder(redisConnectionFactory)
                // 设置缓存默认失效时间配置，也就是动态或者未指定的缓存将会使用当前配置
                .cacheDefaults(defaultCacheConfig)
                // 不同不同cacheName的个性化配置
                .withInitialCacheConfigurations(initialCacheConfiguration).build();
    }

    /**
     * 覆盖默认的构造key[默认拼接的时候是两个冒号（::）]，否则会多出一个冒号
     *
     * @return 返回缓存配置信息
     */
    private RedisCacheConfiguration getDefaultSimpleConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(cacheName -> cacheName + ":");
    }

}
