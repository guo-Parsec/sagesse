package org.edu.sagesse.base.core.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.core.domain.vo.SysDictVo;
import org.edu.sagesse.base.core.service.SysDictService;
import org.edu.sagesse.common.support.rest.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>系统字典详情表业务类Controller</p>
 *
 * @author guocq
 * @since 2022-12-01 10:30:29
 */
@RestController
@Api(value = "系统字典详情表controller", tags = "系统字典详情表controller")
@RequestMapping(value = "")
public class SysDictController {
    private SysDictService sysDictService;

    @ApiOperation(value = "根据类别码和字典值查询字典，类别码和字典值可为空")
    @GetMapping("/list")
    public Carrier<List<SysDictVo>> list(@RequestParam(value = "categoryCode", required = false) String categoryCode,
                                         @RequestParam(value = "dictValue", required = false) String dictValue) {
        return Carrier.success(sysDictService.findByCategoryCodeAndDictValue(categoryCode, dictValue));
    }

    /**
     * <p>根据类别码和字典值查询字典名称</p>
     *
     * @param categoryCode 字典类别码
     * @return 字典名称
     * @author guocq
     * @date 2022/11/29 9:23
     */
    @ApiOperation(value = "根据类别码和字典值查询字典名称")
    @GetMapping("/find/dict-name")
    public Carrier<List<Dict>> findDictName(@RequestParam("categoryCode") String categoryCode) {
        return Carrier.success(sysDictService.findDictName(categoryCode));
    }

    @Autowired
    public void setSysDictService(SysDictService sysDictService) {
        this.sysDictService = sysDictService;
    }
}
