package org.edu.sagesse.generate.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>类型映射</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Setter
@Getter
public class TypeMapping implements ITypeMapping {
    /**
     * 字段类型
     */
    private String columnType;

    /**
     * java全类型
     */
    private String javaType;

    /**
     * java短类型
     */
    private String javaShortType;

    /**
     * 是否需要引入该类型的包
     */
    private boolean requireImport;
}
