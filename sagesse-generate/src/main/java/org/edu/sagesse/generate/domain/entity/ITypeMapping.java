package org.edu.sagesse.generate.domain.entity;

/**
 * <p>类型映射接口</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
public interface ITypeMapping {
    /**
     * <p>获取字段类型</p>
     *
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/30 10:14
     */
    String getColumnType();

    /**
     * <p>获取java全类型</p>
     *
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/30 10:14
     */
    String getJavaType();

    /**
     * <p>获取java短类型</p>
     *
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/30 10:14
     */
    String getJavaShortType();

    /**
     * <p>是否需要引入该类型的包</p>
     *
     * @return boolean
     * @author guocq
     * @date 2022/11/30 10:20
     */
    boolean isRequireImport();
}
