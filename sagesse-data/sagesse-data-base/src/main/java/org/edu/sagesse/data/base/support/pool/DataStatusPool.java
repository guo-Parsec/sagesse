package org.edu.sagesse.data.base.support.pool;

import org.edu.sagesse.data.base.support.enums.DataStatus;

/**
 * <p>数据状态常量池</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
public interface DataStatusPool {
    Integer ENABLE = DataStatus.ENABLE.value();

    Integer DISABLE = DataStatus.DISABLE.value();

    Integer DELETE = DataStatus.DELETE.value();
}
