package org.edu.sagesse.generate.service.impl;

import org.edu.sagesse.generate.dao.ColumnInfoDao;
import org.edu.sagesse.generate.domain.entity.ColumnInfo;
import org.edu.sagesse.generate.service.ColumnInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>字段信息业务服务接口实现类</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Service(value = "columnInfoService")
public class ColumnInfoServiceImpl implements ColumnInfoService {
    @Resource
    private ColumnInfoDao columnInfoDao;

    /**
     * <p>根据表名查询字段信息</p>
     *
     * @param schema    数据库名称
     * @param tableName 表名称
     * @return List<ColumnInfo>
     * @author guocq
     * @date 2022/11/30 9:40
     */
    @Override
    public List<ColumnInfo> findColumnsByTableName(String schema, String tableName) {
        List<ColumnInfo> allColumns = columnInfoDao.findAllColumns(schema, tableName);
        allColumns.forEach(ColumnInfo::build);
        return allColumns;
    }
}
