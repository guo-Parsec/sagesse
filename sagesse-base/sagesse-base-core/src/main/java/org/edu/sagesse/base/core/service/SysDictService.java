package org.edu.sagesse.base.core.service;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.api.core.domain.vo.SysDictVo;
import org.edu.sagesse.base.core.domain.dto.SysDictCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPageDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPutDto;
import org.edu.sagesse.base.core.domain.dto.SysDictQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysDict;

import java.util.List;
import java.util.Optional;

/**
 * 系统字典详情表(SysDict)表服务接口
 *
 * @author guocq
 * @see SysDict
 * @since 2022/11/28
 **/
public interface SysDictService {
    /**
     * <p>根据主键查询数据字典</p>
     *
     * @param id 数据字典id
     * @return 数据字典
     * @author guocq
     * @date 2022/11/28 16:04
     */
    SysDictVo find(Long id);

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
     * <p>根据条件查询单条数据</p>
     *
     * @param queryDto 查询参数
     * @return {@link SysDictVo}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    SysDictVo find(SysDictQueryDto queryDto);

    /**
     * <p>根据条件查询数据是否存在</p>
     *
     * @param queryDto 查询参数
     * @return {@link boolean}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    default boolean exist(SysDictQueryDto queryDto) {
        return Optional.ofNullable(find(queryDto)).isPresent();
    }

    /**
     * <p>根据参数分页查询系统字典详情表</p>
     *
     * @param pageDto 分页查询参数
     * @return {@link PageInfo<SysDictVo>}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    PageInfo<SysDictVo> page(SysDictPageDto pageDto);

    /**
     * <p>根据参数非分页查询系统字典详情表</p>
     *
     * @param queryDto 查询参数
     * @return {@link List<SysDictVo>}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    List<SysDictVo> list(SysDictQueryDto queryDto);

    /**
     * <p>新增数据</p>
     *
     * @param createDto 新增参数
     * @return {@link boolean} 是否新增成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    boolean create(SysDictCreateDto createDto);

    /**
     * <p>批量新增数据</p>
     *
     * @param createDtoList 新增参数列表
     * @return {@link boolean} 是否新增成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    boolean create(List<SysDictCreateDto> createDtoList);

    /**
     * <p>更新数据</p>
     *
     * @param putDto 更新参数
     * @return {@link boolean} 是否更新成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    boolean put(SysDictPutDto putDto);

    /**
     * <p>逻辑删除</p>
     *
     * @param id            主键
     * @param isLogicRemove 是否为逻辑删除
     * @return {@link boolean} 是否更新成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    boolean remove(Long id, boolean isLogicRemove);

}
