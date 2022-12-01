package org.edu.sagesse.data.redis.support.helper;

import org.edu.sagesse.common.support.pool.RedisPool;
import org.edu.sagesse.common.util.StringUtil;

/**
 * <p>redis辅助类</p>
 *
 * @author guocq
 */
public class RedisHelper {
    /**
     * <p>redis key 合并</p>
     *
     * @param array 字符数组
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/10 15:12
     */
    public static String keyJoin(final Object... array) {
        return StringUtil.joinWith(RedisPool.REDIS_KEY_SEPARATOR, array);
    }
}
