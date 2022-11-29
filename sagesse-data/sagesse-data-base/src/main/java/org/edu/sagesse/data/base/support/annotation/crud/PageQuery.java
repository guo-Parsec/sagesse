package org.edu.sagesse.data.base.support.annotation.crud;

import java.lang.annotation.*;

/**
 * <p>分页查询</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageQuery {
}
