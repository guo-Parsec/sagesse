package org.edu.sagesse.data.base.config;

import com.google.common.collect.Maps;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.edu.sagesse.common.support.helper.SpringBeanHelper;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.support.enums.DataStatus;
import org.edu.sagesse.data.base.support.factory.SnowflakeFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.function.Consumer;

/**
 * <p>mybatis拦截器</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@Component
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class MybatisInterceptor implements Interceptor, InitializingBean {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(MybatisInterceptor.class);

    private static final Map<SqlCommandType, Consumer<AbstractDataEntity>> MAPPING = Maps.newHashMapWithExpectedSize(2);

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        execFill(args[1], sqlCommandType);
        if (args[1] instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap) args[1];
            ((Collection) paramMap.get("list")).forEach(data -> execFill(data, sqlCommandType));
        }
        return invocation.proceed();
    }

    /**
     * <p>执行数据填充</p>
     *
     * @param object         object
     * @param sqlCommandType sqlCommandType
     * @author hedwing
     * @since 2022/11/26
     */
    private void execFill(Object object, SqlCommandType sqlCommandType) {
        AbstractDataEntity data = null;
        if (object instanceof AbstractDataEntity) {
            data = (AbstractDataEntity) object;
            MAPPING.get(sqlCommandType).accept(data);
        }
    }

    /**
     * <p>执行数据更新</p>
     *
     * @param arg arg
     * @author hedwing
     * @since 2022/11/26
     */
    private void doUpdate(AbstractDataEntity arg) {
        LOGGER.debug("参数{}正在执行update", arg);
        arg.setGmtModify(LocalDateTime.now());
    }

    /**
     * <p>执行数据新增</p>
     *
     * @param arg arg
     * @author hedwing
     * @since 2022/11/26
     */
    private void doInsert(AbstractDataEntity arg) {
        LOGGER.debug("参数{}正在执行insert", arg);
        LocalDateTime now = LocalDateTime.now();
        SnowflakeFactory snowflakeFactory = SpringBeanHelper.getBean(SnowflakeFactory.class);
        arg.setId(snowflakeFactory.nextId());
        arg.setDataStatus(DataStatus.ENABLE.value());
        arg.setGmtCreate(now);
        arg.setGmtModify(now);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MAPPING.put(SqlCommandType.UPDATE, this::doUpdate);
        MAPPING.put(SqlCommandType.INSERT, this::doInsert);
    }
}
