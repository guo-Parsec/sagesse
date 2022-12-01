package org.edu.sagesse.data.cache.support.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.edu.sagesse.common.support.helper.ReflectHelper;
import org.edu.sagesse.common.support.helper.SpelHelper;
import org.edu.sagesse.common.support.helper.SpringBeanHelper;
import org.edu.sagesse.common.util.ArrayUtil;
import org.edu.sagesse.data.cache.support.annotation.CacheClear;
import org.edu.sagesse.data.cache.support.annotation.CacheGroup;
import org.edu.sagesse.data.redis.component.RedisComponent;
import org.edu.sagesse.data.redis.support.helper.RedisHelper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>缓存切面支持类</p>
 *
 * @author guocq
 * @see CacheClear 缓存清除
 * @see CacheGroup 缓存组
 */
@Component
@Aspect
public class CacheAspectSupport {

    @Pointcut(value = "@annotation(org.edu.sagesse.data.cache.support.annotation.CacheClear)")
    public void cacheClearPointCut() {

    }

    @Pointcut(value = "@annotation(org.edu.sagesse.data.cache.support.annotation.CacheGroup)")
    public void cacheGroupPointCut() {

    }


    @Around(value = "cacheClearPointCut() || cacheGroupPointCut()", argNames = "joinPoint")
    public Object cacheAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        // 得到被切面修饰的方法的参数列表
        Object[] args = joinPoint.getArgs();
        // 得到被代理的方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        result = joinPoint.proceed(args);
        CacheClear cacheClear = ReflectHelper.findMethodAnnotation(method, CacheClear.class);
        CacheGroup cacheGroup = ReflectHelper.findMethodAnnotation(method, CacheGroup.class);
        if (cacheClear != null) {
            doSingleCacheClear(args, method, cacheClear, result);
        }
        if (cacheGroup != null) {
            doCacheGroup(args, method, cacheGroup, result);
        }
        return result;
    }

    /**
     * <p>单个缓存清空</p>
     *
     * @param args       方法参数
     * @param method     方法
     * @param cacheClear 缓存清空注解
     * @param result     方法返回值
     * @author guocq
     * @date 2022/12/1 11:40
     */
    private void doSingleCacheClear(Object[] args, Method method, CacheClear cacheClear, Object result) {
        Map<String, Object> varMap = SpelHelper.buildMethodVarMap(method, args, result);
        String parse = SpelHelper.parse(cacheClear.key(), varMap, String.class);
        String redisKey = RedisHelper.keyJoin(cacheClear.name(), parse);
        if (cacheClear.fuzzyMatch()) {
            redisKey = RedisHelper.keyJoin(redisKey, "*");
        }
        RedisComponent bean = SpringBeanHelper.getBean(RedisComponent.class);
        bean.delByPattern(redisKey);
    }

    /**
     * <p>缓存组处理</p>
     *
     * @param args       方法参数
     * @param method     方法
     * @param cacheGroup 缓存组注解
     * @param result     方法返回值
     * @author guocq
     * @date 2022/12/1 11:42
     */
    private void doCacheGroup(Object[] args, Method method, CacheGroup cacheGroup, Object result) {
        CacheClear[] cacheClears = cacheGroup.cacheClear();
        if (ArrayUtil.isEmpty(cacheClears)) {
            return;
        }
        for (CacheClear cacheClear : cacheClears) {
            doSingleCacheClear(args, method, cacheClear, result);
        }
    }
}
