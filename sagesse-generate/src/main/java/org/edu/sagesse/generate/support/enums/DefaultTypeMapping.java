package org.edu.sagesse.generate.support.enums;

import lombok.Getter;
import org.edu.sagesse.generate.domain.entity.ITypeMapping;

import java.util.Arrays;

/**
 * <p>默认类型映射器</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
public enum DefaultTypeMapping implements ITypeMapping {
    /**
     * 默认类型定义
     */
    BIGINT("bigint", "java.lang.Long", "Long"),

    VARCHAR("varchar"),

    INT("int", "java.lang.Integer", "Integer"),

    TINYINT("tinyint", "java.lang.Integer", "Integer"),

    DATETIME("datetime", "java.time.LocalDateTime", "LocalDateTime", true),

    LONGTEXT("longtext"),

    TEXT("text"),

    SMALLINT("smallint", "java.lang.Integer", "Integer"),

    MEDIUMTEXT("mediumtext"),

    DATE("date", "java.time.LocalDate", "java.time.LocalDate", true),

    BIT("bit", "java.lang.Boolean", "Boolean"),

    MEDIUMINT("mediumint", "java.lang.Integer", "Integer"),

    FLOAT("float", "java.lang.Double", "Double"),

    DOUBLE("double", "java.lang.Double", "Double"),

    DECIMAL("decimal", "java.math.BigDecimal", "BigDecimal", true),

    CHAR("char"),

    TINYTEXT("tinytext"),
    ;

    /**
     * 字段类型
     */
    @Getter
    private final String columnType;
    /**
     * java全类型
     */
    @Getter
    private final String javaType;
    /**
     * java短类型
     */
    @Getter
    private final String javaShortType;
    /**
     * 是否需要引入该类型的包
     */
    @Getter
    private final boolean requireImport;

    DefaultTypeMapping(String columnType) {
        this.columnType = columnType;
        this.javaType = "java.lang.String";
        this.javaShortType = "String";
        this.requireImport = false;
    }

    DefaultTypeMapping(String columnType, String javaType, String javaShortType) {
        this.columnType = columnType;
        this.javaType = javaType;
        this.javaShortType = javaShortType;
        this.requireImport = false;
    }

    DefaultTypeMapping(String columnType, String javaType, String javaShortType, boolean requireImport) {
        this.columnType = columnType;
        this.javaType = javaType;
        this.javaShortType = javaShortType;
        this.requireImport = requireImport;
    }

    public static DefaultTypeMapping find(String columnType) {
        return Arrays.stream(DefaultTypeMapping.values()).filter(type -> type.getColumnType().equals(columnType))
                .findFirst()
                .orElse(DefaultTypeMapping.VARCHAR);
    }
}
