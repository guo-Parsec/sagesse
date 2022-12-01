package org.edu.sagesse.base.core.domain.vo;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.vo.AbstractDataVo;

import java.util.StringJoiner;

/**
 * <p>系统字典详情表数据展示层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysDict
 * @since 2022-12-01 10:29:53
 */
@Setter
@Getter
public class SysDictVo extends AbstractDataVo {
    private static final long serialVersionUID = -80761627115674031L;

    public static final SysDictVo EMPTY = new SysDictVo();

    public SysDictVo() {
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
        return new StringJoiner(", ", SysDictVo.class.getSimpleName() + "[", "]")
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
