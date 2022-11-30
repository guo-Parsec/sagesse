package org.edu.sagesse.generate.service;

import org.edu.sagesse.generate.domain.entity.ColumnInfo;

import java.util.List;

/**
 * <p>字段信息业务服务接口</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
public interface ColumnInfoService {
    /**
     * <p>根据表名查询字段信息</p>
     *
     * @param schema    数据库名称
     * @param tableName 表名称
     * @return List<ColumnInfo>
     * @author guocq
     * @date 2022/11/30 9:40
     */
    List<ColumnInfo> findColumnsByTableName(String schema, String tableName);
}
