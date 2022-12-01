package org.edu.sagesse.base.core.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.core.dao.SysDictDao;
import org.edu.sagesse.base.core.domain.convert.SysDictConvert;
import org.edu.sagesse.base.core.domain.dto.SysDictCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPageDto;
import org.edu.sagesse.base.core.domain.dto.SysDictPutDto;
import org.edu.sagesse.base.core.domain.dto.SysDictQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysDict;
import org.edu.sagesse.base.core.domain.vo.SysDictVo;
import org.edu.sagesse.base.core.service.SysDictService;
import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.common.support.rest.CoreRestEnum;
import org.edu.sagesse.common.util.CollectionUtil;
import org.edu.sagesse.common.util.StringUtil;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.support.annotation.crud.PageQuery;
import org.edu.sagesse.data.base.support.enums.DataStatus;
import org.edu.sagesse.data.base.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 系统字典详情表业务类接口实现类
 *
 * @author guocq
 * @since 2022-12-01 10:30:28
 */
@Service(value = "sysDictService")
public class SysDictServiceImpl implements SysDictService {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(SysDictServiceImpl.class);
    @Resource
    private SysDictDao sysDictDao;

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
        SysDictQueryDto param = Builder.builder(SysDictQueryDto::new)
                .with(StringUtil.isBlank(categoryCode), SysDictQueryDto::setCategoryCode, categoryCode)
                .with(SysDictQueryDto::setDataStatusSet, EnumHelper.getStatusCodeSet(DataStatus.ENABLE))
                .build();
        List<SysDict> dictListFromDb = sysDictDao.list(param);
        if (CollectionUtil.isEmpty(dictListFromDb)) {
            LOGGER.debug("根据[categoryCode={}]查询字典数据不存在", categoryCode);
            return Lists.newArrayList();
        }
        return dictListFromDb.stream().map(SysDictConvert::convertSysDictToDict).collect(Collectors.toList());
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
        SysDictQueryDto param = Builder.builder(SysDictQueryDto::new)
                .with(SysDictQueryDto::setCategoryCode, categoryCode)
                .with(SysDictQueryDto::setDictValue, dictValue)
                .with(SysDictQueryDto::setDataStatusSet, EnumHelper.getStatusCodeSet(DataStatus.ENABLE))
                .build();
        List<SysDict> dictListFromDb = sysDictDao.list(param);
        if (CollectionUtil.isEmpty(dictListFromDb)) {
            LOGGER.debug("根据[categoryCode={},dictValue={}]查询字典数据不存在", categoryCode, dictValue);
            return Lists.newArrayList();
        }
        return dictListFromDb.stream().map(SysDictConvert::convertSysDictToSysDictVo).collect(Collectors.toList());
    }

    /**
     * <p>根据主键查询单条数据</p>
     *
     * @param id 主键
     * @return {@link SysDictVo}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public SysDictVo find(Long id) {
        LOGGER.debug("根据id={}查询单条数据", id);
        SysDict sysDict = sysDictDao.findById(id);
        return SysDictConvert.convertSysDictToSysDictVo(sysDict);
    }

    /**
     * <p>根据参数查询单条数据</p>
     *
     * @param dto 参数
     * @return {@link SysDictVo}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public SysDictVo find(SysDictQueryDto dto) {
        LOGGER.debug("根据参数={}查询单条数据", dto);
        SysDict sysDict = sysDictDao.findByParam(dto);
        return SysDictConvert.convertSysDictToSysDictVo(sysDict);
    }

    /**
     * <p>根据参数查询数据列表</p>
     *
     * @param dto 参数
     * @return {@link List<SysDictVo>}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public List<SysDictVo> list(SysDictQueryDto dto) {
        LOGGER.debug("根据参数={}查询数据列表", dto);
        List<SysDict> sysDictList = sysDictDao.list(dto);
        return sysDictList.stream().map(SysDictConvert::convertSysDictToSysDictVo).collect(Collectors.toList());
    }

    /**
     * <p>根据参数分页查询数据列表</p>
     *
     * @param dto 分页参数
     * @return {@link List<SysDictVo>}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    @PageQuery
    public PageInfo<SysDictVo> page(SysDictPageDto dto) {
        LOGGER.debug("根据参数={}分页查询数据列表", dto);
        List<SysDict> list = sysDictDao.list(dto);
        List<SysDictVo> vos = list.stream().map(SysDictConvert::convertSysDictToSysDictVo).collect(Collectors.toList());
        return PageUtil.toPageInfo(vos, new PageInfo<>(list));
    }

    /**
     * <p>根据参数新增数据</p>
     *
     * @param dto 参数
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public boolean create(SysDictCreateDto dto) {
        LOGGER.debug("根据参数={}新增单条数据", dto);
        SysDict sysDict = SysDictConvert.convertSysDictCreateDtoToSysDict(dto);
        checkBeforeCreate(sysDict);
        return sysDictDao.create(sysDict) == 1;
    }

    /**
     * <p>根据参数批量新增数据</p>
     *
     * @param list 参数列表
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public boolean create(List<SysDictCreateDto> list) {
        List<SysDict> sysDictList = list.stream()
                .map(SysDictConvert::convertSysDictCreateDtoToSysDict)
                .peek(this::checkBeforeCreate)
                .collect(Collectors.toList());
        return sysDictList.size() == sysDictDao.createBatch(sysDictList);
    }

    /**
     * <p>根据参数修改数据</p>
     *
     * @param dto 参数
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public boolean put(SysDictPutDto dto) {
        SysDict sysDict = SysDictConvert.convertSysDictPutDtoToSysDict(dto);
        checkBeforePut(sysDict);
        return sysDictDao.update(sysDict) == 1;
    }

    /**
     * <p>根据主键和是否逻辑删除条件删除数据</p>
     *
     * @param id      主键
     * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public boolean remove(Long id, boolean isLogic) {
        checkBeforeRemove(id);
        int count = isLogic ? sysDictDao.deleteLogic(id) : sysDictDao.deletePhysic(id);
        return count == 1;
    }

    /**
     * <p>根据主键列表和是否逻辑删除条件删除数据</p>
     *
     * @param idSet   主键列表
     * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
     * @return {@link boolean}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    @Override
    public boolean remove(Set<Long> idSet, boolean isLogic) {
        idSet.forEach(this::checkBeforeRemove);
        int count = isLogic ? sysDictDao.deleteLogicBatch(idSet) : sysDictDao.deletePhysicBatch(idSet);
        return count == idSet.size();
    }

    /**
     * <p>根据唯一限定字段构建参数</p>
     *
     * @param sysDict sysDict
     * @return {@link SysDictQueryDto}
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    private SysDictQueryDto uniqueParamBuild(SysDict sysDict) {
        return Builder.builder(SysDictQueryDto::new)
                .enhanceWith(SysDictQueryDto::setCategoryCode, sysDict::getCategoryCode)
                .enhanceWith(SysDictQueryDto::setDictValue, sysDict::getDictValue)
                .with(SysDictQueryDto::setDataStatusSet, EnumHelper.getStatusCodeSet(DataStatus.ENABLE))
                .build();
    }

    /**
     * <p>创建之前进行校验</p>
     *
     * @param sysDict sysDict
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    private void checkBeforeCreate(SysDict sysDict) {
        SysDictQueryDto uniqueParam = uniqueParamBuild(sysDict);
        if (AbstractDataEntity.isNotEmpty(sysDictDao.findByParam(uniqueParam))) {
            LOGGER.error("数据{}已存在", uniqueParam);
            throw new CoreException(CoreRestEnum.DATA_EXIST);
        }
    }

    /**
     * <p>更新之前进行校验</p>
     *
     * @param sysDict sysDict
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    private void checkBeforePut(SysDict sysDict) {
        Long id = sysDict.getId();
        checkBeforeRemove(id);
        SysDictQueryDto uniqueParam = uniqueParamBuild(sysDict);
        long count = sysDictDao.list(uniqueParam).stream().filter(ele -> !Objects.equals(ele.getId(), id)).count();
        if (count > 0) {
            LOGGER.error("{}的数据已存在，不能重复", uniqueParam);
            throw new CoreException(CoreRestEnum.DATA_EXIST);
        }
    }

    /**
     * <p>删除之前进行校验</p>
     *
     * @param id id
     * @author guocq
     * @since 2022-12-01 10:30:28
     */
    private void checkBeforeRemove(Long id) {
        if (AbstractDataEntity.isEmpty(sysDictDao.findById(id))) {
            LOGGER.error("id={}的数据不存在", id);
            throw new CoreException(CoreRestEnum.DATA_NOT_EXIST);
        }
    }
}
