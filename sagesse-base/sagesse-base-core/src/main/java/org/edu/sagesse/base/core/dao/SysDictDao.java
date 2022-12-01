package org.edu.sagesse.base.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.base.core.domain.dto.SysDictQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysDict;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.data.base.support.enums.DataStatus;

import java.util.List;
import java.util.Set;

/**
 * 系统字典详情表(SysDict)Dao
 *
 * @author guocq
 * @since 2022-12-01 10:30:15
 */
@Mapper
public interface SysDictDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @param dataStatusSet 数据状态集合
     * @return {@link SysDict}
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    SysDict find(@Param("id") Long id, @Param("dataStatusSet") Set<Integer> dataStatusSet);

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysDict}
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    default SysDict findById(@Param("id") Long id) {
        Set<Integer> enableStatus = EnumHelper.getStatusCodeSet(DataStatus.ENABLE);
        return find(id, enableStatus);
    }

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysDict}
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    SysDict findByParam(@Param("queryParam") SysDictQueryDto queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysDict}
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    List<SysDict> list(@Param("queryParam") SysDictQueryDto queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysDict 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int create(SysDict sysDict);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int createBatch(@Param("list") List<SysDict> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysDict 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int update(SysDict sysDict);

    /**
     * <p>根据主键逻辑删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int deleteLogic(Long id);

    /**
     * <p>根据主键列表逻辑删除数据</p>
     *
     * @param set 主键列表
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int deleteLogicBatch(@Param("set") Set<Long> set);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int deletePhysic(Long id);

    /**
     * <p>根据主键列表物理删除数据</p>
     *
     * @param set 主键列表
     * @return 影响行数
     * @author guocq
     * @since 2022-12-01 10:30:15
     */
    int deletePhysicBatch(@Param("set") Set<Long> set);
}

