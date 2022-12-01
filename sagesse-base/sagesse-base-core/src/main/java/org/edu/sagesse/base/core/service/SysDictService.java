package org.edu.sagesse.base.core.service;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.core.domain.dto.SysDictCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPageDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPutDto;
import org.edu.sagesse.base.core.domain.dto.SysDictQueryDto;
import org.edu.sagesse.base.core.domain.vo.SysDictVo;

import java.util.List;
import java.util.Set;

/**
 * 系统字典详情表业务类接口
 *
 * @author guocq
 * @since 2022-12-01 10:30:28
 */
public interface SysDictService {
    /**
     * <p>查询字典名称</p>
     *
     * @param categoryCode 类别码
     * @return 字典转换数据
     * @author guocq
     * @date 2022/11/29 9:15
     */
    List<Dict> findDictName(String categoryCode);


    /**
     * <p>根据类别码和字典值查询数据</p>
     *
     * @param categoryCode 字典类别码
     * @param dictValue    字典值
     * @return {@code SysDictVo}
     * @author guocq
     * @date 2022/11/28 16:06
     */
    List<SysDictVo> findByCategoryCodeAndDictValue(String categoryCode, String dictValue);

    /**
     * <p>根据主键查询单条数据</p>
     *
     * @param id 主键
     * @return {@link SysDictVo}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    SysDictVo find(Long id);

    /**
     * <p>根据参数查询单条数据</p>
     *
     * @param dto 参数
     * @return {@link SysDictVo}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    SysDictVo find(SysDictQueryDto dto);

    /**
     * <p>根据参数查询数据列表</p>
     *
     * @param dto 参数
     * @return {@link List<SysDictVo>}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    List<SysDictVo> list(SysDictQueryDto dto);

    /**
     * <p>根据参数分页查询数据列表</p>
     *
     * @param dto 分页参数
     * @return {@link List<SysDictVo>}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    PageInfo<SysDictVo> page(SysDictPageDto dto);

    /**
     * <p>根据参数新增数据</p>
     *
     * @param dto 参数
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    boolean create(SysDictCreateDto dto);

    /**
     * <p>根据参数批量新增数据</p>
     *
     * @param list 参数列表
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    boolean create(List<SysDictCreateDto> list);

    /**
     * <p>根据参数修改数据</p>
     *
     * @param dto 参数
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    boolean put(SysDictPutDto dto);

    /**
     * <p>根据主键和是否逻辑删除条件删除数据</p>
     *
     * @param id      主键
     * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    boolean remove(Long id, boolean isLogic);

    /**
     * <p>根据主键列表和是否逻辑删除条件删除数据</p>
     *
     * @param idSet   主键列表
     * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    boolean remove(Set<Long> idSet, boolean isLogic);
}
