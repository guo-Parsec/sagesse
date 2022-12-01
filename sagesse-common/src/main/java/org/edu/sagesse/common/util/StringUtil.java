package org.edu.sagesse.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * <p>字符串工具类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public class StringUtil extends StringUtils {
    /**
     * 连接符
     */
    public static final String CONNECTOR = "-";

    /**
     * 查找指定字符串是否匹配指定字符串列表中的任意一个字符串
     *
     * @param str           指定字符串
     * @param strCollection 需要检查的字符串数组
     * @return boolean 是否匹配
     * @author guochengqiang
     */
    public static boolean matches(String str, Collection<String> strCollection) {
        if (isEmpty(str) || CollectionUtil.isEmpty(strCollection)) {
            return false;
        }
        return strCollection.stream().anyMatch(pattern -> isMatch(pattern, str));
    }

    /**
     * 从 source 中查询是否包含 target 的元素
     *
     * @param source source
     * @param target target
     * @return true 包含 false 不包含
     */
    public static boolean matches(Collection<String> source, Collection<String> target) {
        if (CollectionUtil.isEmpty(source) || CollectionUtil.isEmpty(target)) {
            return false;
        }
        return source.stream().anyMatch(str -> matches(str, target));
    }

    /**
     * 判断url是否与规则配置:
     * ? 表示单个字符;
     * * 表示一层路径内的任意字符串，不可跨层级;
     * ** 表示任意层路径;
     *
     * @param pattern 匹配规则
     * @param url     需要匹配的url
     * @return 是否匹配
     */
    public static boolean isMatch(String pattern, String url) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, url);
    }

    /**
     * <p>转换为String类型， 对象为空时默认为{@link StringUtil#EMPTY}</p>
     *
     * @param source 源对象
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/29 8:59
     */
    public static <S> String toString(S source) {
        return toString(source, EMPTY);
    }

    /**
     * <p>转换为String类型</p>
     *
     * @param source     源对象
     * @param defaultVal 默认值
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/29 8:57
     */
    public static <S> String toString(S source, String defaultVal) {
        if (source == null) {
            return defaultVal;
        }
        return source.toString();
    }
}
