package org.edu.sagesse.common.support.helper;

/**
 * <p>转化辅助类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public class ConvertHelper {
    /**
     * <p>类型为S的对象source转化为</p>
     * @param source 被转换原对象
     * @param tClass 目标的类对象
     * @return T
     * @author hedwing
     * @since 2022/11/26
     */
    public static <T, S> T convert(S source, Class<T> tClass) {
        return tClass.cast(source);
    }
}
