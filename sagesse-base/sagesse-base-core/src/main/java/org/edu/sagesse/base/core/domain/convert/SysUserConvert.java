package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysUserVo;
import org.edu.sagesse.base.core.domain.dto.user.SysUserCreateDto;
import org.edu.sagesse.base.core.domain.dto.user.SysUserPageDto;
import org.edu.sagesse.base.core.domain.dto.user.SysUserPutDto;
import org.edu.sagesse.base.core.domain.dto.user.SysUserQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysUser;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统用户表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 18:04:29
 */
public class SysUserConvert {
    /**
     * <p>{@link SysUser}转化为{@link SysUserVo}</p>
     *
     * @param sysUser 被转换的原数据
     * @return 转换为{@link SysUserVo}
     * @author guocq
     * @date 2022-11-29 18:04:29
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

    /**
     * <p>{@link SysUserQueryDto}转化为{@link SysUser}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysUser}
     * @author guocq
     * @date 2022-11-29 18:04:29
     */
    public static SysUser sysUserQueryDtoToEntity(SysUserQueryDto dto) {
        if (dto == null) {
            return SysUser.EMPTY;
        }
        return Builder.builder(SysUser::new)
                .enhanceWith(SysUser::setId, dto::getId)
                .enhanceWith(SysUser::setAccount, dto::getAccount)
                .enhanceWith(SysUser::setPassword, dto::getPassword)
                .enhanceWith(SysUser::setNickname, dto::getNickname)
                .enhanceWith(SysUser::setSex, dto::getSex)
                .enhanceWith(SysUser::setAvatarUrl, dto::getAvatarUrl)
                .enhanceWith(SysUser::setBirthday, dto::getBirthday)
                .enhanceWith(SysUser::setUserType, dto::getUserType)
                .enhanceWith(SysUser::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysUser::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysUser::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysUserPageDto}转化为{@link SysUser}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysUser}
     * @author guocq
     * @date 2022-11-29 18:04:29
     */
    public static SysUser sysUserPageDtoToEntity(SysUserPageDto dto) {
        if (dto == null) {
            return SysUser.EMPTY;
        }
        return Builder.builder(SysUser::new)
                .enhanceWith(SysUser::setAccount, dto::getAccount)
                .enhanceWith(SysUser::setPassword, dto::getPassword)
                .enhanceWith(SysUser::setNickname, dto::getNickname)
                .enhanceWith(SysUser::setSex, dto::getSex)
                .enhanceWith(SysUser::setAvatarUrl, dto::getAvatarUrl)
                .enhanceWith(SysUser::setBirthday, dto::getBirthday)
                .enhanceWith(SysUser::setUserType, dto::getUserType)
                .build();
    }

    /**
     * <p>{@link SysUserCreateDto}转化为{@link SysUser}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysUser}
     * @author guocq
     * @date 2022-11-29 18:04:29
     */
    public static SysUser sysUserCreateDtoToEntity(SysUserCreateDto dto) {
        if (dto == null) {
            return SysUser.EMPTY;
        }
        return Builder.builder(SysUser::new)
                .enhanceWith(SysUser::setId, dto::getId)
                .enhanceWith(SysUser::setAccount, dto::getAccount)
                .enhanceWith(SysUser::setPassword, dto::getPassword)
                .enhanceWith(SysUser::setNickname, dto::getNickname)
                .enhanceWith(SysUser::setSex, dto::getSex)
                .enhanceWith(SysUser::setAvatarUrl, dto::getAvatarUrl)
                .enhanceWith(SysUser::setBirthday, dto::getBirthday)
                .enhanceWith(SysUser::setUserType, dto::getUserType)
                .enhanceWith(SysUser::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysUser::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysUser::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysUserPutDto}转化为{@link SysUser}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysUser}
     * @author guocq
     * @date 2022-11-29 18:04:29
     */
    public static SysUser sysUserPutDtoToEntity(SysUserPutDto dto) {
        if (dto == null) {
            return SysUser.EMPTY;
        }
        return Builder.builder(SysUser::new)
                .enhanceWith(SysUser::setId, dto::getId)
                .enhanceWith(SysUser::setAccount, dto::getAccount)
                .enhanceWith(SysUser::setPassword, dto::getPassword)
                .enhanceWith(SysUser::setNickname, dto::getNickname)
                .enhanceWith(SysUser::setSex, dto::getSex)
                .enhanceWith(SysUser::setAvatarUrl, dto::getAvatarUrl)
                .enhanceWith(SysUser::setBirthday, dto::getBirthday)
                .enhanceWith(SysUser::setUserType, dto::getUserType)
                .enhanceWith(SysUser::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysUser::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysUser::setGmtModify, dto::getGmtModify)
                .build();
    }
}
