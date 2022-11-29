package org.edu.sagesse.generate.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>数据库数据表结构</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@Setter
@Getter
@ToString
public class DbTable {
    private String tableName;

    private String modelName;

    private String serviceName;

    private String daoName;

    private String packageName;
}
