package org.edu.sagesse.base.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.base.core.domain.entity.SysResource;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.data.base.support.enums.DataStatus;

import java.util.List;
import java.util.Set;

/**
 * 系统资源表(SysResource)Dao
 *
 * @author guocq
 * @since 2022-11-29 14:22:55
 */
@Mapper
public interface SysResourceDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @param dataStatusSet 数据状态集合
     * @return {@link SysResource}
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    SysResource find(@Param("id") Long id, @Param("dataStatusSet") Set<Integer> dataStatusSet);

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysResource}
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    default SysResource findById(@Param("id") Long id) {
        Set<Integer> enableStatus = EnumHelper.getStatusCodeSet(DataStatus.ENABLE);
        return find(id, enableStatus);
    }

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysResource}
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    SysResource findByParam(@Param("queryParam") SysResource queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysResource}
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    List<SysResource> list(@Param("queryParam") SysResource queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysResource 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    int create(SysResource sysResource);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    int createBatch(@Param("list") List<SysResource> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysResource 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    int update(SysResource sysResource);

    /**
     * <p>根据主键逻辑删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    int deleteLogic(Long id);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    int deletePhysic(Long id);
}

