package org.edu.sagesse.data.base.support.enums;

import com.google.common.collect.Sets;
import io.swagger.models.auth.In;
import lombok.Getter;
import org.edu.sagesse.common.support.enums.CoreEnum;
import org.edu.sagesse.common.support.enums.StatusEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>数据状态枚举</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public enum DataStatus implements StatusEnum {

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
