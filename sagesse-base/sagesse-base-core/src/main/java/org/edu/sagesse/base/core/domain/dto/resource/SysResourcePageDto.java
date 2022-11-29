package org.edu.sagesse.base.core.domain.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractPageDto;

import java.util.StringJoiner;

/**
 * 系统资源表(SysResource)分页参数
 *
 * @author guocq
 * @since 2022-11-29 17:54:48
 */
@ApiModel(value = "系统资源表分页参数")
@Setter
@Getter
public class SysResourcePageDto extends AbstractPageDto {
    private static final long serialVersionUID = 635133036831562301L;

    public static final SysResourcePageDto EMPTY = Builder.builder(SysResourcePageDto::new).build();

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

    public SysResourcePageDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysResourcePageDto.class.getSimpleName() + "[", "]")
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("resourceCode=" + resourceCode)
                .add("resourceName=" + resourceName)
                .add("requestActionUrl=" + requestActionUrl)
                .add("sort=" + sort)
                .add("remark=" + remark)
                .add("currPage=" + currPage)
                .add("pageSize=" + pageSize)
                .toString();
    }
}
