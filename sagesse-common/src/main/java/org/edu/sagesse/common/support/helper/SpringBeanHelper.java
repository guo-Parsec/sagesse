package org.edu.sagesse.common.support.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * <p>SpringBean辅助类</p>
 *
 * @author hedwing
 * @since 2022/10/22
 **/
@Component
public class SpringBeanHelper implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanHelper.applicationContext == null) {
            SpringBeanHelper.applicationContext = applicationContext;
        }
    }

    /**
     * 获取applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name 指定bean的类对象
     * @return bean对象
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz 指定bean的类对象
     * @param <T>   指定bean的类型
     * @return bean对象
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name  bean的名称
     * @param clazz 指定bean的类对象
     * @param <T>   指定bean的类型
     * @return bean对象
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
