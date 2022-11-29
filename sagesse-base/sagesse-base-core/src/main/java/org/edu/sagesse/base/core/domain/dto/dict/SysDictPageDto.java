package org.edu.sagesse.base.core.domain.dto.dict;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractPageDto;

import java.util.StringJoiner;

/**
 * <p>数据字典分页查询参数</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@Setter
@Getter
@ApiModel(value="数据字典分页查询参数")

public class SysDictPageDto extends AbstractPageDto {
    private static final long serialVersionUID = -8073697530324998937L;

    public static final SysDictPageDto EMPTY = Builder.builder(SysDictPageDto::new).build();
    /**
     * 类别码
     */
    @ApiModelProperty(value="类别码")
    private String categoryCode;

    /**
     * 类别名称
     */
    @ApiModelProperty(value="类别名称")
    private String categoryName;

    /**
     * 字典名称
     */
    @ApiModelProperty(value="字典名称")
    private String dictName;

    /**
     * 字典值
     */
    @ApiModelProperty(value="字典值")
    private String dictValue;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    public SysDictPageDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDictPageDto.class.getSimpleName() + "[", "]")
                .add("categoryCode='" + categoryCode + "'")
                .add("categoryName='" + categoryName + "'")
                .add("dictName='" + dictName + "'")
                .add("dictValue='" + dictValue + "'")
                .add("sort=" + sort)
                .add("currPage=" + currPage)
                .add("pageSize=" + pageSize)
                .toString();
    }
}
