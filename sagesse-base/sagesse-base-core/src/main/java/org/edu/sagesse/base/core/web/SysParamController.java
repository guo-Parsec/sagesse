package org.edu.sagesse.base.core.web;

import io.swagger.annotations.Api;
import org.edu.sagesse.base.core.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>系统参数表业务类Controller</p>
 *
 * @author guocq
 * @since 2022-12-01 10:20:51
 */
@RestController
@Api(value = "系统参数表controller", tags = "系统参数表controller")
@RequestMapping(value = "")
public class SysParamController {
    private SysParamService sysParamService;

    @Autowired
    public void setSysParamService(SysParamService sysParamService) {
        this.sysParamService = sysParamService;
    }
}
