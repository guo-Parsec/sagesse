package org.edu.sagesse.base.core.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDataDto;

import java.util.StringJoiner;

/**
 * <p>数据字典查询参数</p>
 *
 * @author guocq
 * @since 2022/11/29
 **/
@Setter
@Getter
public class SysDictQueryDto extends AbstractDataDto {
    private static final long serialVersionUID = -2262315980125219996L;

    public static final SysDictQueryDto EMPTY = Builder.builder(SysDictQueryDto::new).build();

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

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    public SysDictQueryDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDictQueryDto.class.getSimpleName() + "[", "]")
                .add("categoryCode='" + categoryCode + "'")
                .add("categoryName='" + categoryName + "'")
                .add("dictName='" + dictName + "'")
                .add("dictValue='" + dictValue + "'")
                .add("sort=" + sort)
                .add("id=" + id)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }
}
