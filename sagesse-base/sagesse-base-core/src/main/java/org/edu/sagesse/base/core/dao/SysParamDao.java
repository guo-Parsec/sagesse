package org.edu.sagesse.base.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.base.core.domain.dto.SysParamQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysParam;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.data.base.support.enums.DataStatus;

import java.util.List;
import java.util.Set;

/**
 * 系统参数表(SysParam)Dao
 *
 * @author guocq
 * @since 2022-12-01 10:03:53
 */
@Mapper
public interface SysParamDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @param dataStatusSet 数据状态集合
     * @return {@link SysParam}
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    SysParam find(@Param("id") Long id, @Param("dataStatusSet") Set<Integer> dataStatusSet);

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysParam}
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    default SysParam findById(@Param("id") Long id) {
        Set<Integer> enableStatus = EnumHelper.getStatusCodeSet(DataStatus.ENABLE);
        return find(id, enableStatus);
    }

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysParam}
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    SysParam findByParam(@Param("queryParam") SysParamQueryDto queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysParam}
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    List<SysParam> list(@Param("queryParam") SysParamQueryDto queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysParam 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int create(SysParam sysParam);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int createBatch(@Param("list") List<SysParam> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysParam 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int update(SysParam sysParam);

    /**
     * <p>根据主键逻辑删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int deleteLogic(Long id);

    /**
     * <p>根据主键列表逻辑删除数据</p>
     *
     * @param set 主键列表
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int deleteLogicBatch(@Param("set") Set<Long> set);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int deletePhysic(Long id);

    /**
     * <p>根据主键列表物理删除数据</p>
     *
     * @param set 主键列表
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:03:53
     */
    int deletePhysicBatch(@Param("set") Set<Long> set);
}

