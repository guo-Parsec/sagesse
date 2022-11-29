package org.edu.sagesse.base.core.domain.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractPageDto;

import java.util.StringJoiner;

/**
 * 系统菜单表(SysMenu)分页参数
 *
 * @author guocq
 * @since 2022-11-29 17:48:47
 */
@ApiModel(value = "系统菜单表分页参数")
@Setter
@Getter
public class SysMenuPageDto extends AbstractPageDto {
    private static final long serialVersionUID = 958171171726428612L;

    public static final SysMenuPageDto EMPTY = Builder.builder(SysMenuPageDto::new).build();

    /**
     * 上级菜单id
     */
    @ApiModelProperty(value = "上级菜单id")
    private Long parentId;

    /**
     * 层级路径
     */
    @ApiModelProperty(value = "层级路径")
    private String hierarchicalPath;

    /**
     * 菜单标识
     */
    @ApiModelProperty(value = "菜单标识")
    private String menuCode;

    /**
     * 菜单标题
     */
    @ApiModelProperty(value = "菜单标题")
    private String menuTitle;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String menuIcon;

    /**
     * 显示状态(数据字典 0-显示 1-隐藏)
     */
    @ApiModelProperty(value = "显示状态(数据字典 0-显示 1-隐藏)")
    private Integer visibleStatus;

    /**
     * 菜单级别
     */
    @ApiModelProperty(value = "菜单级别")
    private Integer menuLevel;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 前端组件
     */
    @ApiModelProperty(value = "前端组件")
    private String component;

    /**
     * 菜单访问url
     */
    @ApiModelProperty(value = "菜单访问url")
    private String menuUrl;

    /**
     * 菜单描述
     */
    @ApiModelProperty(value = "菜单描述")
    private String remark;

    public SysMenuPageDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysMenuPageDto.class.getSimpleName() + "[", "]")
                .add("parentId=" + parentId)
                .add("hierarchicalPath=" + hierarchicalPath)
                .add("menuCode=" + menuCode)
                .add("menuTitle=" + menuTitle)
                .add("menuIcon=" + menuIcon)
                .add("visibleStatus=" + visibleStatus)
                .add("menuLevel=" + menuLevel)
                .add("sort=" + sort)
                .add("component=" + component)
                .add("menuUrl=" + menuUrl)
                .add("remark=" + remark)
                .toString();
    }
}
