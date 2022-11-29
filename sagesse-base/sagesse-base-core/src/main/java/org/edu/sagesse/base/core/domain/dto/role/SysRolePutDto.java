package org.edu.sagesse.base.core.domain.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDataDto;

import java.util.StringJoiner;

/**
 * 系统角色表(SysRole)更新参数
 *
 * @author guocq
 * @since 2022-11-29 17:56:35
 */
@ApiModel(value = "系统角色表更新参数")
@Setter
@Getter
public class SysRolePutDto extends AbstractDataDto {
    private static final long serialVersionUID = 820493447344086877L;

    public static final SysRolePutDto EMPTY = Builder.builder(SysRolePutDto::new).build();

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

    public SysRolePutDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysRolePutDto.class.getSimpleName() + "[", "]")
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
