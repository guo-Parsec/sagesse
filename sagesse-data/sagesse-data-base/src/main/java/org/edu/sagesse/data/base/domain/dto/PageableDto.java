package org.edu.sagesse.data.base.domain.dto;

import org.edu.sagesse.common.domain.Domainizable;

/**
 * <p>可分页参数</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
public interface PageableDto extends Domainizable {
    /**
     * <p>获取页大小</p>
     *
     * @return java.lang.Integer
     * @author guocq
     * @date 2022/11/30 15:06
     */
    Integer getPageSize();

    /**
     * <p>获取当前页</p>
     *
     * @return java.lang.Integer
     * @author guocq
     * @date 2022/11/30 15:06
     */
    Integer getCurrPage();
}
