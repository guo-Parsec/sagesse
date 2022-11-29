package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysRoleVo;
import org.edu.sagesse.base.core.domain.entity.SysRole;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统角色表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:52
 */
public class SysRoleConvert {
    /**
     * <p>{@link SysRole}转化为{@link SysRoleVo}</p>
     *
     * @param sysRole 被转换的原数据
     * @return 转换为{@link SysRoleVo}
     * @author guocq
     * @date 2022-11-29 15:31:52
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
}
