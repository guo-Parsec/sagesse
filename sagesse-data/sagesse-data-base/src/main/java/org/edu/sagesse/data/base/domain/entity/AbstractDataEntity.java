package org.edu.sagesse.data.base.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.vo.AbstractVo;
import org.edu.sagesse.data.base.support.enums.DataStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * <p>数据实体抽象类</p>
 *
 * @author hedwing
 * @since 2022/11/26
 **/
@Setter
@Getter
public abstract class AbstractDataEntity extends AbstractEntity {
    private static final long serialVersionUID = -2490534118894809930L;

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

    public AbstractDataEntity() {
        super();
    }

    public AbstractDataEntity(Long id) {
        super(id);
    }

    /**
     * <p>数据展示层转换</p>
     *
     * @return {@link AbstractVo}
     * @author hedwing
     * @since 2022/10/22
     */
    public abstract AbstractVo toVo();

    /**
     * 初始化
     */
    public void init() {
        this.dataStatus = DataStatus.ENABLE.value();
        this.gmtCreate = LocalDateTime.now();
        this.gmtModify = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AbstractDataEntity that = (AbstractDataEntity) o;
        return Objects.equals(dataStatus, that.dataStatus) && Objects.equals(gmtModify, that.gmtModify) && Objects.equals(gmtCreate, that.gmtCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataStatus, gmtModify, gmtCreate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AbstractDataEntity.class.getSimpleName() + "[", "]")
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .add("id=" + id)
                .toString();
    }

    @Override
    public AbstractDataEntity clone() {
        return (AbstractDataEntity) super.clone();
    }
}
