package org.edu.sagesse.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>生成器应用入口</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({
        "org.edu.sagesse.common",
        "org.edu.sagesse.data",
        "org.edu.sagesse.generate"
})
public class GenerateApplication {


    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
    }
}
