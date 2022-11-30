package org.edu.sagesse.generate.service.impl;

import org.edu.sagesse.generate.dao.TableInfoDao;
import org.edu.sagesse.generate.domain.entity.ColumnInfo;
import org.edu.sagesse.generate.domain.entity.TableInfo;
import org.edu.sagesse.generate.service.ColumnInfoService;
import org.edu.sagesse.generate.service.TableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>表信息业务服务接口实现类</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Service(value = "tableInfoService")
public class TableInfoServiceImpl implements TableInfoService {
    private ColumnInfoService columnInfoService;
    private TableInfoDao tableInfoDao;

    @Autowired
    public void setTableInfoDao(TableInfoDao tableInfoDao) {
        this.tableInfoDao = tableInfoDao;
    }

    /**
     * <p>根据表名查询字段信息</p>
     *
     * @param schema 数据库名称
     * @return List<ColumnInfo>
     * @author guocq
     * @date 2022/11/30 9:40
     */
    @Override
    public List<TableInfo> findTables(String schema) {
        List<TableInfo> allTables = tableInfoDao.findAllTables(schema);
        allTables.forEach(table -> {
            List<ColumnInfo> allColumns = columnInfoService.findColumnsByTableName(schema, table.getName());
            table.build(allColumns);
        });
        return allTables;
    }

    @Autowired
    public void setColumnInfoService(ColumnInfoService columnInfoService) {
        this.columnInfoService = columnInfoService;
    }
}
