package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysParamVo;
import org.edu.sagesse.base.core.domain.dto.param.SysParamCreateDto;
import org.edu.sagesse.base.core.domain.dto.param.SysParamPageDto;
import org.edu.sagesse.base.core.domain.dto.param.SysParamPutDto;
import org.edu.sagesse.base.core.domain.dto.param.SysParamQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysParam;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统参数表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 18:04:08
 */
public class SysParamConvert {
    /**
     * <p>{@link SysParam}转化为{@link SysParamVo}</p>
     *
     * @param sysParam 被转换的原数据
     * @return 转换为{@link SysParamVo}
     * @author guocq
     * @date 2022-11-29 18:04:08
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

    /**
     * <p>{@link SysParamQueryDto}转化为{@link SysParam}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysParam}
     * @author guocq
     * @date 2022-11-29 18:04:08
     */
    public static SysParam sysParamQueryDtoToEntity(SysParamQueryDto dto) {
        if (dto == null) {
            return SysParam.EMPTY;
        }
        return Builder.builder(SysParam::new)
                .enhanceWith(SysParam::setId, dto::getId)
                .enhanceWith(SysParam::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysParam::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysParam::setParamName, dto::getParamName)
                .enhanceWith(SysParam::setParamCode, dto::getParamCode)
                .enhanceWith(SysParam::setParamValue, dto::getParamValue)
                .enhanceWith(SysParam::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysParam::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysParam::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysParamPageDto}转化为{@link SysParam}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysParam}
     * @author guocq
     * @date 2022-11-29 18:04:08
     */
    public static SysParam sysParamPageDtoToEntity(SysParamPageDto dto) {
        if (dto == null) {
            return SysParam.EMPTY;
        }
        return Builder.builder(SysParam::new)
                .enhanceWith(SysParam::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysParam::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysParam::setParamName, dto::getParamName)
                .enhanceWith(SysParam::setParamCode, dto::getParamCode)
                .enhanceWith(SysParam::setParamValue, dto::getParamValue)
                .build();
    }

    /**
     * <p>{@link SysParamCreateDto}转化为{@link SysParam}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysParam}
     * @author guocq
     * @date 2022-11-29 18:04:08
     */
    public static SysParam sysParamCreateDtoToEntity(SysParamCreateDto dto) {
        if (dto == null) {
            return SysParam.EMPTY;
        }
        return Builder.builder(SysParam::new)
                .enhanceWith(SysParam::setId, dto::getId)
                .enhanceWith(SysParam::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysParam::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysParam::setParamName, dto::getParamName)
                .enhanceWith(SysParam::setParamCode, dto::getParamCode)
                .enhanceWith(SysParam::setParamValue, dto::getParamValue)
                .enhanceWith(SysParam::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysParam::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysParam::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysParamPutDto}转化为{@link SysParam}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysParam}
     * @author guocq
     * @date 2022-11-29 18:04:08
     */
    public static SysParam sysParamPutDtoToEntity(SysParamPutDto dto) {
        if (dto == null) {
            return SysParam.EMPTY;
        }
        return Builder.builder(SysParam::new)
                .enhanceWith(SysParam::setId, dto::getId)
                .enhanceWith(SysParam::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysParam::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysParam::setParamName, dto::getParamName)
                .enhanceWith(SysParam::setParamCode, dto::getParamCode)
                .enhanceWith(SysParam::setParamValue, dto::getParamValue)
                .enhanceWith(SysParam::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysParam::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysParam::setGmtModify, dto::getGmtModify)
                .build();
    }
}
