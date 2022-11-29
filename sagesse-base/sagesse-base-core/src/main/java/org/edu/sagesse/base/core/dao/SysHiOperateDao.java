package org.edu.sagesse.base.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.base.core.domain.entity.SysHiOperate;

import java.util.List;

/**
 * 操作历史记录表(SysHiOperate)Dao
 *
 * @author guocq
 * @since 2022-11-29 14:12:17
 */
@Mapper
public interface SysHiOperateDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysHiOperate}
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    SysHiOperate find(@Param("id") Long id);

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysHiOperate}
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    SysHiOperate findByParam(@Param("queryParam") SysHiOperate queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysHiOperate}
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    List<SysHiOperate> list(@Param("queryParam") SysHiOperate queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysHiOperate 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    int create(SysHiOperate sysHiOperate);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    int createBatch(@Param("list") List<SysHiOperate> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysHiOperate 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    int update(SysHiOperate sysHiOperate);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:12:17
     */
    int deletePhysic(Long id);
}

