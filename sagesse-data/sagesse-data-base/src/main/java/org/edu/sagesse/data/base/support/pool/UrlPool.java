package org.edu.sagesse.data.base.support.pool;

/**
 * <p>url常量池</p>
 *
 * @author guocq
 * @since 2022/10/24
 **/
public interface UrlPool {

    /**
     * 全局统一路由
     */
    String GLOBAL_URL_PREFIX = "/sagesse/v1";
    /**
     * 系统用户管理url前缀
     */
    String ADMIN_USER_PREFIX = "/sys/user";

    /**
     * 系统权限管理url前缀
     */
    String ADMIN_PERMISSION_PREFIX = "/sys/permission";

    /**
     * 系统菜单管理url前缀
     */
    String ADMIN_MENU_PREFIX = "/sys/menu";

    /**
     * 系统权限管理url前缀
     */
    String ADMIN_DICT_PREFIX = "/sys/dict";

    /**
     * 系统权限管理url前缀
     */
    String ADMIN_ROLE_PREFIX = "/sys/role";

    /**
     * 系统RSA加解密管理url前缀
     */
    String ADMIN_RSA_PREFIX = "/sys/rsa";
}
