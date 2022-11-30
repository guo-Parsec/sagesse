package org.edu.sagesse.generate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>资源配置类</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
@Configuration
public class ResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:static/","classpath:META-IFA/resources/","classpath:resources/","classpath:public/","classpath:/");
    }
}
