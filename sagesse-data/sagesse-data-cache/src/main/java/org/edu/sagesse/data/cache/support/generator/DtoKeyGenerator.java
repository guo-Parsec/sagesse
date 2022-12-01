package org.edu.sagesse.data.cache.support.generator;

import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.common.support.pool.RedisPool;
import org.edu.sagesse.common.util.JsonUtil;
import org.edu.sagesse.common.util.ObjectUtil;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>查询dto缓存key生成器</p>
 *
 * @author guocq
 * @since 2022/12/1
 **/
@Component(value = "dtoKeyGenerator")
public class DtoKeyGenerator implements KeyGenerator {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(DtoKeyGenerator.class);

    /**
     * Generate a key for the given method and its parameters.
     *
     * @param target the target instance
     * @param method the method being called
     * @param params the method parameters (with any var-args expanded)
     * @return a generated key
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        int length = params.length;
        if (length == 0 || length > 1) {
            LOGGER.error("当前缓存方法参数个数为{}不符合只有一个参数的条件", length);
            throw new CoreException("当前缓存方法参数个数不符合只有一个参数的条件");
        }
        Object param = params[0];
        if (param instanceof AbstractDto) {
            Map<String, Object> map = JsonUtil.objectToMap(param);
            StringBuilder keyBuilder = new StringBuilder();
            map.forEach((name, value) -> {
                if (ObjectUtil.isNotBlank(value)) {
                    keyBuilder.append(name).append(RedisPool.REDIS_KEY_SEPARATOR).append(value);
                }
            });
            return keyBuilder.toString();
        }
        LOGGER.error("当前缓存方法参数{}不是AbstractDto及其子类，不能使用QueryDtoKeyGenerator", param.getClass().getSimpleName());
        throw new CoreException("当前缓存方法参数不是AbstractDto及其子类，不能使用QueryDtoKeyGenerator");
    }
}
