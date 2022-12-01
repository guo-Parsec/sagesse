package org.edu.sagesse.base.core.service;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.base.core.domain.dto.SysParamCreateDto;
import org.edu.sagesse.base.core.domain.dto.SysParamPageDto;
import org.edu.sagesse.base.core.domain.dto.SysParamPutDto;
import org.edu.sagesse.base.core.domain.dto.SysParamQueryDto;
import org.edu.sagesse.base.core.domain.vo.SysParamVo;

import java.util.List;
import java.util.Set;

/**
* 系统参数表业务类接口
*
* @author guocq
* @since 2022-12-01 10:07:46
*/
public interface SysParamService {
   /**
    * <p>根据主键查询单条数据</p>
    *
    * @param id 主键
    * @return {@link SysParamVo}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    SysParamVo find(Long id);
    
   /**
    * <p>根据参数查询单条数据</p>
    *
    * @param dto 参数
    * @return {@link SysParamVo}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    SysParamVo find(SysParamQueryDto dto);
    
   /**
    * <p>根据参数查询数据列表</p>
    *
    * @param dto 参数
    * @return {@link List<SysParamVo>}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    List<SysParamVo> list(SysParamQueryDto dto);
    
   /**
    * <p>根据参数分页查询数据列表</p>
    *
    * @param dto 分页参数
    * @return {@link List<SysParamVo>}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    PageInfo<SysParamVo> page(SysParamPageDto dto);
    
   /**
    * <p>根据参数新增数据</p>
    *
    * @param dto 参数
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    boolean create(SysParamCreateDto dto);
    
   /**
    * <p>根据参数批量新增数据</p>
    *
    * @param list 参数列表
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    boolean create(List<SysParamCreateDto> list);
    
   /**
    * <p>根据参数修改数据</p>
    *
    * @param dto 参数
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    boolean put(SysParamPutDto dto);
    
   /**
    * <p>根据主键和是否逻辑删除条件删除数据</p>
    *
    * @param id 主键
    * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    boolean remove(Long id, boolean isLogic);
    
    /**
    * <p>根据主键列表和是否逻辑删除条件删除数据</p>
    *
    * @param idSet 主键列表
    * @param isLogic 是否为逻辑删除 true:逻辑删除 false:物理删除
    * @return {@link boolean}
    * @author guocq
    * @since 2022-12-01 10:07:46
    */
    boolean remove(Set<Long> idSet, boolean isLogic);
 }
