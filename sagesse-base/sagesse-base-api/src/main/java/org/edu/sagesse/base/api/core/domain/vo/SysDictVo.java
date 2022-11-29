package org.edu.sagesse.base.api.core.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.base.api.core.support.context.DictContext;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.vo.AbstractDataVo;
import org.edu.sagesse.data.base.support.pool.DictPool;

/**
 * <p>数据字典显示层数据</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
@Setter
@Getter
@ApiModel(value = "数据字典显示层数据")

public class SysDictVo extends AbstractDataVo {
    private static final long serialVersionUID = -8073697530324998937L;

    public static final SysDictVo EMPTY = Builder.builder(SysDictVo::new).build();

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

    public SysDictVo() {
    }

    /**
     * <p>数据状态字典显示名称getter方法</p>
     *
     * @return java.lang.String
     * @author hedwing
     * @since 2022/10/23
     */
    @Override
    public String getDataStatusName() {
        return DictContext.convert(DictPool.DICT_CATEGORY_DATA_STATUS, this.dataStatus);
    }

    @Override
    public String toString() {
        return "SysDictVo{" + "categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", dictName='" + dictName + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", sort=" + sort +
                ", dataStatus=" + dataStatus +
                ", dataStatusName='" + dataStatusName + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", id=" + id +
                '}';
    }
}
