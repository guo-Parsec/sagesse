package org.edu.sagesse.base.core.domain.convert;

import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.core.domain.dto.SysDictCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPutDto;
import org.edu.sagesse.base.core.domain.entity.SysDict;
import org.edu.sagesse.base.core.domain.vo.SysDictVo;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>系统字典详情表实体转换</p>
 *
 * @author guocq
 * @since 2022-12-01 10:30:29
 */
public class SysDictConvert {
    /**
     * <p>{@link SysDict}转化为{@link SysDictVo}</p>
     *
     * @param sysDict 被转换的原数据
     * @return 转换为{@link SysDictVo}
     * @author guocq
     * @date 2022-12-01 10:30:29
     */
    public static SysDictVo convertSysDictToSysDictVo(SysDict sysDict) {
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
     * <p>{@link SysDictCreateDto}转化为{@link SysDict}</p>
     *
     * @param sysDictCreateDto 被转换的原数据
     * @return 转换为{@link SysDict}
     * @author guocq
     * @date 2022-12-01 10:30:29
     */
    public static SysDict convertSysDictCreateDtoToSysDict(SysDictCreateDto sysDictCreateDto) {
        if (sysDictCreateDto == null) {
            return SysDict.EMPTY;
        }
        return Builder.builder(SysDict::new)
                .enhanceWith(SysDict::setCategoryCode, sysDictCreateDto::getCategoryCode)
                .enhanceWith(SysDict::setCategoryName, sysDictCreateDto::getCategoryName)
                .enhanceWith(SysDict::setDictName, sysDictCreateDto::getDictName)
                .enhanceWith(SysDict::setDictValue, sysDictCreateDto::getDictValue)
                .enhanceWith(SysDict::setSort, sysDictCreateDto::getSort)
                .build();
    }

    /**
     * <p>{@link SysDictPutDto}转化为{@link SysDict}</p>
     *
     * @param sysDictPutDto 被转换的原数据
     * @return 转换为{@link SysDict}
     * @author guocq
     * @date 2022-12-01 10:30:29
     */
    public static SysDict convertSysDictPutDtoToSysDict(SysDictPutDto sysDictPutDto) {
        if (sysDictPutDto == null) {
            return SysDict.EMPTY;
        }
        return Builder.builder(SysDict::new)
                .enhanceWith(SysDict::setId, sysDictPutDto::getId)
                .enhanceWith(SysDict::setCategoryCode, sysDictPutDto::getCategoryCode)
                .enhanceWith(SysDict::setCategoryName, sysDictPutDto::getCategoryName)
                .enhanceWith(SysDict::setDictName, sysDictPutDto::getDictName)
                .enhanceWith(SysDict::setDictValue, sysDictPutDto::getDictValue)
                .enhanceWith(SysDict::setSort, sysDictPutDto::getSort)
                .enhanceWith(SysDict::setDataStatus, sysDictPutDto::getDataStatus)
                .build();
    }

    /**
     * <p>{@link SysDict}转化为{@link Dict}</p>
     *
     * @param sysDict 被转换的原数据
     * @return 转换为{@link SysDictVo}
     * @author guocq
     * @date 2022-12-01 10:30:29
     */
    public static Dict convertSysDictToDict(SysDict sysDict) {
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
}
