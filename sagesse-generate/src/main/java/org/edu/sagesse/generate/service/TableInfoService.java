package org.edu.sagesse.generate.service;

import org.edu.sagesse.generate.domain.entity.TableInfo;

import java.util.List;

/**
 * <p>表信息业务服务接口</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
public interface TableInfoService {
    /**
     * <p>根据表名查询字段信息</p>
     *
     * @param schema 数据库名称
     * @return List<ColumnInfo>
     * @author guocq
     * @date 2022/11/30 9:40
     */
    List<TableInfo> findTables(String schema);
}
