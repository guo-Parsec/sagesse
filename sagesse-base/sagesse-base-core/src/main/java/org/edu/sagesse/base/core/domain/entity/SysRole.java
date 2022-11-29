package org.edu.sagesse.base.core.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.util.StringJoiner;

/**
 * 系统角色表(SysRole)实体类
 *
 * @author guocq
 * @since 2022-11-29 14:28:09
 */
@ApiModel(value = "系统角色表实体类")
@Setter
@Getter
public class SysRole extends AbstractDataEntity {
    private static final long serialVersionUID = 188012016228639343L;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

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


    public SysRole() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysRole.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("roleCode=" + roleCode)
                .add("roleName=" + roleName)
                .add("sort=" + sort)
                .add("remark=" + remark)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }

}

