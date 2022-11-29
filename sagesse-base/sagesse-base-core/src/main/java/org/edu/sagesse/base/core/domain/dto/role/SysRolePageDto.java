package org.edu.sagesse.base.core.domain.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractPageDto;

import java.util.StringJoiner;

/**
 * 系统角色表(SysRole)分页参数
 *
 * @author guocq
 * @since 2022-11-29 17:56:35
 */
@ApiModel(value = "系统角色表分页参数")
@Setter
@Getter
public class SysRolePageDto extends AbstractPageDto {
    private static final long serialVersionUID = -53205198587203044L;

    public static final SysRolePageDto EMPTY = Builder.builder(SysRolePageDto::new).build();

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

    public SysRolePageDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysRolePageDto.class.getSimpleName() + "[", "]")
                .add("roleCode=" + roleCode)
                .add("roleName=" + roleName)
                .add("sort=" + sort)
                .add("remark=" + remark)
                .add("currPage=" + currPage)
                .add("pageSize=" + pageSize)
                .toString();
    }
}
