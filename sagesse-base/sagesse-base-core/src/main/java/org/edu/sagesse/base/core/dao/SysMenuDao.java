package org.edu.sagesse.base.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.base.core.domain.entity.SysMenu;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.data.base.support.enums.DataStatus;

import java.util.List;
import java.util.Set;

/**
 * 系统菜单表(SysMenu)Dao
 *
 * @author guocq
 * @since 2022-11-29 14:31:34
 */
@Mapper
public interface SysMenuDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @param dataStatusSet 数据状态集合
     * @return {@link SysMenu}
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    SysMenu find(@Param("id") Long id, @Param("dataStatusSet") Set<Integer> dataStatusSet);

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysMenu}
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    default SysMenu findById(@Param("id") Long id) {
        Set<Integer> enableStatus = EnumHelper.getStatusCodeSet(DataStatus.ENABLE);
        return find(id, enableStatus);
    }

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysMenu}
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    SysMenu findByParam(@Param("queryParam") SysMenu queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysMenu}
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    List<SysMenu> list(@Param("queryParam") SysMenu queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysMenu 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    int create(SysMenu sysMenu);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    int createBatch(@Param("list") List<SysMenu> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysMenu 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    int update(SysMenu sysMenu);

    /**
     * <p>根据主键逻辑删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    int deleteLogic(Long id);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:31:34
     */
    int deletePhysic(Long id);
}

