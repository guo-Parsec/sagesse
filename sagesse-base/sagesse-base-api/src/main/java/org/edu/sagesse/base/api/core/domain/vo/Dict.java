package org.edu.sagesse.base.api.core.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.domain.Domainizable;
import org.edu.sagesse.common.support.helper.Builder;

/**
 * <p>数据字典转换使用</p>
 *
 * @author guocq
 * @since 2022/11/29
 **/
@Getter
@Setter
@ApiModel(value = "数据字典转换使用")
public class Dict implements Domainizable {
    private static final long serialVersionUID = -4106612102997060201L;

    public static final Dict EMPTY = Builder.builder(Dict::new).build();

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
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    private String dictName;

    /**
     * 字典值
     */
    @ApiModelProperty(value = "字典值")
    private String dictValue;

    @Override
    public String toString() {
        return "DictVo{" + "dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                '}';
    }
}
