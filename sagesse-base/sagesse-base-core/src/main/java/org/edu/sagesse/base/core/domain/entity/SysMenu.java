package org.edu.sagesse.base.core.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.StringJoiner;

/**
 * 系统菜单表(SysMenu)实体类
 *
 * @author guocq
 * @since 2022-11-29 14:31:34
 */
@ApiModel(value = "系统菜单表实体类")
@Setter
@Getter
public class SysMenu extends AbstractDataEntity {
    private static final long serialVersionUID = 527902872580510570L;
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

    public SysMenu() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysMenu.class.getSimpleName() + "[", "]")
                .add("id=" + id)
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
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }

}

