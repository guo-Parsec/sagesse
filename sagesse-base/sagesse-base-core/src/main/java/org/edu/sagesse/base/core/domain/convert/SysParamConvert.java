package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.core.domain.dto.SysParamCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysParamPutDto;
import org.edu.sagesse.base.core.domain.entity.SysParam;
import org.edu.sagesse.base.core.domain.vo.SysParamVo;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统参数表实体转换</p>
 *
 * @author guocq
 * @since 2022-12-01 10:01:52
 */
public class SysParamConvert {
    /**
     * <p>{@link SysParam}转化为{@link SysParamVo}</p>
     *
     * @param sysParam 被转换的原数据
     * @return 转换为{@link SysParamVo}
     * @author guocq
     * @date 2022-12-01 10:01:52
     */
    public static SysParamVo convertSysParamToSysParamVo(SysParam sysParam) {
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

    /**
     * <p>{@link SysParamCreateDto}转化为{@link SysParam}</p>
     *
     * @param sysParamCreateDto 被转换的原数据
     * @return 转换为{@link SysParam}
     * @author guocq
     * @date 2022-12-01 10:01:52
     */
    public static SysParam convertSysParamCreateDtoToSysParam(SysParamCreateDto sysParamCreateDto) {
        if (sysParamCreateDto == null) {
            return SysParam.EMPTY;
        }
        return Builder.builder(SysParam::new)
                .enhanceWith(SysParam::setCategoryCode, sysParamCreateDto::getCategoryCode)
                .enhanceWith(SysParam::setCategoryName, sysParamCreateDto::getCategoryName)
                .enhanceWith(SysParam::setParamName, sysParamCreateDto::getParamName)
                .enhanceWith(SysParam::setParamCode, sysParamCreateDto::getParamCode)
                .enhanceWith(SysParam::setParamValue, sysParamCreateDto::getParamValue)
                .build();
    }

    /**
     * <p>{@link SysParamPutDto}转化为{@link SysParam}</p>
     *
     * @param sysParamPutDto 被转换的原数据
     * @return 转换为{@link SysParam}
     * @author guocq
     * @date 2022-12-01 10:01:52
     */
    public static SysParam convertSysParamPutDtoToSysParam(SysParamPutDto sysParamPutDto) {
        if (sysParamPutDto == null) {
            return SysParam.EMPTY;
        }
        return Builder.builder(SysParam::new)
                .enhanceWith(SysParam::setId, sysParamPutDto::getId)
                .enhanceWith(SysParam::setCategoryCode, sysParamPutDto::getCategoryCode)
                .enhanceWith(SysParam::setCategoryName, sysParamPutDto::getCategoryName)
                .enhanceWith(SysParam::setParamName, sysParamPutDto::getParamName)
                .enhanceWith(SysParam::setParamCode, sysParamPutDto::getParamCode)
                .enhanceWith(SysParam::setParamValue, sysParamPutDto::getParamValue)
                .enhanceWith(SysParam::setDataStatus, sysParamPutDto::getDataStatus)
                .build();
    }
}
