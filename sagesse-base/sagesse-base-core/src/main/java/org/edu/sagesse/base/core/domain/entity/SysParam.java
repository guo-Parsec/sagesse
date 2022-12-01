package org.edu.sagesse.base.core.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.StringJoiner;

/**
 * <p>系统参数表(sys_param)数据展示层实体信息</p>
 *
 * @author guocq
 * @since 2022-12-01 09:53:28
 */
@Setter
@Getter
public class SysParam extends AbstractDataEntity {
    private static final long serialVersionUID = 177594083931434802L;

    public static final SysParam EMPTY = new SysParam();

    public SysParam() {
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
     * 参数名称
     */
    private String paramName;

    /**
     * 参数码
     */
    private String paramCode;

    /**
     * 参数值
     */
    private String paramValue;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParam.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("paramName=" + paramName)
                .add("paramCode=" + paramCode)
                .add("paramValue=" + paramValue)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }
}
