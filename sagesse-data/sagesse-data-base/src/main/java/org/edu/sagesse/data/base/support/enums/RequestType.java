package org.edu.sagesse.data.base.support.enums;

import java.util.Locale;

/**
 * <p>请求类型</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public enum RequestType {
    /**
     * GET
     */
    GET,
    /**
     * POST
     */
    POST,
    /**
     * PUT
     */
    PUT,
    /**
     * DELETE
     */
    DELETE;

    /**
     * <p>根据指定method获取枚举对象</p>
     *
     * @param method method
     * @return RequestType
     * @author hedwing
     * @since 2022/11/26
     */
    public static RequestType findRequestType(String method) {
        return RequestType.valueOf(method.toUpperCase(Locale.ROOT));
    }
}
