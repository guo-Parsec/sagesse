package org.edu.sagesse.generate.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.generate.domain.entity.ColumnInfo;

import java.util.List;

/**
 * <p>字段信息持久层</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Mapper
public interface ColumnInfoDao {
    /**
     * <p>根据数据库和表名查询该表中的所有字段属性</p>
     *
     * @param schema 数据库名
     * @param table  表名
     * @return 字段列表{@link List<ColumnInfo>}
     * @author guocq
     * @date 2022/11/30 10:06
     */
    List<ColumnInfo> findAllColumns(@Param("schema") String schema, @Param("table") String table);
}
