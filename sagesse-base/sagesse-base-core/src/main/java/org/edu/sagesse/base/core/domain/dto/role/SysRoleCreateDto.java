package org.edu.sagesse.base.core.domain.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDataDto;

import java.util.StringJoiner;

/**
 * 系统角色表(SysRole)新增参数
 *
 * @author guocq
 * @since 2022-11-29 17:56:35
 */
@ApiModel(value = "系统角色表新增参数")
@Setter
@Getter
public class SysRoleCreateDto extends AbstractDataDto {
    private static final long serialVersionUID = -68854421213389056L;

    public static final SysRoleCreateDto EMPTY = Builder.builder(SysRoleCreateDto::new).build();

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

    public SysRoleCreateDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysRoleCreateDto.class.getSimpleName() + "[", "]")
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
