package org.edu.sagesse.data.base.support.enums;

import lombok.Getter;
import org.edu.sagesse.common.support.enums.CoreEnum;

/**
 * <p></p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public enum DataStatus implements CoreEnum<String, Integer> {

    /**
     * 启用状态
     */
    ENABLE("启用状态", 0),
    /**
     * 禁用状态
     */
    DISABLE("禁用状态", 1),
    /**
     * 删除状态
     */
    DELETE("删除状态", 2),

    ;

    @Getter
    private final String code;
    @Getter
    private final Integer value;

    DataStatus(final String code, final Integer value) {
        this.code = code;
        this.value = value;
    }
}
