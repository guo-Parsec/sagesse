package org.edu.sagesse.base.core.domain.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDataDto;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 系统用户表(SysUser)查询参数
 *
 * @author guocq
 * @since 2022-11-29 17:56:44
 */
@ApiModel(value = "系统用户表查询参数")
@Setter
@Getter
public class SysUserQueryDto extends AbstractDataDto {
    private static final long serialVersionUID = -48706522624153454L;

    public static final SysUserQueryDto EMPTY = Builder.builder(SysUserQueryDto::new).build();

    /**
     * 账户信息
     */
    @ApiModelProperty(value = "账户信息")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer sex;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String avatarUrl;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private Integer userType;

    public SysUserQueryDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysUserQueryDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("account=" + account)
                .add("password=" + password)
                .add("nickname=" + nickname)
                .add("sex=" + sex)
                .add("avatarUrl=" + avatarUrl)
                .add("birthday=" + birthday)
                .add("userType=" + userType)
                .add("dataStatus=" + dataStatus)
                .add("gmtCreate=" + gmtCreate)
                .add("gmtModify=" + gmtModify)
                .toString();
    }
}
