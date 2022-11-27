package org.edu.sagesse.data.base.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.List;

/**
 * <p>数据访问类通用接口</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public interface Dao<E extends AbstractDataEntity> {
    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id id
     * @return E
     * @author hedwing
     * @since 2022/11/26
     */
    E find(@Param("id") Long id);

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return E
     * @author hedwing
     * @since 2022/11/26
     */
    E find(E queryParam);

    /**
     * <p>分页查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link Page <E>}
     * @author guocq
     * @date 2022/11/24 15:00
     */
    Page<E> page(E queryParam);

    /**
     * <p>非分页查询数据</p>
     *
     * @param queryParam 查询参数
     * @return java.util.List<T>
     * @author guocq
     * @date 2022/11/24 15:01
     */
    List<E> list(E queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param entity entity
     * @return int
     * @author hedwing
     * @since 2022/11/26
     */
    int create(E entity);

    /**
     * <p>删除数据</p>
     *
     * @param id 主键
     * @return int
     * @author guocq
     * @date 2022/11/16 11:00
     */
    int delete(@Param("id") Long id);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param param 参数
     * @return int
     * @author guocq
     * @date 2022/11/16 10:47
     */
    int update(E param);
}
