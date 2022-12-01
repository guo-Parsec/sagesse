package org.edu.sagesse.data.redis.component;

import com.google.common.collect.Lists;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>Redis辅助类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@Component
public class RedisComponent {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisComponent(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * <p>获取全部key</p>
     *
     * @param pattern key匹配符
     * @return java.util.Set<java.lang.String>
     * @author guocq
     * @date 2022/11/16 17:03
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * <p>根据匹配符获取所有value</p>
     *
     * @param pattern 匹配符
     * @return java.util.List<java.lang.Object>
     * @author guocq
     * @date 2022/11/17 15:46
     */
    public List<Object> findList(String pattern) {
        Set<String> keys = keys(pattern);
        return keys.stream().map(this::get).collect(Collectors.toList());
    }

    /**
     * <p>根据key获取值</p>
     *
     * @param key 键
     * @return java.lang.Object
     * @author hedwing
     * @since 2022/11/26
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * <p>向redis中添加 kv </p>
     *
     * @param key      键
     * @param value    值
     * @param time     过期时间
     * @param timeUnit 时间单位
     * @author hedwing
     * @since 2022/11/26
     */
    public void put(String key, Object value, long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    /**
     * <p>向redis中添加 kv </p>
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间
     * @author hedwing
     * @since 2022/11/26
     */
    public void put(String key, Object value, long time) {
        put(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * <p>向redis中添加 kv </p>
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间
     * @author hedwing
     * @since 2022/11/26
     */
    public void putHour(String key, Object value, long time) {
        put(key, value, time, TimeUnit.HOURS);
    }

    /**
     * <p>向redis中添加 kv </p>
     *
     * @param key   键
     * @param value 值
     * @author hedwing
     * @since 2022/11/26
     */
    public void put(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * <p>删除属性</p>
     *
     * @param key 键
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/11/26
     */
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * <p>批量删除属性</p>
     *
     * @param keys 键的列表
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long del(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * <p>根据匹配条件删除所有键</p>
     *
     * @param pattern 匹配符
     * @return java.lang.Long
     * @author guocq
     * @date 2022/11/16 17:05
     */
    public Long delByPattern(String pattern) {
        return del(Lists.newArrayList(keys(pattern)));
    }

    /**
     * <p>设置过期时间</p>
     *
     * @param key  key
     * @param time time
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean expire(String key, long time) {
        return expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * <p>设置过期时间</p>
     *
     * @param key      key
     * @param time     time
     * @param timeUnit timeUnit
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean expire(String key, long time, TimeUnit timeUnit) {
        return redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * <p>获取过期时间</p>
     *
     * @param key key
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * <p>判断是否有该属性</p>
     *
     * @param key key
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * <p>按delta递增</p>
     *
     * @param key   key
     * @param delta delta
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * <p>按delta递减</p>
     *
     * @param key   key
     * @param delta delta
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long decr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * <p>获取Hash结构中的属性</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @return java.lang.Object
     * @author hedwing
     * @since 2022/9/17
     */
    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * <p>向Hash结构中放入一个属性</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @param value   value
     * @param time    time
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean hSet(String key, String hashKey, Object value, long time) {
        redisTemplate.opsForHash().put(key, hashKey, value);
        return expire(key, time);
    }

    /**
     * <p>向Hash结构中放入一个属性</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @param value   value
     * @author hedwing
     * @since 2022/9/17
     */
    public void hSet(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * <p>直接获取整个Hash结构</p>
     *
     * @param key key
     * @return java.util.Map<java.lang.Object, java.lang.Object>
     * @author hedwing
     * @since 2022/9/17
     */
    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * <p>直接设置整个Hash结构</p>
     *
     * @param key  key
     * @param map  map
     * @param time time
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean hSetAll(String key, Map<String, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        return expire(key, time);
    }

    /**
     * <p>直接设置整个Hash结构</p>
     *
     * @param key key
     * @param map map
     * @author hedwing
     * @since 2022/9/17
     */
    public void hSetAll(String key, Map<String, ?> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * <p>删除Hash结构中的属性</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @author hedwing
     * @since 2022/9/17
     */
    public void hDel(String key, Object... hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    /**
     * <p>判断Hash结构中是否有该属性</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean hHasKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    /**
     * <p>Hash结构中属性递增</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long hIncr(String key, String hashKey, Long delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    /**
     * <p>Hash结构中属性递减</p>
     *
     * @param key     key
     * @param hashKey hashKey
     * @param delta   delta
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long hDecr(String key, String hashKey, Long delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, -delta);
    }

    /**
     * <p>获取Set结构</p>
     *
     * @param key key
     * @return java.util.Set<java.lang.Object>
     * @author hedwing
     * @since 2022/9/17
     */
    public Set<Object> sMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * <p>向Set结构中添加属性</p>
     *
     * @param key    key
     * @param values values
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long sAdd(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * <p>向Set结构中添加属性</p>
     *
     * @param key    key
     * @param time   time
     * @param values values
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long sAdd(String key, long time, Object... values) {
        Long count = redisTemplate.opsForSet().add(key, values);
        expire(key, time);
        return count;
    }

    /**
     * <p>是否为Set中的属性</p>
     *
     * @param key   key
     * @param value value
     * @return java.lang.Boolean
     * @author hedwing
     * @since 2022/9/17
     */
    public Boolean sIsMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * <p>获取Set结构的长度</p>
     *
     * @param key key
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * <p>删除Set结构中的属性</p>
     *
     * @param key    key
     * @param values values
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long sRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * <p>获取List结构中的属性</p>
     *
     * @param key key
     * @return java.util.List<java.lang.Object>
     * @author guocq
     * @date 2022/11/18 9:58
     */
    public List<Object> lRange(String key) {
        Long end = lSize(key);
        return lRange(key, 0, end);
    }

    /**
     * <p>获取List结构中的属性</p>
     *
     * @param key   key
     * @param start start
     * @param end   end
     * @return java.util.List<java.lang.Object>
     * @author hedwing
     * @since 2022/9/17
     */
    public List<Object> lRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * <p>获取List结构的长度</p>
     *
     * @param key key
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long lSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * <p>根据索引获取List中的属性</p>
     *
     * @param key   key
     * @param index index
     * @return java.lang.Object
     * @author hedwing
     * @since 2022/9/17
     */
    public Object lIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * <p>向List结构中添加属性</p>
     *
     * @param key   key
     * @param value value
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long lPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * <p>向List结构中添加属性</p>
     *
     * @param key   key
     * @param value value
     * @param time  time
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long lPush(String key, Object value, long time) {
        Long index = redisTemplate.opsForList().rightPush(key, value);
        expire(key, time);
        return index;
    }

    /**
     * <p>向List结构中批量添加属性</p>
     *
     * @param key    key
     * @param values values
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long lPushAll(String key, Object... values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * <p>向List结构中批量添加属性</p>
     *
     * @param key    key
     * @param time   time
     * @param values values
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long lPushAll(String key, Long time, Object... values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        expire(key, time);
        return count;
    }

    /**
     * <p>从List结构中移除属性</p>
     *
     * @param key   key
     * @param count count
     * @param value value
     * @return java.lang.Long
     * @author hedwing
     * @since 2022/9/17
     */
    public Long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }
}
