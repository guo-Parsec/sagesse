package org.edu.sagesse.base.core.domain.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDataDto;

import java.util.StringJoiner;

/**
 * 系统资源表(SysResource)更新参数
 *
 * @author guocq
 * @since 2022-11-29 17:54:48
 */
@ApiModel(value = "系统资源表更新参数")
@Setter
@Getter
public class SysResourcePutDto extends AbstractDataDto {
    private static final long serialVersionUID = 657210590258345332L;

    public static final SysResourcePutDto EMPTY = Builder.builder(SysResourcePutDto::new).build();

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

    public SysResourcePutDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysResourcePutDto.class.getSimpleName() + "[", "]")
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
