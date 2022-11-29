package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysHiLoginVo;
import org.edu.sagesse.base.core.domain.dto.login.SysHiLoginCreateDto;
import org.edu.sagesse.base.core.domain.dto.login.SysHiLoginPageDto;
import org.edu.sagesse.base.core.domain.dto.login.SysHiLoginQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysHiLogin;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>登录历史记录表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 17:58:16
 */
public class SysHiLoginConvert {
    /**
     * <p>{@link SysHiLogin}转化为{@link SysHiLoginVo}</p>
     *
     * @param sysHiLogin 被转换的原数据
     * @return 转换为{@link SysHiLoginVo}
     * @author guocq
     * @date 2022-11-29 17:58:16
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

    /**
     * <p>{@link SysHiLoginQueryDto}转化为{@link SysHiLogin}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysHiLogin}
     * @author guocq
     * @date 2022-11-29 17:58:16
     */
    public static SysHiLogin sysHiLoginQueryDtoToEntity(SysHiLoginQueryDto dto) {
        if (dto == null) {
            return SysHiLogin.EMPTY;
        }
        return Builder.builder(SysHiLogin::new)
                .enhanceWith(SysHiLogin::setId, dto::getId)
                .enhanceWith(SysHiLogin::setLoginIp, dto::getLoginIp)
                .enhanceWith(SysHiLogin::setLoginAccount, dto::getLoginAccount)
                .enhanceWith(SysHiLogin::setLoginEquipment, dto::getLoginEquipment)
                .enhanceWith(SysHiLogin::setTimeConsuming, dto::getTimeConsuming)
                .enhanceWith(SysHiLogin::setErrorCode, dto::getErrorCode)
                .enhanceWith(SysHiLogin::setErrorMessage, dto::getErrorMessage)
                .enhanceWith(SysHiLogin::setLoginResult, dto::getLoginResult)
                .enhanceWith(SysHiLogin::setGmtCreate, dto::getGmtCreate)
                .build();
    }

    /**
     * <p>{@link SysHiLoginPageDto}转化为{@link SysHiLogin}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysHiLogin}
     * @author guocq
     * @date 2022-11-29 17:58:16
     */
    public static SysHiLogin sysHiLoginPageDtoToEntity(SysHiLoginPageDto dto) {
        if (dto == null) {
            return SysHiLogin.EMPTY;
        }
        return Builder.builder(SysHiLogin::new)
                .enhanceWith(SysHiLogin::setLoginIp, dto::getLoginIp)
                .enhanceWith(SysHiLogin::setLoginAccount, dto::getLoginAccount)
                .enhanceWith(SysHiLogin::setLoginEquipment, dto::getLoginEquipment)
                .enhanceWith(SysHiLogin::setTimeConsuming, dto::getTimeConsuming)
                .enhanceWith(SysHiLogin::setErrorCode, dto::getErrorCode)
                .enhanceWith(SysHiLogin::setErrorMessage, dto::getErrorMessage)
                .enhanceWith(SysHiLogin::setLoginResult, dto::getLoginResult)
                .enhanceWith(SysHiLogin::setGmtCreate, dto::getGmtCreate)
                .build();
    }

    /**
     * <p>{@link SysHiLoginCreateDto}转化为{@link SysHiLogin}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysHiLogin}
     * @author guocq
     * @date 2022-11-29 17:58:16
     */
    public static SysHiLogin sysHiLoginCreateDtoToEntity(SysHiLoginCreateDto dto) {
        if (dto == null) {
            return SysHiLogin.EMPTY;
        }
        return Builder.builder(SysHiLogin::new)
                .enhanceWith(SysHiLogin::setId, dto::getId)
                .enhanceWith(SysHiLogin::setLoginIp, dto::getLoginIp)
                .enhanceWith(SysHiLogin::setLoginAccount, dto::getLoginAccount)
                .enhanceWith(SysHiLogin::setLoginEquipment, dto::getLoginEquipment)
                .enhanceWith(SysHiLogin::setTimeConsuming, dto::getTimeConsuming)
                .enhanceWith(SysHiLogin::setErrorCode, dto::getErrorCode)
                .enhanceWith(SysHiLogin::setErrorMessage, dto::getErrorMessage)
                .enhanceWith(SysHiLogin::setLoginResult, dto::getLoginResult)
                .enhanceWith(SysHiLogin::setGmtCreate, dto::getGmtCreate)
                .build();
    }
}
