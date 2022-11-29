package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysRoleVo;
import org.edu.sagesse.base.core.domain.dto.role.SysRoleCreateDto;
import org.edu.sagesse.base.core.domain.dto.role.SysRolePageDto;
import org.edu.sagesse.base.core.domain.dto.role.SysRolePutDto;
import org.edu.sagesse.base.core.domain.dto.role.SysRoleQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysRole;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统角色表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 18:04:28
 */
public class SysRoleConvert {
    /**
     * <p>{@link SysRole}转化为{@link SysRoleVo}</p>
     *
     * @param sysRole 被转换的原数据
     * @return 转换为{@link SysRoleVo}
     * @author guocq
     * @date 2022-11-29 18:04:28
     */
    public static SysRoleVo entityToSysRoleVo(SysRole sysRole) {
        if (sysRole == null) {
            return SysRoleVo.EMPTY;
        }
        return Builder.builder(SysRoleVo::new)
                .enhanceWith(SysRoleVo::setId, sysRole::getId)
                .enhanceWith(SysRoleVo::setRoleCode, sysRole::getRoleCode)
                .enhanceWith(SysRoleVo::setRoleName, sysRole::getRoleName)
                .enhanceWith(SysRoleVo::setSort, sysRole::getSort)
                .enhanceWith(SysRoleVo::setRemark, sysRole::getRemark)
                .enhanceWith(SysRoleVo::setDataStatus, sysRole::getDataStatus)
                .enhanceWith(SysRoleVo::setGmtCreate, sysRole::getGmtCreate)
                .enhanceWith(SysRoleVo::setGmtModify, sysRole::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysRoleQueryDto}转化为{@link SysRole}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysRole}
     * @author guocq
     * @date 2022-11-29 18:04:28
     */
    public static SysRole sysRoleQueryDtoToEntity(SysRoleQueryDto dto) {
        if (dto == null) {
            return SysRole.EMPTY;
        }
        return Builder.builder(SysRole::new)
                .enhanceWith(SysRole::setId, dto::getId)
                .enhanceWith(SysRole::setRoleCode, dto::getRoleCode)
                .enhanceWith(SysRole::setRoleName, dto::getRoleName)
                .enhanceWith(SysRole::setSort, dto::getSort)
                .enhanceWith(SysRole::setRemark, dto::getRemark)
                .enhanceWith(SysRole::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysRole::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysRole::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysRolePageDto}转化为{@link SysRole}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysRole}
     * @author guocq
     * @date 2022-11-29 18:04:28
     */
    public static SysRole sysRolePageDtoToEntity(SysRolePageDto dto) {
        if (dto == null) {
            return SysRole.EMPTY;
        }
        return Builder.builder(SysRole::new)
                .enhanceWith(SysRole::setRoleCode, dto::getRoleCode)
                .enhanceWith(SysRole::setRoleName, dto::getRoleName)
                .enhanceWith(SysRole::setSort, dto::getSort)
                .enhanceWith(SysRole::setRemark, dto::getRemark)
                .build();
    }

    /**
     * <p>{@link SysRoleCreateDto}转化为{@link SysRole}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysRole}
     * @author guocq
     * @date 2022-11-29 18:04:28
     */
    public static SysRole sysRoleCreateDtoToEntity(SysRoleCreateDto dto) {
        if (dto == null) {
            return SysRole.EMPTY;
        }
        return Builder.builder(SysRole::new)
                .enhanceWith(SysRole::setId, dto::getId)
                .enhanceWith(SysRole::setRoleCode, dto::getRoleCode)
                .enhanceWith(SysRole::setRoleName, dto::getRoleName)
                .enhanceWith(SysRole::setSort, dto::getSort)
                .enhanceWith(SysRole::setRemark, dto::getRemark)
                .enhanceWith(SysRole::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysRole::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysRole::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysRolePutDto}转化为{@link SysRole}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysRole}
     * @author guocq
     * @date 2022-11-29 18:04:28
     */
    public static SysRole sysRolePutDtoToEntity(SysRolePutDto dto) {
        if (dto == null) {
            return SysRole.EMPTY;
        }
        return Builder.builder(SysRole::new)
                .enhanceWith(SysRole::setId, dto::getId)
                .enhanceWith(SysRole::setRoleCode, dto::getRoleCode)
                .enhanceWith(SysRole::setRoleName, dto::getRoleName)
                .enhanceWith(SysRole::setSort, dto::getSort)
                .enhanceWith(SysRole::setRemark, dto::getRemark)
                .enhanceWith(SysRole::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysRole::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysRole::setGmtModify, dto::getGmtModify)
                .build();
    }
}
