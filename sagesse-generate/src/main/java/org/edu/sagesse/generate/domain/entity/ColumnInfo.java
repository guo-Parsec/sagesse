package org.edu.sagesse.generate.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.generate.support.enums.DefaultTypeMapping;

import java.util.Map;

/**
 * <p>数据库表字段信息实体类</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Setter
@Getter
public class ColumnInfo {
    /**
     * 是否为主键
     */
    private boolean primary;
    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段注释
     */
    private String comment;
    /**
     * 字段类型
     */
    private String type;
    /**
     * Java类型
     */
    private String javaType;
    /**
     * Java短类型
     */
    private String shortJavaType;
    /**
     * 是否需要引入包
     */
    private boolean requiredImport;
    /**
     * 额外数据
     */
    private Map<String, Object> ext;

    public void build() {
        DefaultTypeMapping defaultTypeMapping = DefaultTypeMapping.find(this.type);
        this.javaType = defaultTypeMapping.getJavaType();
        this.shortJavaType = defaultTypeMapping.getJavaShortType();
        this.requiredImport = defaultTypeMapping.isRequireImport();
    }
}
