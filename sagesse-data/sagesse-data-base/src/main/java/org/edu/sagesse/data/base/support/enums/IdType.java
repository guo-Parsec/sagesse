package org.edu.sagesse.data.base.support.enums;

import lombok.Getter;
import org.edu.sagesse.common.support.enums.CoreEnum;

/**
 * <p>id类型</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public enum IdType implements CoreEnum<String, String> {
    ;

    @Getter
    private final String code;
    @Getter
    private final String value;

    IdType(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
