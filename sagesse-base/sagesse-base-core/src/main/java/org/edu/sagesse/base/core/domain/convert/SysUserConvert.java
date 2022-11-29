package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysUserVo;
import org.edu.sagesse.base.core.domain.entity.SysUser;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统用户表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:58
 */
public class SysUserConvert {
    /**
     * <p>{@link SysUser}转化为{@link SysUserVo}</p>
     *
     * @param sysUser 被转换的原数据
     * @return 转换为{@link SysUserVo}
     * @author guocq
     * @date 2022-11-29 15:31:58
     */
    public static SysUserVo entityToSysUserVo(SysUser sysUser) {
        if (sysUser == null) {
            return SysUserVo.EMPTY;
        }
        return Builder.builder(SysUserVo::new)
                .enhanceWith(SysUserVo::setId, sysUser::getId)
                .enhanceWith(SysUserVo::setAccount, sysUser::getAccount)
                .enhanceWith(SysUserVo::setPassword, sysUser::getPassword)
                .enhanceWith(SysUserVo::setNickname, sysUser::getNickname)
                .enhanceWith(SysUserVo::setSex, sysUser::getSex)
                .enhanceWith(SysUserVo::setAvatarUrl, sysUser::getAvatarUrl)
                .enhanceWith(SysUserVo::setBirthday, sysUser::getBirthday)
                .enhanceWith(SysUserVo::setUserType, sysUser::getUserType)
                .enhanceWith(SysUserVo::setDataStatus, sysUser::getDataStatus)
                .enhanceWith(SysUserVo::setGmtCreate, sysUser::getGmtCreate)
                .enhanceWith(SysUserVo::setGmtModify, sysUser::getGmtModify)
                .build();
    }
}
