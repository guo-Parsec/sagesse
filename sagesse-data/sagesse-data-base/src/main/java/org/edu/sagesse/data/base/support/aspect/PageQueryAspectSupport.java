package org.edu.sagesse.data.base.support.aspect;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.data.base.domain.dto.PageableDto;
import org.edu.sagesse.data.base.support.annotation.crud.PageQuery;
import org.springframework.stereotype.Component;

/**
 * <p>分页查询切面支持</p>
 *
 * @author guocq
 */
@Aspect
@Component
public class PageQueryAspectSupport {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(PageQueryAspectSupport.class);

    @Around(value = "@annotation(pageQuery)", argNames = "joinPoint, pageQuery")
    public Object doPageQueryAspect(ProceedingJoinPoint joinPoint, PageQuery pageQuery) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        LOGGER.debug("方法[{}]正在分页查询数据", methodName);
        Object[] args = joinPoint.getArgs();
        // 必须清空page再次开启
        PageHelper.clearPage();
        startPage(args, methodName);
        return joinPoint.proceed(args);
    }

    private void startPage(Object[] args, String methodName) {
        PageableDto pageDto = null;
        for (Object arg : args) {
            if (arg instanceof PageableDto) {
                pageDto = (PageableDto) arg;
                break;
            }
        }
        int currPage = pageDto == null || pageDto.getCurrPage() <= 0 ? 1 : pageDto.getCurrPage();
        int pageSize = pageDto == null || pageDto.getPageSize() <= 0 ? 10 : pageDto.getPageSize();
        LOGGER.debug("方法[{}]正在分页查询数据, 当前页为{},页大小为{}", methodName, currPage, pageSize);
        PageHelper.startPage(currPage, pageSize);
    }
}
