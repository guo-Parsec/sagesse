package org.edu.sagesse.base.core.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.api.core.domain.vo.SysDictVo;
import org.edu.sagesse.base.core.dao.SysDictDao;
import org.edu.sagesse.base.core.domain.convert.SysDictConvert;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictCreateDto;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictPageDto;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictPutDto;
import org.edu.sagesse.base.core.domain.dto.dict.SysDictQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysDict;
import org.edu.sagesse.base.core.service.SysDictService;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.common.util.CollectionUtil;
import org.edu.sagesse.common.util.StringUtil;
import org.edu.sagesse.data.base.support.enums.DataStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>系统字典业务接口实现类</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@Service(value = "sysDictService")
public class SysDictServiceImpl implements SysDictService {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(SysDictServiceImpl.class);
    @Resource
    private SysDictDao sysDictDao;

    /**
     * <p>根据主键查询数据字典</p>
     *
     * @param id 数据字典id
     * @return 数据字典
     * @author guocq
     * @date 2022/11/28 16:04
     */
    @Override
    public SysDictVo find(Long id) {
        SysDict dictFormDb = sysDictDao.findById(id);
        return Optional.ofNullable(dictFormDb).map(SysDictConvert::entityToSysDictVo).orElse(SysDictVo.EMPTY);
    }

    /**
     * <p>查询字典名称</p>
     *
     * @param categoryCode 类别码
     * @return 字典转换数据
     * @author guocq
     * @date 2022/11/29 9:15
     */
    @Override
    public List<Dict> findDictName(String categoryCode) {
        SysDict param = Builder.builder(SysDict::new)
                .with(StringUtil.isBlank(categoryCode), SysDict::setCategoryCode, categoryCode)
                .with(SysDict::setDataStatus, DataStatus.ENABLE.getValue())
                .build();
        List<SysDict> dictListFromDb = sysDictDao.list(param);
        if (CollectionUtil.isEmpty(dictListFromDb)) {
            LOGGER.debug("根据[categoryCode={}]查询字典数据不存在", categoryCode);
            return Lists.newArrayList();
        }
        return dictListFromDb.stream().map(SysDictConvert::entityToDict).collect(Collectors.toList());
    }

    /**
     * <p>根据类别码和字典值查询数据</p>
     *
     * @param categoryCode 字典类别码
     * @param dictValue    字典值
     * @return org.edu.sagesse.base.core.domain.entity.SysDict
     * @author guocq
     * @date 2022/11/28 16:06
     */
    @Override
    public List<SysDictVo> findByCategoryCodeAndDictValue(String categoryCode, String dictValue) {
        SysDict param = Builder.builder(SysDict::new)
                .with(SysDict::setCategoryCode, categoryCode)
                .with(SysDict::setDictValue, dictValue)
                .with(SysDict::setDataStatus, DataStatus.ENABLE.getValue())
                .build();
        List<SysDict> dictListFromDb = sysDictDao.list(param);
        if (CollectionUtil.isEmpty(dictListFromDb)) {
            LOGGER.debug("根据[categoryCode={},dictValue={}]查询字典数据不存在", categoryCode, dictValue);
            return Lists.newArrayList();
        }
        return dictListFromDb.stream().map(SysDictConvert::entityToSysDictVo).collect(Collectors.toList());
    }

    /**
     * <p>根据条件查询单条数据</p>
     *
     * @param queryDto 查询参数
     * @return {@link SysDictVo}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public SysDictVo find(SysDictQueryDto queryDto) {
        SysDict dict = SysDictConvert.sysDictQueryDtoToEntity(queryDto);
        return Optional.ofNullable(sysDictDao.findByParam(dict)).map(SysDictConvert::entityToSysDictVo).orElse(SysDictVo.EMPTY);
    }

    /**
     * <p>根据参数分页查询系统字典详情表</p>
     *
     * @param pageDto 分页查询参数
     * @return {@link PageInfo <SysDictVo>}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public PageInfo<SysDictVo> page(SysDictPageDto pageDto) {
        SysDict dict = SysDictConvert.sysDictPageDtoToEntity(pageDto);
        return null;
    }

    /**
     * <p>根据参数非分页查询系统字典详情表</p>
     *
     * @param queryDto 查询参数
     * @return {@link List<SysDictVo>}
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public List<SysDictVo> list(SysDictQueryDto queryDto) {
        return null;
    }

    /**
     * <p>新增数据</p>
     *
     * @param createDto 新增参数
     * @return {@link boolean} 是否新增成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public boolean create(SysDictCreateDto createDto) {
        return false;
    }

    /**
     * <p>批量新增数据</p>
     *
     * @param createDtoList 新增参数列表
     * @return {@link boolean} 是否新增成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public boolean create(List<SysDictCreateDto> createDtoList) {
        return false;
    }

    /**
     * <p>更新数据</p>
     *
     * @param putDto 更新参数
     * @return {@link boolean} 是否更新成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public boolean put(SysDictPutDto putDto) {
        return false;
    }

    /**
     * <p>逻辑删除</p>
     *
     * @param id            主键
     * @param isLogicRemove 是否为逻辑删除
     * @return {@link boolean} 是否更新成功
     * @author guocq
     * @since 2022-11-29 16:24:43
     */
    @Override
    public boolean remove(Long id, boolean isLogicRemove) {
        return false;
    }
}
