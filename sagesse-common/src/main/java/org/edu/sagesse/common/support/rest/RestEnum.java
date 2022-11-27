package org.edu.sagesse.common.support.rest;

import org.edu.sagesse.common.support.enums.CoreEnum;

/**
 * <p>通用请求状态枚举</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public interface RestEnum extends CoreEnum<Integer, String> {
    /**
     * <p>获取提示信息</p>
     *
     * @return java.lang.String
     * @author hedwing
     * @since 2022/11/26
     */
    String getMessage();

    /**
     * <p>获取值</p>
     *
     * @return java.lang.String
     * @author hedwing
     * @since 2022/11/26
     */
    default String getValue() {
        return getMessage();
    }
}
