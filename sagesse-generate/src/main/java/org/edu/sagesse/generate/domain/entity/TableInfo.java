package org.edu.sagesse.generate.domain.entity;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>数据库表信息实体类</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Setter
@Getter
public class TableInfo {
    /**
     * 表名称
     */
    private String name;
    /**
     * 注释信息
     */
    private String comment;
    /**
     * 全部字段信息
     */
    private List<ColumnInfo> allColumns;
    /**
     * 主键字段信息
     */
    private List<ColumnInfo> pkColumns;
    /**
     * 非主键字段信息
     */
    private List<ColumnInfo> otherColumns;

    public void build(List<ColumnInfo> allColumns) {
        this.allColumns = allColumns;
        this.pkColumns = Lists.newArrayList();
        this.otherColumns = Lists.newArrayList();
        allColumns.forEach(columnInfo -> {
            if (columnInfo.isPrimary()) {
                this.pkColumns.add(columnInfo);
            } else {
                this.otherColumns.add(columnInfo);
            }
        });
    }
}
