package org.edu.sagesse.data.base.support.helper;

import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.domain.vo.AbstractDataVo;

/**
 * <p>转化辅助类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public class ConvertHelper {
    /**
     * <p>类型为S的对象source转化为</p>
     *
     * @param source     被转换原对象
     * @param tClass     目标的类对象
     * @param defaultVal 默认值
     * @return T
     * @author hedwing
     * @since 2022/11/26
     */
    public static <T, S> T convert(S source, T defaultVal, Class<T> tClass) {
        if (source == null) {
            return defaultVal;
        }
        return tClass.cast(source);
    }

    /**
     * <p>类型为S的对象source转化为</p>
     *
     * @param source 被转换原对象
     * @param tClass 目标的类对象
     * @return T
     * @author hedwing
     * @since 2022/11/26
     */
    public static <T, S> T convert(S source, Class<T> tClass) {
        return tClass.cast(source);
    }

    /**
     * <p>根据构造器转换vo</p>
     *
     * @param builder 构造器辅助类
     * @param entity        实体
     * @return org.edu.sagesse.common.support.helper.BuilderHelper<V>
     * @author guocq
     * @date 2022/11/28 17:12
     */
    public static <V extends AbstractDataVo, E extends AbstractDataEntity> Builder<V> convertVo(Builder<V> builder, E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity不能为null");
        }
        if (builder == null || !builder.isWith()) {
            throw new IllegalArgumentException("构造器不能为null,也不能已完成构建操作");
        }
        return builder
                .enhanceWith(AbstractDataVo::setId, entity::getId)
                .enhanceWith(AbstractDataVo::setDataStatus, entity::getDataStatus)
                .enhanceWith(AbstractDataVo::setGmtCreate, entity::getGmtCreate)
                .enhanceWith(AbstractDataVo::setGmtModify, entity::getGmtModify);

    }
}
