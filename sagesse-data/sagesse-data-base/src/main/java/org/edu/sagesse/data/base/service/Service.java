package org.edu.sagesse.data.base.service;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.data.base.dao.Dao;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.domain.vo.AbstractVo;

import java.util.List;

/**
 * <p>业务类通用接口</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public interface Service<E extends AbstractDataEntity, D extends Dao<E>, T extends AbstractDto<E>, V extends AbstractVo> {
    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    V find(Long id);

    /**
     * <p>根据参数查询唯一数据</p>
     *
     * @param queryDto 查询参数
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    V find(T queryDto);

    /**
     * <p>根据参数分页查询数据</p>
     *
     * @param queryDto 查询参数
     * @return PageInfo<V>
     * @author hedwing
     * @since 2022/11/26
     */
    PageInfo<V> pageQuery(T queryDto);

    /**
     * <p>根据参数不分页查询数据</p>
     *
     * @param queryDto 查询参数
     * @return List<V>
     * @author hedwing
     * @since 2022/11/26
     */
    List<V> listQuery(T queryDto);

    /**
     * <p>新增数据</p>
     *
     * @param createDto 新增数据
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    V create(T createDto);

    /**
     * <p>修改数据</p>
     *
     * @param editDto 修改数据
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    V edit(T editDto);

    /**
     * <p>根据主键删除数据</p>
     *
     * @param id 主键
     * @return V
     * @author hedwing
     * @since 2022/11/26
     */
    V remove(Long id);
}
