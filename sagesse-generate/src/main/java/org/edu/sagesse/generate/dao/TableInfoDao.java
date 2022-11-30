package org.edu.sagesse.generate.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.generate.domain.entity.TableInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>字段信息持久层</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Repository
@Mapper
public interface TableInfoDao {
    /**
     * <p>根据数据库和表名查询该表中的所有字段属性</p>
     *
     * @param schema 数据库名
     * @return 字段列表{@link List<ColumnInfo>}
     * @author guocq
     * @date 2022/11/30 10:06
     */
    List<TableInfo> findAllTables(@Param("schema") String schema);
}
