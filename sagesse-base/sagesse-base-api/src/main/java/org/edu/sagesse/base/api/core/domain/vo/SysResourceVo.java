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
 * 系统资源表(SysResource)实体类
 *
 * @author guocq
 * @since 2022-11-29 14:22:55
 */
@ApiModel(value = "系统资源表实体类")
@Setter
@Getter
public class SysResourceVo extends AbstractDataVo {
    private static final long serialVersionUID = -98981598203072388L;

    public static final SysResourceVo EMPTY = Builder.builder(SysResourceVo::new).build();

    /**
     * 分类码
     */
    @ApiModelProperty(value = "分类码")
    private String categoryCode;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    /**
     * 权限编码
     */
    @ApiModelProperty(value = "权限编码")
    private String resourceCode;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String resourceName;

    /**
     * 请求操作url
     */
    @ApiModelProperty(value = "请求操作url")
    private String requestActionUrl;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remark;

    /**
     * 数据状态
     */
    @ApiModelProperty(value = "数据状态")
    private Integer dataStatus;


    public SysResourceVo() {
    }

    /**
     * <p>数据状态字典显示名称getter方法</p>
     *
     * @return java.lang.String
     * @author guocq
     * @since 2022-11-29 14:22:55
     */
    @Override
    public String getDataStatusName() {
        return DictContext.convert(DictPool.DICT_CATEGORY_DATA_STATUS, this.dataStatus);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysResourceVo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("resourceCode=" + resourceCode)
                .add("resourceName=" + resourceName)
                .add("requestActionUrl=" + requestActionUrl)
                .add("sort=" + sort)
                .add("remark=" + remark)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }
}

