package org.edu.sagesse.common.util;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <p>对象工具类</p>
 *
 * @author hedwing
 * @since 2022/8/20
 **/
public class ObjectUtil {
    /**
     * 只要有一个对象为空则为空
     *
     * @param objects 对象列表
     * @return 是否为空
     */
    public static boolean isAnyNull(Object... objects) {
        if (objects == null || objects.length == 0) {
            return true;
        }
        return Stream.of(objects).anyMatch(Objects::isNull);
    }

    /**
     * 只有所有对象为空则为空
     *
     * @param objects 对象列表
     * @return 是否为空
     */
    public static boolean isAllNull(Object... objects) {
        if (objects == null || objects.length == 0) {
            return true;
        }
        return Stream.of(objects).allMatch(Objects::isNull);
    }

    /**
     * <p>判断对象是否为空</p>
     *
     * @param object 对象
     * @return boolean
     * @author guocq
     * @date 2022/12/1 14:01
     */
    public static boolean isBlank(Object object) {
        return Objects.isNull(object) || StringUtil.isBlank(StringUtil.toString(object));
    }

    /**
     * <p>判断对象是否不为空</p>
     *
     * @param object 对象
     * @return boolean
     * @author guocq
     * @date 2022/12/1 14:01
     */
    public static boolean isNotBlank(Object object) {
        return !isBlank(object);
    }
}
