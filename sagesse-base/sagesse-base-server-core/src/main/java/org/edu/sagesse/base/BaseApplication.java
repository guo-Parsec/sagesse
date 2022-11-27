package org.edu.sagesse.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>基础微服务启动类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({
        "org.edu.sagesse.common",
        "org.edu.sagesse.data",
        "org.edu.sagesse.base"
})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
