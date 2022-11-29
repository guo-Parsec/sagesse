package org.edu.sagesse.base.core.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.entity.AbstractDataEntity;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * 系统用户表(SysUser)实体类
 *
 * @author guocq
 * @since 2022-11-29 13:55:01
 */
@ApiModel(value = "系统用户表实体类")
@Setter
@Getter
public class SysUser extends AbstractDataEntity {
    private static final long serialVersionUID = -80090163618689183L;
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


    public SysUser() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysUser.class.getSimpleName() + "[", "]")
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

