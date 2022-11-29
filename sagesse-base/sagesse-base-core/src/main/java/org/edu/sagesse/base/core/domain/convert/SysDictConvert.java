package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.api.core.domain.vo.SysDictVo;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictCreateDto;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictPageDto;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictPutDto;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysDict;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统字典详情表实体转换</p>
 *
 * @author guocq
 * @since 2022-11-29 14:53:16
 */
public class SysDictConvert {
    /**
     * <p>{@link SysDict}转化为{@link SysDictVo}</p>
     *
     * @param sysDict 被转换的原数据
     * @return 转换为{@link SysDictVo}
     * @author guocq
     * @date 2022/11/29 14:53
     */
    public static SysDictVo entityToSysDictVo(SysDict sysDict) {
        if (sysDict == null) {
            return SysDictVo.EMPTY;
        }
        return Builder.builder(SysDictVo::new)
                .enhanceWith(SysDictVo::setId, sysDict::getId)
                .enhanceWith(SysDictVo::setCategoryCode, sysDict::getCategoryCode)
                .enhanceWith(SysDictVo::setCategoryName, sysDict::getCategoryName)
                .enhanceWith(SysDictVo::setDictName, sysDict::getDictName)
                .enhanceWith(SysDictVo::setDictValue, sysDict::getDictValue)
                .enhanceWith(SysDictVo::setSort, sysDict::getSort)
                .enhanceWith(SysDictVo::setDataStatus, sysDict::getDataStatus)
                .enhanceWith(SysDictVo::setGmtCreate, sysDict::getGmtCreate)
                .enhanceWith(SysDictVo::setGmtModify, sysDict::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysDict}转化为{@link Dict}</p>
     *
     * @param sysDict 被转换的原数据
     * @return 转换为{@link Dict}
     * @author guocq
     * @date 2022/11/29 15:00
     */
    public static Dict entityToDict(SysDict sysDict) {
        if (sysDict == null) {
            return Dict.EMPTY;
        }
        return Builder.builder(Dict::new)
                .enhanceWith(Dict::setCategoryCode, sysDict::getCategoryCode)
                .enhanceWith(Dict::setCategoryName, sysDict::getCategoryName)
                .enhanceWith(Dict::setDictName, sysDict::getDictName)
                .enhanceWith(Dict::setDictValue, sysDict::getDictValue)
                .build();
    }

    /**
     * <p>{@link SysDictQueryDto}转化为{@link SysDict}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysDict}
     * @author guocq
     * @date 2022/11/29 16:38
     */
    public static SysDict sysDictQueryDtoToEntity(SysDictQueryDto dto) {
        if (dto == null) {
            return SysDict.EMPTY;
        }
        return Builder.builder(SysDict::new)
                .enhanceWith(SysDict::setId, dto::getId)
                .enhanceWith(SysDict::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysDict::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysDict::setDictName, dto::getDictName)
                .enhanceWith(SysDict::setDictValue, dto::getDictValue)
                .enhanceWith(SysDict::setSort, dto::getSort)
                .enhanceWith(SysDict::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysDict::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysDict::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysDictPageDto}转化为{@link SysDict}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysDict}
     * @author guocq
     * @date 2022/11/29 16:38
     */
    public static SysDict sysDictPageDtoToEntity(SysDictPageDto dto) {
        if (dto == null) {
            return SysDict.EMPTY;
        }
        return Builder.builder(SysDict::new)
                .enhanceWith(SysDict::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysDict::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysDict::setDictName, dto::getDictName)
                .enhanceWith(SysDict::setDictValue, dto::getDictValue)
                .enhanceWith(SysDict::setSort, dto::getSort)
                .build();
    }

    /**
     * <p>{@link SysDictCreateDto}转化为{@link SysDict}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysDict}
     * @author guocq
     * @date 2022/11/29 16:38
     */
    public static SysDict sysDictCreateDtoToEntity(SysDictCreateDto dto) {
        if (dto == null) {
            return SysDict.EMPTY;
        }
        return Builder.builder(SysDict::new)
                .enhanceWith(SysDict::setId, dto::getId)
                .enhanceWith(SysDict::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysDict::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysDict::setDictName, dto::getDictName)
                .enhanceWith(SysDict::setDictValue, dto::getDictValue)
                .enhanceWith(SysDict::setSort, dto::getSort)
                .enhanceWith(SysDict::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysDict::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysDict::setGmtModify, dto::getGmtModify)
                .build();
    }

    /**
     * <p>{@link SysDictPutDto}转化为{@link SysDict}</p>
     *
     * @param dto 被转换的原数据
     * @return 转换为{@link SysDict}
     * @author guocq
     * @date 2022/11/29 16:38
     */
    public static SysDict sysDictPutDtoToEntity(SysDictPutDto dto) {
        if (dto == null) {
            return SysDict.EMPTY;
        }
        return Builder.builder(SysDict::new)
                .enhanceWith(SysDict::setId, dto::getId)
                .enhanceWith(SysDict::setCategoryCode, dto::getCategoryCode)
                .enhanceWith(SysDict::setCategoryName, dto::getCategoryName)
                .enhanceWith(SysDict::setDictName, dto::getDictName)
                .enhanceWith(SysDict::setDictValue, dto::getDictValue)
                .enhanceWith(SysDict::setSort, dto::getSort)
                .enhanceWith(SysDict::setDataStatus, dto::getDataStatus)
                .enhanceWith(SysDict::setGmtCreate, dto::getGmtCreate)
                .enhanceWith(SysDict::setGmtModify, dto::getGmtModify)
                .build();
    }
}
