package org.edu.sagesse.common.support.rest;

import lombok.Getter;

/**
 * <p>通用数据码枚举</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public enum CoreRestEnum implements RestEnum {
    /**
     * 信息码
     */
    SUCCESS(200, "操作成功"),
    /**
     * 空
     */
    EMPTY(205, "未知空操作"),
    /**
     * 操作失败
     */
    ERROR(500, "操作失败"),

    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(400, "参数检验失败"),
    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    /**
     * 没有相关权限
     */
    FORBIDDEN(403, "没有相关权限"),

    DATA_EXIST(501, "数据已维护"),

    DATA_NOT_EXIST(502, "数据不存在"),

    ADD_FAILED(503, "新增数据失败"),

    EDIT_FAILED(504, "编辑数据失败"),

    REMOVE_FAILED(505, "删除数据失败"),
    ;

    @Getter
    private final Integer code;
    @Getter
    private final String message;


    CoreRestEnum(Integer code, String value) {
        this.code = code;
        this.message = value;
    }
}
