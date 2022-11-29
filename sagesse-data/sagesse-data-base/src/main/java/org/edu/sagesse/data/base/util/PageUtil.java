package org.edu.sagesse.data.base.util;

import com.github.pagehelper.PageInfo;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.domain.vo.AbstractVo;

import java.util.List;

/**
 * <p>分页工具类</p>
 *
 * @author guocq
 * @since 2022/11/29
 **/
public class PageUtil {
    /**
     * <p>pageInfo构建工具类</p>
     *
     * @param data      原始list
     * @param ePageInfo 分页数据
     * @return com.github.pagehelper.PageInfo<V>
     * @author guocq
     * @date 2022/11/29 18:16
     */
    public static <V extends AbstractVo, E extends AbstractDataEntity> PageInfo<V> toPageInfo(List<V> data, PageInfo<E> ePageInfo) {
        PageInfo<V> pageInfo = PageInfo.emptyPageInfo();
        pageInfo.setPages(ePageInfo.getPages());
        pageInfo.setList(data);
        pageInfo.setPageSize(ePageInfo.getPageSize());
        pageInfo.setPageNum(ePageInfo.getPageNum());
        pageInfo.setTotal(ePageInfo.getTotal());
        pageInfo.setSize(ePageInfo.getSize());
        pageInfo.setStartRow(ePageInfo.getStartRow());
        pageInfo.setEndRow(ePageInfo.getEndRow());
        pageInfo.setPages(ePageInfo.getPages());
        pageInfo.setPrePage(ePageInfo.getPrePage());
        pageInfo.setNextPage(ePageInfo.getNextPage());
        pageInfo.setIsFirstPage(ePageInfo.isIsFirstPage());
        pageInfo.setIsLastPage(ePageInfo.isIsLastPage());
        pageInfo.setHasNextPage(ePageInfo.isHasNextPage());
        pageInfo.setHasPreviousPage(ePageInfo.isHasPreviousPage());
        pageInfo.setNavigatePages(ePageInfo.getNavigatePages());
        pageInfo.setNavigatepageNums(ePageInfo.getNavigatepageNums());
        pageInfo.setNavigateFirstPage(ePageInfo.getNavigateFirstPage());
        pageInfo.setNavigateLastPage(ePageInfo.getNavigateLastPage());
        return pageInfo;
    }
}
