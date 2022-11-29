package org.edu.sagesse.common.support.rest;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;

/**
 * <p>结果载体</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public class Carrier<D> {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(Carrier.class);
    /**
     * 信息码
     */
    @Getter
    @Setter
    private int code;

    /**
     * 信息
     */
    @Getter
    @Setter
    private String message;

    /**
     * 数据载体
     */
    @Getter
    @Setter
    private D data;

    Carrier() {
    }

    Carrier(int code) {
        this.code = code;
    }

    Carrier(int code, D data) {
        this.code = code;
        this.data = data;
    }

    Carrier(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Carrier(RestEnum restEnum) {
        this.code = restEnum.getCode();
        this.message = restEnum.getMessage();
    }

    public Carrier(RestEnum restEnum, D data) {
        this.code = restEnum.getCode();
        this.message = restEnum.getMessage();
        this.data = data;
    }

    public Carrier(int code, String message, D data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static <D> Carrier<D> success() {
        return new Carrier<>(CoreRestEnum.SUCCESS);
    }

    /**
     * 空返回结果
     */
    public static <D> Carrier<D> empty() {
        return new Carrier<>(CoreRestEnum.EMPTY);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Carrier<T> success(T data) {
        return new Carrier<T>(CoreRestEnum.SUCCESS, data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> Carrier<T> success(T data, String message) {
        return new Carrier<T>(CoreRestEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> Carrier<T> failed() {
        return new Carrier<T>(CoreRestEnum.ERROR);
    }

    /**
     * 失败返回结果
     *
     * @param restEnum 错误码
     */
    public static <T> Carrier<T> failed(RestEnum restEnum) {
        return new Carrier<T>(restEnum);
    }

    /**
     * 失败返回结果
     *
     * @param restEnum 错误码
     * @param message  错误信息
     */
    public static <T> Carrier<T> failed(RestEnum restEnum, String message) {
        return new Carrier<T>(restEnum.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param code    错误码
     * @param message 错误信息
     */
    public static <T> Carrier<T> failed(String message, int code) {
        return new Carrier<T>(code, message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Carrier<T> validateFailed() {
        return new Carrier<T>(CoreRestEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Carrier<T> validateFailed(String message) {
        return new Carrier<T>(CoreRestEnum.VALIDATE_FAILED.getCode(), message);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Carrier<T> unauthorized(T data) {
        return new Carrier<T>(CoreRestEnum.UNAUTHORIZED, data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Carrier<T> forbidden(T data) {
        return new Carrier<T>(CoreRestEnum.FORBIDDEN, data);
    }

    public static <T> T getSuccessData(Carrier<T> commonResult) {
        if (commonResult == null) {
            LOGGER.error("请求结果集为空，可能为请求错误");
            throw new RuntimeException("The request result set is empty, possibly a request error");
        }
        int resultCode = commonResult.getCode();
        if (!CoreRestEnum.SUCCESS.getCode().equals(resultCode)) {
            LOGGER.error("请求信息码为{}，可能为请求失败", resultCode);
            throw new CoreException(commonResult.getMessage(), resultCode);
        }
        return commonResult.getData();
    }
}

