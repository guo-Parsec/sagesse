package org.edu.sagesse.data.base.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;
import org.edu.sagesse.data.base.support.enums.DataStatus;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * <p>基础参数数据实体类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@Getter
@Setter
public abstract class AbstractDataDto<E extends AbstractDataEntity> extends AbstractDto<E> {
    private static final long serialVersionUID = 8089201551307840499L;

    /**
     * 主键
     */
    protected Long id;

    /**
     * 数据状态
     */
    protected Integer dataStatus;

    /**
     * 创建时间
     */
    protected LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    protected LocalDateTime gmtModify;

    public AbstractDataDto() {
        super();
    }

    public AbstractDataDto(Long id) {
        this.id = id;
    }

    /**
     * 初始化
     */
    public void init() {
        this.dataStatus = DataStatus.ENABLE.value();
        this.gmtCreate = LocalDateTime.now();
        this.gmtModify = LocalDateTime.now();
    }

    /**
     * <p>转化为entity</p>
     *
     * @return E
     * @author hedwing
     * @since 2022/11/26
     */
    @Override
    public E toEntity() {
        return null;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AbstractDataDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }
}
