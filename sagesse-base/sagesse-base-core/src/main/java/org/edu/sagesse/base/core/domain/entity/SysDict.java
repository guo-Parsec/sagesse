package org.edu.sagesse.base.core.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.StringJoiner;

/**
 * <p>系统字典详情表</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@ApiModel(value = "系统字典详情表")
@Getter
@Setter
public class SysDict extends AbstractDataEntity {
    private static final long serialVersionUID = 634743428158958074L;

    public static final SysDict EMPTY = Builder.builder(SysDict::new).build();

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

    public SysDict() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDict.class.getSimpleName() + "[", "]")
                .add("categoryCode='" + categoryCode + "'")
                .add("categoryName='" + categoryName + "'")
                .add("dictName='" + dictName + "'")
                .add("dictValue='" + dictValue + "'")
                .add("sort=" + sort)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .add("id=" + id)
                .toString();
    }
}