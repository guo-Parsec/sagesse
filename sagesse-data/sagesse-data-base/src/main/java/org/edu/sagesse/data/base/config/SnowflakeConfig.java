package org.edu.sagesse.data.base.config;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.support.factory.SnowflakeFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>雪花算法配置</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@Configuration
@ConfigurationProperties(prefix = "sagesse.snowflake")
public class SnowflakeConfig {
    /**
     * 机器标识 配置文件中不配置就是0
     */
    @Getter
    @Setter
    private long machineId;

    /**
     * 数据中心 配置文件中不配置就是0
     */
    @Getter
    @Setter
    private long datacenterId;

    @Bean
    public SnowflakeFactory snowflakeFactory() {
        return new SnowflakeFactory(datacenterId, machineId);
    }

}
