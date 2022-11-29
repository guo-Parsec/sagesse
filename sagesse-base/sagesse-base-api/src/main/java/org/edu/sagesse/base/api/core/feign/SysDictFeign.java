package org.edu.sagesse.base.api.core.feign;

import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.api.core.support.pool.BaseApiPool;
import org.edu.sagesse.common.support.rest.Carrier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>数据字典对外服务接口</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@FeignClient(name = BaseApiPool.DICT_FEIGN_PREFIX, contextId = "sysDictFeign")
public interface SysDictFeign {
    /**
     * <p>根据类别码和字典值查询字典名称</p>
     *
     * @param categoryCode 字典类别码
     * @return 字典名称
     * @author guocq
     * @date 2022/11/29 9:23
     */
    @GetMapping("/find/dict-name")
    Carrier<List<Dict>> findDictName(@RequestParam("categoryCode") String categoryCode);
}
