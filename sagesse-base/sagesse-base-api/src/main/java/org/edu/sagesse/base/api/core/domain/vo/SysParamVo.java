package org.edu.sagesse.base.api.core.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.base.api.core.support.context.DictContext;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.vo.AbstractDataVo;
import org.edu.sagesse.data.base.support.pool.DictPool;

import java.util.StringJoiner;

/**
 * 系统参数表(SysParam)数据展示层
 *
 * @author guocq
 * @since 2022-11-29 13:44:26
 */
@ApiModel(value = "系统参数表数据展示层")
@Setter
@Getter
public class SysParamVo extends AbstractDataVo {
    private static final long serialVersionUID = -34492190819077504L;

    public static final SysParamVo EMPTY = Builder.builder(SysParamVo::new).build();

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


    public SysParamVo() {
    }

    /**
     * <p>数据状态字典显示名称getter方法</p>
     *
     * @return java.lang.String
     * @author guocq
     * @since 2022-11-29 13:44:26
     */
    @Override
    public String getDataStatusName() {
        return DictContext.convert(DictPool.DICT_CATEGORY_DATA_STATUS, this.dataStatus);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParamVo.class.getSimpleName() + "[", "]")
                .add("categoryCode='" + categoryCode + "'")
                .add("categoryName='" + categoryName + "'")
                .add("paramName='" + paramName + "'")
                .add("paramCode='" + paramCode + "'")
                .add("paramValue='" + paramValue + "'")
                .add("dataStatus=" + dataStatus)
                .add("dataStatusName='" + dataStatusName + "'")
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .add("id=" + id)
                .toString();
    }
}

