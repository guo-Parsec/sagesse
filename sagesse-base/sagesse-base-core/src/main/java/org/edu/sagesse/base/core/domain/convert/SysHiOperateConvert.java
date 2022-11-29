package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysHiOperateVo;
import org.edu.sagesse.base.core.domain.entity.SysHiOperate;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>操作历史记录表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:27
 */
public class SysHiOperateConvert {
    /**
     * <p>{@link SysHiOperate}转化为{@link SysHiOperateVo}</p>
     *
     * @param sysHiOperate 被转换的原数据
     * @return 转换为{@link SysHiOperateVo}
     * @author guocq
     * @date 2022-11-29 15:31:27
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
}
