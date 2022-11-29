package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysHiOperateVo;
import org.edu.sagesse.base.core.domain.dto.operate.SysHiOperateCreateDto;
import org.edu.sagesse.base.core.domain.dto.operate.SysHiOperatePageDto;
import org.edu.sagesse.base.core.domain.dto.operate.SysHiOperateQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysHiOperate;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>操作历史记录表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 18:03:53
 */
public class SysHiOperateConvert {
    /**
     * <p>{@link SysHiOperate}转化为{@link SysHiOperateVo}</p>
     *
     * @param sysHiOperate 被转换的原数据
     * @return 转换为{@link SysHiOperateVo}
     * @author guocq
     * @date 2022-11-29 18:03:53
     */
    public static SysHiOperateVo entityToSysHiOperateVo(SysHiOperate sysHiOperate) {
        if (sysHiOperate == null) {
            return SysHiOperateVo.EMPTY;
        }
        return Builder.builder(SysHiOperateVo::new)
                .enhanceWith(SysHiOperateVo::setId, sysHiOperate::getId)
                .enhanceWith(SysHiOperateVo::setAccessUrl, sysHiOperate::getAccessUrl)
                .enhanceWith(SysHiOperateVo::setAccessServer, sysHiOperate::getAccessServer)
                .enhanceWith(SysHiOperateVo::setOperateUserId, sysHiOperate::getOperateUserId)
                .enhanceWith(SysHiOperateVo::setOperateUserAccount, sysHiOperate::getOperateUserAccount)
                .enhanceWith(SysHiOperateVo::setTimeConsuming, sysHiOperate::getTimeConsuming)
                .enhanceWith(SysHiOperateVo::setAccessType, sysHiOperate::getAccessType)
                .enhanceWith(SysHiOperateVo::setRequestParam, sysHiOperate::getRequestParam)
                .enhanceWith(SysHiOperateVo::setRequestResult, sysHiOperate::getRequestResult)
                .enhanceWith(SysHiOperateVo::setErrorCode, sysHiOperate::getErrorCode)
                .enhanceWith(SysHiOperateVo::setErrorMessage, sysHiOperate::getErrorMessage)
                .enhanceWith(SysHiOperateVo::setAccessResult, sysHiOperate::getAccessResult)
                .enhanceWith(SysHiOperateVo::setRemark, sysHiOperate::getRemark)
                .enhanceWith(SysHiOperateVo::setGmtCreate, sysHiOperate::getGmtCreate)
                .build();
    }

    /**
     * <p>{@link SysHiOperateQueryDto}转化为{@link SysHiOperate}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysHiOperate}
     * @author guocq
     * @date 2022-11-29 18:03:53
     */
    public static SysHiOperate sysHiOperateQueryDtoToEntity(SysHiOperateQueryDto dto) {
        if (dto == null) {
            return SysHiOperate.EMPTY;
        }
        return Builder.builder(SysHiOperate::new)
                .enhanceWith(SysHiOperate::setId, dto::getId)
                .enhanceWith(SysHiOperate::setAccessUrl, dto::getAccessUrl)
                .enhanceWith(SysHiOperate::setAccessServer, dto::getAccessServer)
                .enhanceWith(SysHiOperate::setOperateUserId, dto::getOperateUserId)
                .enhanceWith(SysHiOperate::setOperateUserAccount, dto::getOperateUserAccount)
                .enhanceWith(SysHiOperate::setTimeConsuming, dto::getTimeConsuming)
                .enhanceWith(SysHiOperate::setAccessType, dto::getAccessType)
                .enhanceWith(SysHiOperate::setRequestParam, dto::getRequestParam)
                .enhanceWith(SysHiOperate::setRequestResult, dto::getRequestResult)
                .enhanceWith(SysHiOperate::setErrorCode, dto::getErrorCode)
                .enhanceWith(SysHiOperate::setErrorMessage, dto::getErrorMessage)
                .enhanceWith(SysHiOperate::setAccessResult, dto::getAccessResult)
                .enhanceWith(SysHiOperate::setRemark, dto::getRemark)
                .enhanceWith(SysHiOperate::setGmtCreate, dto::getGmtCreate)
                .build();
    }

    /**
     * <p>{@link SysHiOperatePageDto}转化为{@link SysHiOperate}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysHiOperate}
     * @author guocq
     * @date 2022-11-29 18:03:53
     */
    public static SysHiOperate sysHiOperatePageDtoToEntity(SysHiOperatePageDto dto) {
        if (dto == null) {
            return SysHiOperate.EMPTY;
        }
        return Builder.builder(SysHiOperate::new)
                .enhanceWith(SysHiOperate::setAccessUrl, dto::getAccessUrl)
                .enhanceWith(SysHiOperate::setAccessServer, dto::getAccessServer)
                .enhanceWith(SysHiOperate::setOperateUserId, dto::getOperateUserId)
                .enhanceWith(SysHiOperate::setOperateUserAccount, dto::getOperateUserAccount)
                .enhanceWith(SysHiOperate::setTimeConsuming, dto::getTimeConsuming)
                .enhanceWith(SysHiOperate::setAccessType, dto::getAccessType)
                .enhanceWith(SysHiOperate::setRequestParam, dto::getRequestParam)
                .enhanceWith(SysHiOperate::setRequestResult, dto::getRequestResult)
                .enhanceWith(SysHiOperate::setErrorCode, dto::getErrorCode)
                .enhanceWith(SysHiOperate::setErrorMessage, dto::getErrorMessage)
                .enhanceWith(SysHiOperate::setAccessResult, dto::getAccessResult)
                .enhanceWith(SysHiOperate::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysHiOperate::setRemark, dto::getRemark)
                .build();
    }

    /**
     * <p>{@link SysHiOperateCreateDto}转化为{@link SysHiOperate}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysHiOperate}
     * @author guocq
     * @date 2022-11-29 18:03:53
     */
    public static SysHiOperate sysHiOperateCreateDtoToEntity(SysHiOperateCreateDto dto) {
        if (dto == null) {
            return SysHiOperate.EMPTY;
        }
        return Builder.builder(SysHiOperate::new)
                .enhanceWith(SysHiOperate::setId, dto::getId)
                .enhanceWith(SysHiOperate::setAccessUrl, dto::getAccessUrl)
                .enhanceWith(SysHiOperate::setAccessServer, dto::getAccessServer)
                .enhanceWith(SysHiOperate::setOperateUserId, dto::getOperateUserId)
                .enhanceWith(SysHiOperate::setOperateUserAccount, dto::getOperateUserAccount)
                .enhanceWith(SysHiOperate::setTimeConsuming, dto::getTimeConsuming)
                .enhanceWith(SysHiOperate::setAccessType, dto::getAccessType)
                .enhanceWith(SysHiOperate::setRequestParam, dto::getRequestParam)
                .enhanceWith(SysHiOperate::setRequestResult, dto::getRequestResult)
                .enhanceWith(SysHiOperate::setErrorCode, dto::getErrorCode)
                .enhanceWith(SysHiOperate::setErrorMessage, dto::getErrorMessage)
                .enhanceWith(SysHiOperate::setAccessResult, dto::getAccessResult)
                .enhanceWith(SysHiOperate::setRemark, dto::getRemark)
                .enhanceWith(SysHiOperate::setGmtCreate, dto::getGmtCreate)
                .build();
    }
}
