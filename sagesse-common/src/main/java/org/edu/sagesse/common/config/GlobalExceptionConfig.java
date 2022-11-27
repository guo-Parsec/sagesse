package org.edu.sagesse.common.config;

import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.common.support.rest.Carrier;
import org.edu.sagesse.common.support.rest.RestEnum;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>全局异常配置</p>
 *
 * @author hedwing
 * @since 2022/8/27
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionConfig {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(GlobalExceptionConfig.class);

    /**
     * 参数校验失败异常
     *
     * @param exception 异常信息
     * @return 统一处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Carrier<Void> validException(MethodArgumentNotValidException exception) {
        ObjectError objectError = exception.getBindingResult().getAllErrors().get(0);
        LOGGER.error("参数校验失败", exception);
        return Carrier.validateFailed(objectError.getDefaultMessage());
    }

    /**
     * Starrism异常
     *
     * @param exception 异常信息
     * @return 统一处理
     */
    @ExceptionHandler({CoreException.class})
    public Carrier<Void> starrismExceptionHandler(CoreException exception) {
        LOGGER.error("The application run starrismException", exception);
        RestEnum restEnum = exception.getRestEnum();
        if (restEnum == null) {
            return Carrier.failed(exception.getMessage(), exception.getCode());
        }
        return Carrier.failed(exception.getRestEnum(), exception.getMessage());
    }

    /**
     * 异常
     *
     * @param exception 异常信息
     * @return 统一处理
     */
    @ExceptionHandler({Exception.class})
    public Carrier<Void> defaultExceptionHandler(Exception exception) {
        LOGGER.error("The application run exception", exception);
        return Carrier.failed();
    }
}
