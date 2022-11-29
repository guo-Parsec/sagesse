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
 * 系统角色表(SysRole)实体类
 *
 * @author guocq
 * @since 2022-11-29 14:28:09
 */
@ApiModel(value = "系统角色表实体类")
@Setter
@Getter
public class SysRoleVo extends AbstractDataVo {
    private static final long serialVersionUID = -30225778215925154L;

    public static final SysRoleVo EMPTY = Builder.builder(SysRoleVo::new).build();

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

    public SysRoleVo() {
    }

    /**
     * <p>数据状态字典显示名称getter方法</p>
     *
     * @return java.lang.String
     * @author guocq
     * @since 2022-11-29 14:28:09
     */
    @Override
    public String getDataStatusName() {
        return DictContext.convert(DictPool.DICT_CATEGORY_DATA_STATUS, this.dataStatus);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysRoleVo.class.getSimpleName() + "[", "]")
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

