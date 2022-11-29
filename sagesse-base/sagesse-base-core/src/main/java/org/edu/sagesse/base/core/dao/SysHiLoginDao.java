package org.edu.sagesse.base.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.edu.sagesse.base.core.domain.entity.SysHiLogin;

import java.util.List;

/**
 * 登录历史记录表(SysHiLogin)Dao
 *
 * @author guocq
 * @since 2022-11-29 14:11:54
 */
@Mapper
public interface SysHiLoginDao {

    /**
     * <p>根据主键以及数据状态查询唯一数据</p>
     *
     * @param id            主键
     * @return {@link SysHiLogin}
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    SysHiLogin find(@Param("id") Long id);


    /**
     * <p>根据条件查询唯一数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysHiLogin}
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    SysHiLogin findByParam(@Param("queryParam") SysHiLogin queryParam);

    /**
     * <p>根据条件查询数据</p>
     *
     * @param queryParam 查询参数
     * @return {@link SysHiLogin}
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    List<SysHiLogin> list(@Param("queryParam") SysHiLogin queryParam);

    /**
     * <p>新增数据</p>
     *
     * @param sysHiLogin 数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    int create(SysHiLogin sysHiLogin);

    /**
     * <p>批量新增数据</p>
     *
     * @param list 数据实体列表
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    int createBatch(@Param("list") List<SysHiLogin> list);

    /**
     * <p>根据主键更新数据</p>
     *
     * @param sysHiLogin 更新的数据实体
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    int update(SysHiLogin sysHiLogin);

    /**
     * <p>根据主键物理删除数据</p>
     *
     * @param id 主键
     * @return 影响行数
     * @author guocq
     * @since 2022-11-29 14:11:54
     */
    int deletePhysic(Long id);
}

