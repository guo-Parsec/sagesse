package org.edu.sagesse.common.support.exception;

import lombok.Getter;
import org.edu.sagesse.common.support.rest.CoreRestEnum;
import org.edu.sagesse.common.support.rest.RestEnum;

/**
 * <p>全局异常类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public class CoreException extends RuntimeException {
    private static final long serialVersionUID = 5872791920709845183L;

    @Getter
    private final RestEnum restEnum;
    @Getter
    private final Integer code;
    @Getter
    private final String message;

    public CoreException(RestEnum restEnum) {
        super(restEnum.getMessage());
        this.restEnum = restEnum;
        this.code = restEnum.getCode();
        this.message = restEnum.getMessage();
    }

    public CoreException(String message) {
        super(message);
        this.code = CoreRestEnum.ERROR.getCode();
        this.message = message;
        this.restEnum = CoreRestEnum.ERROR;
    }

    public CoreException(String message, Integer code) {
        super(message);
        this.code = code;
        this.message = message;
        this.restEnum = CoreRestEnum.ERROR;
    }

    public CoreException(RestEnum restEnum, String message) {
        super(message);
        this.code = restEnum.getCode();
        this.restEnum = restEnum;
        this.message = message;
    }

    public CoreException(Throwable cause, String message) {
        super(cause);
        this.code = CoreRestEnum.ERROR.getCode();
        this.restEnum = CoreRestEnum.ERROR;
        this.message = message;
    }

    public CoreException(Throwable cause, RestEnum restEnum) {
        super(cause);
        this.code = restEnum.getCode();
        this.restEnum = restEnum;
        this.message = restEnum.getMessage();
    }

    public CoreException(Throwable cause, RestEnum restEnum, String message) {
        super(message, cause);
        this.code = restEnum.getCode();
        this.restEnum = restEnum;
        this.message = message;
    }

}
