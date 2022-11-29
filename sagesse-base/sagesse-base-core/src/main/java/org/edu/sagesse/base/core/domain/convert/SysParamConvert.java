package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysParamVo;
import org.edu.sagesse.base.core.domain.entity.SysParam;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统参数表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:41
 */
public class SysParamConvert {
    /**
     * <p>{@link SysParam}转化为{@link SysParamVo}</p>
     *
     * @param sysParam 被转换的原数据
     * @return 转换为{@link SysParamVo}
     * @author guocq
     * @date 2022-11-29 15:31:41
     */
    public static SysParamVo entityToSysParamVo(SysParam sysParam) {
        if (sysParam == null) {
            return SysParamVo.EMPTY;
        }
        return Builder.builder(SysParamVo::new)
                .enhanceWith(SysParamVo::setId, sysParam::getId)
                .enhanceWith(SysParamVo::setCategoryCode, sysParam::getCategoryCode)
                .enhanceWith(SysParamVo::setCategoryName, sysParam::getCategoryName)
                .enhanceWith(SysParamVo::setParamName, sysParam::getParamName)
                .enhanceWith(SysParamVo::setParamCode, sysParam::getParamCode)
                .enhanceWith(SysParamVo::setParamValue, sysParam::getParamValue)
                .enhanceWith(SysParamVo::setDataStatus, sysParam::getDataStatus)
                .enhanceWith(SysParamVo::setGmtCreate, sysParam::getGmtCreate)
                .enhanceWith(SysParamVo::setGmtModify, sysParam::getGmtModify)
                .build();
    }
}
