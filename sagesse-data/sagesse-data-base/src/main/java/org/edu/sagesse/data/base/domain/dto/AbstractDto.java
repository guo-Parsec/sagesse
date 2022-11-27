package org.edu.sagesse.data.base.domain.dto;

import org.edu.sagesse.common.domain.Domainizable;
import org.edu.sagesse.data.base.domain.entity.AbstractEntity;

/**
 * <p>基础参数实体类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
public abstract class AbstractDto<E extends AbstractEntity> implements Domainizable {
    private static final long serialVersionUID = -1266121148197610437L;

    /**
     * <p>转化为entity</p>
     *
     * @return E
     * @author hedwing
     * @since 2022/11/26
     */
    public abstract E toEntity();

    public AbstractDto() {
    }
}
