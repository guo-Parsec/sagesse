package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysHiLoginVo;
import org.edu.sagesse.base.core.domain.entity.SysHiLogin;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>登录历史记录表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:05
 */
public class SysHiLoginConvert {
    /**
     * <p>{@link SysHiLogin}转化为{@link SysHiLoginVo}</p>
     *
     * @param sysHiLogin 被转换的原数据
     * @return 转换为{@link SysHiLoginVo}
     * @author guocq
     * @date 2022-11-29 15:31:05
     */
    public static SysHiLoginVo entityToSysHiLoginVo(SysHiLogin sysHiLogin) {
        if (sysHiLogin == null) {
            return SysHiLoginVo.EMPTY;
        }
        return Builder.builder(SysHiLoginVo::new)
                .enhanceWith(SysHiLoginVo::setId, sysHiLogin::getId)
                .enhanceWith(SysHiLoginVo::setLoginIp, sysHiLogin::getLoginIp)
                .enhanceWith(SysHiLoginVo::setLoginAccount, sysHiLogin::getLoginAccount)
                .enhanceWith(SysHiLoginVo::setLoginEquipment, sysHiLogin::getLoginEquipment)
                .enhanceWith(SysHiLoginVo::setTimeConsuming, sysHiLogin::getTimeConsuming)
                .enhanceWith(SysHiLoginVo::setErrorCode, sysHiLogin::getErrorCode)
                .enhanceWith(SysHiLoginVo::setErrorMessage, sysHiLogin::getErrorMessage)
                .enhanceWith(SysHiLoginVo::setLoginResult, sysHiLogin::getLoginResult)
                .enhanceWith(SysHiLoginVo::setGmtCreate, sysHiLogin::getGmtCreate)
                .build();
    }
}
