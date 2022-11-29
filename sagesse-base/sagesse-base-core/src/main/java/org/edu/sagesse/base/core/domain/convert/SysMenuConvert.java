package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysMenuVo;
import org.edu.sagesse.base.core.domain.entity.SysMenu;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统菜单表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:33
 */
public class SysMenuConvert {
    /**
     * <p>{@link SysMenu}转化为{@link SysMenuVo}</p>
     *
     * @param sysMenu 被转换的原数据
     * @return 转换为{@link SysMenuVo}
     * @author guocq
     * @date 2022-11-29 15:31:33
     */
    public static SysMenuVo entityToSysMenuVo(SysMenu sysMenu) {
        if (sysMenu == null) {
            return SysMenuVo.EMPTY;
        }
        return Builder.builder(SysMenuVo::new)
                .enhanceWith(SysMenuVo::setId, sysMenu::getId)
                .enhanceWith(SysMenuVo::setParentId, sysMenu::getParentId)
                .enhanceWith(SysMenuVo::setHierarchicalPath, sysMenu::getHierarchicalPath)
                .enhanceWith(SysMenuVo::setMenuCode, sysMenu::getMenuCode)
                .enhanceWith(SysMenuVo::setMenuTitle, sysMenu::getMenuTitle)
                .enhanceWith(SysMenuVo::setMenuIcon, sysMenu::getMenuIcon)
                .enhanceWith(SysMenuVo::setVisibleStatus, sysMenu::getVisibleStatus)
                .enhanceWith(SysMenuVo::setMenuLevel, sysMenu::getMenuLevel)
                .enhanceWith(SysMenuVo::setSort, sysMenu::getSort)
                .enhanceWith(SysMenuVo::setComponent, sysMenu::getComponent)
                .enhanceWith(SysMenuVo::setMenuUrl, sysMenu::getMenuUrl)
                .enhanceWith(SysMenuVo::setRemark, sysMenu::getRemark)
                .enhanceWith(SysMenuVo::setDataStatus, sysMenu::getDataStatus)
                .enhanceWith(SysMenuVo::setGmtCreate, sysMenu::getGmtCreate)
                .enhanceWith(SysMenuVo::setGmtModify, sysMenu::getGmtModify)
                .build();
    }
}
