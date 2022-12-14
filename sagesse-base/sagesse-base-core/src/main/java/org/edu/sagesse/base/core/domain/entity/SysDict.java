package org.edu.sagesse.base.core.domain.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.StringJoiner;

/**
 * <p>系统字典详情表(sys_dict)数据展示层实体信息</p>
 *
 * @author guocq
 * @since 2022-12-01 10:29:45
 */
@Setter
@Getter
public class SysDict extends AbstractDataEntity {
    private static final long serialVersionUID = -21152201998372737L;

    public static final SysDict EMPTY = new SysDict();

    public SysDict() {
    }

    /**
     * 类别码
     */
    private String categoryCode;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 排序
     */
    private Integer sort;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDict.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("dictName=" + dictName)
                .add("dictValue=" + dictValue)
                .add("sort=" + sort)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }
}
