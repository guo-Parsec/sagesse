package org.edu.sagesse.common.support.helper;

import com.google.common.collect.Sets;
import org.edu.sagesse.common.support.enums.StatusEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>枚举辅助类</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
public class EnumHelper {
    /**
     * <p>获取状态码值集合</p>
     *
     * @param statusEnums 状态枚举
     * @return java.util.Set<java.lang.Integer>
     * @author guocq
     * @date 2022/11/28 15:16
     */
    public static Set<Integer> getStatusCodeSet(StatusEnum... statusEnums) {
        if (statusEnums == null || statusEnums.length == 0) {
            return Sets.newHashSet();
        }
        return Arrays.stream(statusEnums).map(StatusEnum::value).collect(Collectors.toSet());
    }
}
