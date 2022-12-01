package org.edu.sagesse.base.core.service.impl;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.base.core.dao.SysParamDao;
import org.edu.sagesse.base.core.domain.convert.SysParamConvert;
import org.edu.sagesse.base.core.domain.dto.SysParamCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysParamPageDto;
import org.edu.sagesse.base.core.domain.dto.SysParamPutDto;
import org.edu.sagesse.base.core.domain.dto.SysParamQueryDto;
import org.edu.sagesse.base.core.domain.entity.SysParam;
import org.edu.sagesse.base.core.domain.vo.SysParamVo;
import org.edu.sagesse.base.core.service.SysParamService;
import org.edu.sagesse.common.support.exception.CoreException;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.common.support.helper.EnumHelper;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.common.support.rest.CoreRestEnum;
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
 * 系统参数表业务类接口实现类
 *
 * @author guocq
 * @since 2022-12-01 10:19:15
 */
 @Service(value = "sysParamService")
 public class SysParamServiceImpl implements SysParamService {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(SysParamServiceImpl.class);
    @Resource
    private SysParamDao sysParamDao;
    
   /**
    * <p>根据主键查询单条数据</p>
    *
    * @param id 主键
    * @return {@link SysParamVo}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public SysParamVo find(Long id) {
        LOGGER.debug("根据id={}查询单条数据", id);
        SysParam sysParam = sysParamDao.findById(id);
        return SysParamConvert.convertSysParamToSysParamVo(sysParam);
    }
    
   /**
    * <p>根据参数查询单条数据</p>
    *
    * @param dto 参数
    * @return {@link SysParamVo}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public SysParamVo find(SysParamQueryDto dto) {
        LOGGER.debug("根据参数={}查询单条数据", dto);
        SysParam sysParam = sysParamDao.findByParam(dto);
        return SysParamConvert.convertSysParamToSysParamVo(sysParam);
    }
    
   /**
    * <p>根据参数查询数据列表</p>
    *
    * @param dto 参数
    * @return {@link List<SysParamVo>}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public List<SysParamVo> list(SysParamQueryDto dto) {
        LOGGER.debug("根据参数={}查询数据列表", dto);
        List<SysParam> sysParamList = sysParamDao.list(dto);
        return sysParamList.stream().map(SysParamConvert::convertSysParamToSysParamVo).collect(Collectors.toList());
    }
    
   /**
    * <p>根据参数分页查询数据列表</p>
    *
    * @param dto 分页参数
    * @return {@link List<SysParamVo>}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    @PageQuery
    public PageInfo<SysParamVo> page(SysParamPageDto dto) {
        LOGGER.debug("根据参数={}分页查询数据列表", dto);
        List<SysParam> list = sysParamDao.list(dto);
        List<SysParamVo> vos = list.stream().map(SysParamConvert::convertSysParamToSysParamVo).collect(Collectors.toList());
        return PageUtil.toPageInfo(vos, new PageInfo<>(list));
    }
    
   /**
    * <p>根据参数新增数据</p>
    *
    * @param dto 参数
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public boolean create(SysParamCreateDto dto) {
        LOGGER.debug("根据参数={}新增单条数据", dto);
        SysParam sysParam = SysParamConvert.convertSysParamCreateDtoToSysParam(dto);
        checkBeforeCreate(sysParam);
        return sysParamDao.create(sysParam) == 1;
    }
    
   /**
    * <p>根据参数批量新增数据</p>
    *
    * @param list 参数列表
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public boolean create(List<SysParamCreateDto> list) {
        List<SysParam> sysParamList = list.stream()
                .map(SysParamConvert::convertSysParamCreateDtoToSysParam)
                .peek(this::checkBeforeCreate)
                .collect(Collectors.toList());
       return sysParamList.size() == sysParamDao.createBatch(sysParamList);
    }
    
   /**
    * <p>根据参数修改数据</p>
    *
    * @param dto 参数
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public boolean put(SysParamPutDto dto) {
        SysParam sysParam = SysParamConvert.convertSysParamPutDtoToSysParam(dto);
        checkBeforePut(sysParam);
        return sysParamDao.update(sysParam) == 1;
    }
    
   /**
    * <p>根据主键和是否逻辑删除条件删除数据</p>
    *
    * @param id 主键
    * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public boolean remove(Long id, boolean isLogic) {
        checkBeforeRemove(id);
        int count = isLogic ? sysParamDao.deleteLogic(id): sysParamDao.deletePhysic(id);
        return count == 1;
    }
    
   /**
    * <p>根据主键列表和是否逻辑删除条件删除数据</p>
    *
    * @param idSet 主键列表
    * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    @Override
    public boolean remove(Set<Long> idSet, boolean isLogic) {
        idSet.forEach(this::checkBeforeRemove);
        int count = isLogic ? sysParamDao.deleteLogicBatch(idSet): sysParamDao.deletePhysicBatch(idSet);
        return count == idSet.size();
    }
    
   /**
    * <p>根据唯一限定字段构建参数</p>
    *
    * @param sysParam sysParam
    * @return {@link SysParamQueryDto}
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    private SysParamQueryDto uniqueParamBuild(SysParam sysParam) {
        return Builder.builder(SysParamQueryDto::new)
                .enhanceWith(SysParamQueryDto::setCategoryCode, sysParam::getCategoryCode)
                .enhanceWith(SysParamQueryDto::setParamCode, sysParam::getParamCode)
                .with(SysParamQueryDto::setDataStatusSet, EnumHelper.getStatusCodeSet(DataStatus.ENABLE))
                .build();
    }
    
    /**
    * <p>创建之前进行校验</p>
    *
    * @param sysParam sysParam
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    private void checkBeforeCreate(SysParam sysParam) {
        SysParamQueryDto uniqueParam = uniqueParamBuild(sysParam);
        if (AbstractDataEntity.isNotEmpty(sysParamDao.findByParam(uniqueParam))) {
            LOGGER.error("数据{}已存在", uniqueParam);
            throw new CoreException(CoreRestEnum.DATA_EXIST);
        }
    }
    
    /**
    * <p>更新之前进行校验</p>
    *
    * @param sysParam sysParam
    * @author guocq
    * @since 2022-12-01 10:19:15
    */
    private void checkBeforePut(SysParam sysParam) {
        Long id = sysParam.getId();
        checkBeforeRemove(id);
        SysParamQueryDto uniqueParam = uniqueParamBuild(sysParam);
        long count = sysParamDao.list(uniqueParam).stream().filter(ele -> !Objects.equals(ele.getId(), id)).count();
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
    * @since 2022-12-01 10:19:15
    */
    private void checkBeforeRemove(Long id) {
        if (AbstractDataEntity.isEmpty(sysParamDao.findById(id))) {
            LOGGER.error("id={}的数据不存在", id);
            throw new CoreException(CoreRestEnum.DATA_NOT_EXIST);
        }
    }
 }
