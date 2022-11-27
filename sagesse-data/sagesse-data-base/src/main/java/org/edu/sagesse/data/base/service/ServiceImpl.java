package org.edu.sagesse.data.base.service;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.helper.ConvertHelper;
import org.edu.sagesse.common.support.helper.ReflectHelper;
import org.edu.sagesse.common.support.helper.SpringBeanHelper;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.data.base.dao.Dao;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.domain.vo.AbstractVo;

import java.util.List;
import java.util.Optional;

/**
 * <p>业务类通用接口实现(泛型：E 实体对象 D 持久层对象 T 数据传输层对象 V 数据展示层对象)</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public class ServiceImpl<E extends AbstractDataEntity, D extends Dao<E>, T extends AbstractDto<E>, V extends AbstractVo>
        implements Service<E, D, T, V> {
    protected static SaLogger logger = SaLoggerFactory.getLogger(ServiceImpl.class);

    protected Class<E> entityClass = currentEntityClass();

    protected Class<D> daoClass = currentDaoClass();

    protected Class<T> dtoClass = currentDtoClass();

    protected Class<V> valueClass = currentValueClass();

    protected D dao = currentDao();

    @SuppressWarnings("unchecked")
    protected Class<E> currentEntityClass() {
        return (Class<E>) ReflectHelper.getSuperClassGenericType(this.getClass(), ServiceImpl.class, 0);
    }

    @SuppressWarnings("unchecked")
    protected Class<D> currentDaoClass() {
        return (Class<D>) ReflectHelper.getSuperClassGenericType(this.getClass(), ServiceImpl.class, 1);
    }

    @SuppressWarnings("unchecked")
    protected Class<T> currentDtoClass() {
        return (Class<T>) ReflectHelper.getSuperClassGenericType(this.getClass(), ServiceImpl.class, 2);
    }

    @SuppressWarnings("unchecked")
    protected Class<V> currentValueClass() {
        return (Class<V>) ReflectHelper.getSuperClassGenericType(this.getClass(), ServiceImpl.class, 3);
    }

    protected D currentDao() {
        if (daoClass == null) {
            daoClass = currentDaoClass();
        }
        return SpringBeanHelper.getBean(daoClass);
    }

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public V find(Long id) {
        return Optional.ofNullable(dao.find(id)).map(ele -> ConvertHelper.convert(ele, valueClass)).orElseGet(() -> {
            logger.debug("[service]根据[id={}]查询数据为空", id);
            return null;
        });
    }

    /**
     * <p>根据参数查询唯一数据</p>
     *
     * @param queryDto 查询参数
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public V find(T queryDto) {
        if (queryDto == null) {
            logger.error("queryDto为null");
            throw new CoreException("查询参数不能为null");
        }
        E entity = queryDto.toEntity();
        return Optional.ofNullable(dao.find(entity)).map(ele -> ConvertHelper.convert(ele, valueClass)).orElseGet(() -> {
            logger.debug("[service]根据[queryDto={}]查询数据为空", entity);
            return null;
        });
    }

    /**
     * <p>根据参数分页查询数据</p>
     *
     * @param queryDto 查询参数
     * @return PageInfo<V>
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public PageInfo<V> pageQuery(T queryDto) {
        return null;
    }

    /**
     * <p>根据参数不分页查询数据</p>
     *
     * @param queryDto 查询参数
     * @return List<V>
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public List<V> listQuery(T queryDto) {
        return null;
    }

    /**
     * <p>新增数据</p>
     *
     * @param createDto 新增数据
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public V create(T createDto) {
        return null;
    }

    /**
     * <p>修改数据</p>
     *
     * @param editDto 修改数据
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public V edit(T editDto) {
        return null;
    }

    /**
     * <p>根据主键删除数据</p>
     *
     * @param id 主键
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public V remove(Long id) {
        return null;
    }
}
