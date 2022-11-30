package org.edu.sagesse.generate.web;

import org.edu.sagesse.common.support.rest.Carrier;
import org.edu.sagesse.generate.domain.entity.ColumnInfo;
import org.edu.sagesse.generate.domain.entity.TableInfo;
import org.edu.sagesse.generate.service.ColumnInfoService;
import org.edu.sagesse.generate.service.TableInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>生成器</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@RestController
public class GenerateController {
    private final ColumnInfoService columnInfoService;

    private final TableInfoService tableInfoService;


    public GenerateController(ColumnInfoService columnInfoService, TableInfoService tableInfoService) {
        this.columnInfoService = columnInfoService;
        this.tableInfoService = tableInfoService;
    }

    @GetMapping(value = "/find/all/columns/schema/{schema}/table/{table}")
    public Carrier<List<ColumnInfo>> findAll(@PathVariable String schema, @PathVariable String table) {
        return Carrier.success(columnInfoService.findColumnsByTableName(schema, table));
    }

    @GetMapping(value = "/find/all/tables/schema/{schema}")
    public Carrier<List<TableInfo>> findTable(@PathVariable String schema) {
        return Carrier.success(tableInfoService.findTables(schema));
    }
}
