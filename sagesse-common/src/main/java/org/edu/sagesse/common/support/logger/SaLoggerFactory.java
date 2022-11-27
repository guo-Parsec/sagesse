package org.edu.sagesse.common.support.logger;

/**
 * <p>>自定义日志生成工厂类</</p>
 *
 * @author hedwing
 * @since 2022/10/21
 **/
public class SaLoggerFactory {
    public static SaLogger getLogger(Class<?> clz) {
        return new SaLogger(clz);
    }

    public static SaLogger getLogger(String name) {
        return new SaLogger(name);
    }
}
