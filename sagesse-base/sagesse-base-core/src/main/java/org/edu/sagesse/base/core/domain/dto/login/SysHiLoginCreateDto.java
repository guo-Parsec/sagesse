package org.edu.sagesse.base.core.domain.dto.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 登录历史记录表(SysHiLogin)新增参数
 *
 * @author guocq
 * @since 2022-11-29 17:45:08
 */
@ApiModel(value = "登录历史记录表新增参数")
@Setter
@Getter
public class SysHiLoginCreateDto extends AbstractDto {
    private static final long serialVersionUID = -43336551842664601L;
    
    public static final SysHiLoginCreateDto EMPTY = Builder.builder(SysHiLoginCreateDto::new).build();
        
    /**
     * 主键
     */     
    @ApiModelProperty(value = "主键")
    private Long id;
        
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
    private LocalDateTime gmtCreate;
    
    public SysHiLoginCreateDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysHiLoginCreateDto.class.getSimpleName() + "[", "]")
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
