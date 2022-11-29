package org.edu.sagesse.base.api.core.support.pool;

/**
 * <p>基础服务对外提供常量池</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
public interface BaseApiPool {
    /**
     * base服务应用名称
     */
    String APPLICATION_NAME = "sagesse-base";

    /**
     * base服务请求前缀
     */
    String BASE_REQUEST_PREFIX = "/base";

    /**
     * 字典管理请求前缀
     */
    String DICT_REQUEST_PREFIX = "/sys/dict";

    /**
     * 系统字段对外管理接口前缀
     */
    String DICT_FEIGN_PREFIX = APPLICATION_NAME + BASE_REQUEST_PREFIX + DICT_REQUEST_PREFIX;
}
