package org.edu.sagesse.common.support.helper;

import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.rest.CoreRestEnum;
import org.edu.sagesse.common.support.rest.RestEnum;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>代码辅助类</p>
 *
 * @author guocq
 * @since 2022/11/17
 **/
public class CodeHelper {
    /**
     * <p>错误信息抛出</p>
     *
     * @param logger  日志
     * @param message 错误信息提示
     * @param arg     参数
     * @author guocq
     * @date 2022/11/17 10:13
     */
    public static void throwError(final SaLogger logger, RestEnum code, String message, Object arg) {
        logger.error(message, arg);
        throw new CoreException(code, TextHelper.build().format(message, arg));
    }

    /**
     * <p>错误信息抛出</p>
     *
     * @param logger  日志
     * @param message 错误信息提示
     * @param arg     参数
     * @author guocq
     * @date 2022/11/17 10:13
     */
    public static void throwError(final SaLogger logger, RestEnum code, String message, Object... arg) {
        logger.error(message, arg);
        throw new CoreException(code, TextHelper.build().format(message, arg));
    }

    /**
     * <p>错误信息抛出 使用默认错误码</p>
     *
     * @param logger  日志
     * @param message 错误信息提示
     * @param arg     参数
     * @author guocq
     * @date 2022/11/17 10:23
     */
    public static void throwError(final SaLogger logger, String message, Object... arg) {
        throwError(logger, CoreRestEnum.ERROR, message, arg);
    }

    /**
     * <p>错误信息抛出 使用默认错误信息</p>
     *
     * @param logger 日志
     * @param code   错误码
     * @param arg    参数
     * @author guocq
     * @date 2022/11/17 10:24
     */
    public static void throwError(final SaLogger logger, RestEnum code, Object... arg) {
        throwError(logger, code, code.getMessage(), arg);
    }

    /**
     * <p>错误信息抛出 使用默认错误信息</p>
     *
     * @param logger 日志
     * @param arg    参数
     * @author guocq
     * @date 2022/11/17 10:24
     */
    public static void throwError(final SaLogger logger, Object... arg) {
        throwError(logger, CoreRestEnum.ERROR, arg);
    }

    /**
     * 获取当前请求
     *
     * @return 请求
     */
    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        return requestAttributes.getRequest();
    }
}
