package org.edu.sagesse.base.core.domain.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDataDto;

import java.util.StringJoiner;

/**
 * 系统参数表(SysParam)更新参数
 *
 * @author guocq
 * @since 2022-11-29 17:26:43
 */
@ApiModel(value = "系统参数表更新参数")
@Setter
@Getter
public class SysParamPutDto extends AbstractDataDto {
    private static final long serialVersionUID = -79482401696100170L;

    public static final SysParamPutDto EMPTY = Builder.builder(SysParamPutDto::new).build();

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

    public SysParamPutDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParamPutDto.class.getSimpleName() + "[", "]")
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
