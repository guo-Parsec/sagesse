package org.edu.sagesse.common.support.enums;

/**
 * <p>通用枚举</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public interface CoreEnum<C, V> {
    /**
     * <p>获取码值</p>
     *
     * @return C
     * @author hedwing
     * @since 2022/8/13
     */
    C getCode();

    /**
     * <p>获取值</p>
     *
     * @return C
     * @author hedwing
     * @since 2022/8/13
     */
    V getValue();

    /**
     * <p>获取值</p>
     *
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    default V value() {
        return getValue();
    }
}
