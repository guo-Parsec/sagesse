package org.edu.sagesse.base.api.core.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.vo.AbstractVo;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 登录历史记录表(SysHiLogin)实体类
 *
 * @author guocq
 * @since 2022-11-29 14:11:54
 */
@ApiModel(value = "登录历史记录表实体类")
@Setter
@Getter
public class SysHiLoginVo extends AbstractVo {
    private static final long serialVersionUID = -96281404139882175L;

    public static final SysHiLoginVo EMPTY = Builder.builder(SysHiLoginVo::new).build();
    /**
     * 登录ip
     */
    @ApiModelProperty(value = "登录ip")
    private String loginIp;

    /**
     * 登录账户
     */
    @ApiModelProperty(value = "登录账户")
    private String loginAccount;

    /**
     * 登录设备
     */
    @ApiModelProperty(value = "登录设备")
    private String loginEquipment;

    /**
     * 耗时时间(ms)
     */
    @ApiModelProperty(value = "耗时时间(ms)")
    private Long timeConsuming;

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private Integer errorCode;

    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息")
    private String errorMessage;

    /**
     * 登录是否成功 0-成功 1-失败
     */
    @ApiModelProperty(value = "登录是否成功 0-成功 1-失败")
    private Integer loginResult;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime gmtCreate;


    public SysHiLoginVo() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysHiLoginVo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("loginIp=" + loginIp)
                .add("loginAccount=" + loginAccount)
                .add("loginEquipment=" + loginEquipment)
                .add("timeConsuming=" + timeConsuming)
                .add("errorCode=" + errorCode)
                .add("errorMessage=" + errorMessage)
                .add("loginResult=" + loginResult)
                .add("gmtCreate=" + gmtCreate)
                .toString();
    }
}

