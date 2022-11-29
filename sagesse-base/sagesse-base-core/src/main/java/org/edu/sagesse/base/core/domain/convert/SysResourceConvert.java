package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysResourceVo;
import org.edu.sagesse.base.core.domain.entity.SysResource;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统资源表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 15:31:47
 */
public class SysResourceConvert {
    /**
     * <p>{@link SysResource}转化为{@link SysResourceVo}</p>
     *
     * @param sysResource 被转换的原数据
     * @return 转换为{@link SysResourceVo}
     * @author guocq
     * @date 2022-11-29 15:31:47
     */
    public static SysResourceVo entityToSysResourceVo(SysResource sysResource) {
        if (sysResource == null) {
            return SysResourceVo.EMPTY;
        }
        return Builder.builder(SysResourceVo::new)
                .enhanceWith(SysResourceVo::setId, sysResource::getId)
                .enhanceWith(SysResourceVo::setCategoryCode, sysResource::getCategoryCode)
                .enhanceWith(SysResourceVo::setCategoryName, sysResource::getCategoryName)
                .enhanceWith(SysResourceVo::setResourceCode, sysResource::getResourceCode)
                .enhanceWith(SysResourceVo::setResourceName, sysResource::getResourceName)
                .enhanceWith(SysResourceVo::setRequestActionUrl, sysResource::getRequestActionUrl)
                .enhanceWith(SysResourceVo::setSort, sysResource::getSort)
                .enhanceWith(SysResourceVo::setRemark, sysResource::getRemark)
                .enhanceWith(SysResourceVo::setDataStatus, sysResource::getDataStatus)
                .enhanceWith(SysResourceVo::setGmtCreate, sysResource::getGmtCreate)
                .enhanceWith(SysResourceVo::setGmtModify, sysResource::getGmtModify)
                .build();
    }
}
