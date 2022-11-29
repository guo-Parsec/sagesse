package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysMenuVo;
import org.edu.sagesse.base.core.domain.dto.menu.SysMenuCreateDto;
import org.edu.sagesse.base.core.domain.dto.menu.SysMenuPageDto;
import org.edu.sagesse.base.core.domain.dto.menu.SysMenuPutDto;
import org.edu.sagesse.base.core.domain.dto.menu.SysMenuQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysMenu;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统菜单表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 18:04:01
 */
public class SysMenuConvert {
    /**
     * <p>{@link SysMenu}转化为{@link SysMenuVo}</p>
     *
     * @param sysMenu 被转换的原数据
     * @return 转换为{@link SysMenuVo}
     * @author guocq
     * @date 2022-11-29 18:04:01
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

    /**
     * <p>{@link SysMenuQueryDto}转化为{@link SysMenu}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysMenu}
     * @author guocq
     * @date 2022-11-29 18:04:01
     */
    public static SysMenu sysMenuQueryDtoToEntity(SysMenuQueryDto dto) {
        if (dto == null) {
            return SysMenu.EMPTY;
        }
        return Builder.builder(SysMenu::new)
                .enhanceWith(SysMenu::setId, dto::getId)
                .enhanceWith(SysMenu::setParentId, dto::getParentId)
                .enhanceWith(SysMenu::setHierarchicalPath, dto::getHierarchicalPath)
                .enhanceWith(SysMenu::setMenuCode, dto::getMenuCode)
                .enhanceWith(SysMenu::setMenuTitle, dto::getMenuTitle)
                .enhanceWith(SysMenu::setMenuIcon, dto::getMenuIcon)
                .enhanceWith(SysMenu::setVisibleStatus, dto::getVisibleStatus)
                .enhanceWith(SysMenu::setMenuLevel, dto::getMenuLevel)
                .enhanceWith(SysMenu::setSort, dto::getSort)
                .enhanceWith(SysMenu::setComponent, dto::getComponent)
                .enhanceWith(SysMenu::setMenuUrl, dto::getMenuUrl)
                .enhanceWith(SysMenu::setRemark, dto::getRemark)
                .enhanceWith(SysMenu::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysMenu::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysMenu::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysMenuPageDto}转化为{@link SysMenu}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysMenu}
     * @author guocq
     * @date 2022-11-29 18:04:01
     */
    public static SysMenu sysMenuPageDtoToEntity(SysMenuPageDto dto) {
        if (dto == null) {
            return SysMenu.EMPTY;
        }
        return Builder.builder(SysMenu::new)
                .enhanceWith(SysMenu::setParentId, dto::getParentId)
                .enhanceWith(SysMenu::setHierarchicalPath, dto::getHierarchicalPath)
                .enhanceWith(SysMenu::setMenuCode, dto::getMenuCode)
                .enhanceWith(SysMenu::setMenuTitle, dto::getMenuTitle)
                .enhanceWith(SysMenu::setMenuIcon, dto::getMenuIcon)
                .enhanceWith(SysMenu::setVisibleStatus, dto::getVisibleStatus)
                .enhanceWith(SysMenu::setMenuLevel, dto::getMenuLevel)
                .enhanceWith(SysMenu::setSort, dto::getSort)
                .enhanceWith(SysMenu::setComponent, dto::getComponent)
                .enhanceWith(SysMenu::setMenuUrl, dto::getMenuUrl)
                .enhanceWith(SysMenu::setRemark, dto::getRemark)
                .build();
    }

    /**
     * <p>{@link SysMenuCreateDto}转化为{@link SysMenu}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysMenu}
     * @author guocq
     * @date 2022-11-29 18:04:01
     */
    public static SysMenu sysMenuCreateDtoToEntity(SysMenuCreateDto dto) {
        if (dto == null) {
            return SysMenu.EMPTY;
        }
        return Builder.builder(SysMenu::new)
                .enhanceWith(SysMenu::setId, dto::getId)
                .enhanceWith(SysMenu::setParentId, dto::getParentId)
                .enhanceWith(SysMenu::setHierarchicalPath, dto::getHierarchicalPath)
                .enhanceWith(SysMenu::setMenuCode, dto::getMenuCode)
                .enhanceWith(SysMenu::setMenuTitle, dto::getMenuTitle)
                .enhanceWith(SysMenu::setMenuIcon, dto::getMenuIcon)
                .enhanceWith(SysMenu::setVisibleStatus, dto::getVisibleStatus)
                .enhanceWith(SysMenu::setMenuLevel, dto::getMenuLevel)
                .enhanceWith(SysMenu::setSort, dto::getSort)
                .enhanceWith(SysMenu::setComponent, dto::getComponent)
                .enhanceWith(SysMenu::setMenuUrl, dto::getMenuUrl)
                .enhanceWith(SysMenu::setRemark, dto::getRemark)
                .enhanceWith(SysMenu::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysMenu::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysMenu::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysMenuPutDto}转化为{@link SysMenu}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysMenu}
     * @author guocq
     * @date 2022-11-29 18:04:01
     */
    public static SysMenu sysMenuPutDtoToEntity(SysMenuPutDto dto) {
        if (dto == null) {
            return SysMenu.EMPTY;
        }
        return Builder.builder(SysMenu::new)
                .enhanceWith(SysMenu::setId, dto::getId)
                .enhanceWith(SysMenu::setParentId, dto::getParentId)
                .enhanceWith(SysMenu::setHierarchicalPath, dto::getHierarchicalPath)
                .enhanceWith(SysMenu::setMenuCode, dto::getMenuCode)
                .enhanceWith(SysMenu::setMenuTitle, dto::getMenuTitle)
                .enhanceWith(SysMenu::setMenuIcon, dto::getMenuIcon)
                .enhanceWith(SysMenu::setVisibleStatus, dto::getVisibleStatus)
                .enhanceWith(SysMenu::setMenuLevel, dto::getMenuLevel)
                .enhanceWith(SysMenu::setSort, dto::getSort)
                .enhanceWith(SysMenu::setComponent, dto::getComponent)
                .enhanceWith(SysMenu::setMenuUrl, dto::getMenuUrl)
                .enhanceWith(SysMenu::setRemark, dto::getRemark)
                .enhanceWith(SysMenu::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysMenu::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysMenu::setGmtModify, dto::getGmtModify)
                .build();
    }
}
