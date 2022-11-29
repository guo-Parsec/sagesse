package org.edu.sagesse.generate.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>数据库列字段结构</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@Setter
@Getter
@ToString
public class DbColumn {
    private String propertyName;

    private String columnName;

    private String type;
}
