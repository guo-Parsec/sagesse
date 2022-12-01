package org.edu.sagesse.data.cache.config;

import org.edu.sagesse.common.support.pool.RedisPool;
import org.edu.sagesse.data.redis.support.helper.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * <p>缓存配置</p>
 *
 * @author guocq
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
    private RedisSerializer<Object> redisSerializer;

    /**
     * 申明缓存管理器，会创建一个切面（aspect）并触发Spring缓存注解的切点（pointcut）
     * 根据类或者方法所使用的注解以及缓存的状态，这个切面会从缓存中获取数据，将数据添加到缓存之中或者从缓存中移除某个值
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> keySerializer = new StringRedisSerializer();
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);

        //设置Redis缓存有效期为1小时
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(4))
                .computePrefixWith(name -> RedisHelper.keyJoin(RedisPool.BASE_REDIS_KEY, name) + RedisPool.REDIS_KEY_SEPARATOR)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }

    @Autowired
    public void setRedisSerializer(RedisSerializer<Object> redisSerializer) {
        this.redisSerializer = redisSerializer;
    }
}
