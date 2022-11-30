package org.edu.sagesse.generate.web;

import org.edu.sagesse.generate.domain.entity.TableInfo;
import org.edu.sagesse.generate.service.TableInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>前端页面Controller</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Controller
public class PageController {
    private final TableInfoService tableInfoService;

    public PageController(TableInfoService tableInfoService) {
        this.tableInfoService = tableInfoService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        List<TableInfo> tables = tableInfoService.findTables("sagesse_core_db");
        model.addAttribute("tables", tables);
        return "index";
    }
}
