package org.edu.sagesse.base.core.dao;

import org.edu.sagesse.base.core.domain.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.data.base.support.enums.DataStatus;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Set;

/**
 * 系统角色表(SysRole)Dao
 *
 * @author guocq
 * @since 2022-11-29 14:28:09
 */
@Mapper
public interface SysRoleDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @param dataStatusSet 数据状态集合
     * @return {@link SysRole}
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    SysRole find(@Param("id") Long id, @Param("dataStatusSet") Set<Integer> dataStatusSet);

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysRole}
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    default SysRole findById(@Param("id") Long id) {
        Set<Integer> enableStatus = EnumHelper.getStatusCodeSet(DataStatus.ENABLE);
        return find(id, enableStatus);
    }

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysRole}
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    SysRole findByParam(@Param("queryParam") SysRole queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysRole}
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    List<SysRole> list(@Param("queryParam") SysRole queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysRole 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    int create(SysRole sysRole);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    int createBatch(@Param("list") List<SysRole> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysRole 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    int update(SysRole sysRole);

    /**
     * <p>根据主键逻辑删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    int deleteLogic(Long id);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    int deletePhysic(Long id);
}

