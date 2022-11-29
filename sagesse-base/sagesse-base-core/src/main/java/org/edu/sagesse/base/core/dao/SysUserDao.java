package org.edu.sagesse.base.core.dao;

import org.edu.sagesse.base.core.domain.entity.SysUser;
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
 * 系统用户表(SysUser)Dao
 *
 * @author guocq
 * @since 2022-11-29 13:55:01
 */
@Mapper
public interface SysUserDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @param dataStatusSet 数据状态集合
     * @return {@link SysUser}
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    SysUser find(@Param("id") Long id, @Param("dataStatusSet") Set<Integer> dataStatusSet);

    /**
     * <p>根据主键查询唯一数据</p>
     *
     * @param id 主键
     * @return {@link SysUser}
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    default SysUser findById(@Param("id") Long id) {
        Set<Integer> enableStatus = EnumHelper.getStatusCodeSet(DataStatus.ENABLE);
        return find(id, enableStatus);
    }

    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysUser}
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    SysUser findByParam(@Param("queryParam") SysUser queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysUser}
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    List<SysUser> list(@Param("queryParam") SysUser queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysUser 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    int create(SysUser sysUser);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    int createBatch(@Param("list") List<SysUser> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysUser 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    int update(SysUser sysUser);

    /**
     * <p>根据主键逻辑删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    int deleteLogic(Long id);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 13:55:01
     */
    int deletePhysic(Long id);
}

