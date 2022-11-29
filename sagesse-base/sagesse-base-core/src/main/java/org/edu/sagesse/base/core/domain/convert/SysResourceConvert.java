package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.SysResourceVo;
import org.edu.sagesse.base.core.domain.dto.resource.SysResourceCreateDto;
import org.edu.sagesse.base.core.domain.dto.resource.SysResourcePageDto;
import org.edu.sagesse.base.core.domain.dto.resource.SysResourcePutDto;
import org.edu.sagesse.base.core.domain.dto.resource.SysResourceQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysResource;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统资源表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 18:04:16
 */
public class SysResourceConvert {
    /**
     * <p>{@link SysResource}转化为{@link SysResourceVo}</p>
     *
     * @param sysResource 被转换的原数据
     * @return 转换为{@link SysResourceVo}
     * @author guocq
     * @date 2022-11-29 18:04:16
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

    /**
     * <p>{@link SysResourceQueryDto}转化为{@link SysResource}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysResource}
     * @author guocq
     * @date 2022-11-29 18:04:16
     */
    public static SysResource sysResourceQueryDtoToEntity(SysResourceQueryDto dto) {
        if (dto == null) {
            return SysResource.EMPTY;
        }
        return Builder.builder(SysResource::new)
                .enhanceWith(SysResource::setId, dto::getId)
                .enhanceWith(SysResource::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysResource::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysResource::setResourceCode, dto::getResourceCode)
                .enhanceWith(SysResource::setResourceName, dto::getResourceName)
                .enhanceWith(SysResource::setRequestActionUrl, dto::getRequestActionUrl)
                .enhanceWith(SysResource::setSort, dto::getSort)
                .enhanceWith(SysResource::setRemark, dto::getRemark)
                .enhanceWith(SysResource::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysResource::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysResource::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysResourcePageDto}转化为{@link SysResource}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysResource}
     * @author guocq
     * @date 2022-11-29 18:04:16
     */
    public static SysResource sysResourcePageDtoToEntity(SysResourcePageDto dto) {
        if (dto == null) {
            return SysResource.EMPTY;
        }
        return Builder.builder(SysResource::new)
                .enhanceWith(SysResource::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysResource::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysResource::setResourceCode, dto::getResourceCode)
                .enhanceWith(SysResource::setResourceName, dto::getResourceName)
                .enhanceWith(SysResource::setRequestActionUrl, dto::getRequestActionUrl)
                .enhanceWith(SysResource::setSort, dto::getSort)
                .enhanceWith(SysResource::setRemark, dto::getRemark)
                .build();
    }

    /**
     * <p>{@link SysResourceCreateDto}转化为{@link SysResource}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysResource}
     * @author guocq
     * @date 2022-11-29 18:04:16
     */
    public static SysResource sysResourceCreateDtoToEntity(SysResourceCreateDto dto) {
        if (dto == null) {
            return SysResource.EMPTY;
        }
        return Builder.builder(SysResource::new)
                .enhanceWith(SysResource::setId, dto::getId)
                .enhanceWith(SysResource::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysResource::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysResource::setResourceCode, dto::getResourceCode)
                .enhanceWith(SysResource::setResourceName, dto::getResourceName)
                .enhanceWith(SysResource::setRequestActionUrl, dto::getRequestActionUrl)
                .enhanceWith(SysResource::setSort, dto::getSort)
                .enhanceWith(SysResource::setRemark, dto::getRemark)
                .enhanceWith(SysResource::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysResource::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysResource::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysResourcePutDto}转化为{@link SysResource}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysResource}
     * @author guocq
     * @date 2022-11-29 18:04:16
     */
    public static SysResource sysResourcePutDtoToEntity(SysResourcePutDto dto) {
        if (dto == null) {
            return SysResource.EMPTY;
        }
        return Builder.builder(SysResource::new)
                .enhanceWith(SysResource::setId, dto::getId)
                .enhanceWith(SysResource::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysResource::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysResource::setResourceCode, dto::getResourceCode)
                .enhanceWith(SysResource::setResourceName, dto::getResourceName)
                .enhanceWith(SysResource::setRequestActionUrl, dto::getRequestActionUrl)
                .enhanceWith(SysResource::setSort, dto::getSort)
                .enhanceWith(SysResource::setRemark, dto::getRemark)
                .enhanceWith(SysResource::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysResource::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysResource::setGmtModify, dto::getGmtModify)
                .build();
    }
}
