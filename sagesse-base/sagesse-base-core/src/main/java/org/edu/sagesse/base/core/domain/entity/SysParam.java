package org.edu.sagesse.base.core.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.StringJoiner;

/**
 * 系统参数表(SysParam)实体类
 *
 * @author guocq
 * @since 2022-11-29 13:44:26
 */
@ApiModel(value = "系统参数表实体类")
@Setter
@Getter
public class SysParam extends AbstractDataEntity {
    private static final long serialVersionUID = 333127581773377747L;

    /**
     * 类别码
     */
    @ApiModelProperty(value = "类别码")
    private String categoryCode;

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String categoryName;

    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称")
    private String paramName;

    /**
     * 参数码
     */
    @ApiModelProperty(value = "参数码")
    private String paramCode;

    /**
     * 参数值
     */
    @ApiModelProperty(value = "参数值")
    private String paramValue;


    public SysParam() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParam.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode='" + categoryCode + "'")
                .add("categoryName='" + categoryName + "'")
                .add("paramName='" + paramName + "'")
                .add("paramCode='" + paramCode + "'")
                .add("paramValue='" + paramValue + "'")
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .add("id=" + id)
                .toString();
    }
}

