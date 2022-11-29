package org.edu.sagesse.base.core.domain.dto.operate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.common.support.helper.Builder;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;

import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 操作历史记录表(SysHiOperate)新增参数
 *
 * @author guocq
 * @since 2022-11-29 17:46:36
 */
@ApiModel(value = "操作历史记录表新增参数")
@Setter
@Getter
public class SysHiOperateCreateDto extends AbstractDto {
    private static final long serialVersionUID = 768778238721387091L;
    
    public static final SysHiOperateCreateDto EMPTY = Builder.builder(SysHiOperateCreateDto::new).build();
        
    /**
     * 主键
     */     
    @ApiModelProperty(value = "主键")
    private Long id;
        
    /**
     * 访问路径
     */     
    @ApiModelProperty(value = "访问路径")
    private String accessUrl;
        
    /**
     * 访问应用
     */     
    @ApiModelProperty(value = "访问应用")
    private String accessServer;
        
    /**
     * 操作人id
     */     
    @ApiModelProperty(value = "操作人id")
    private Long operateUserId;
        
    /**
     * 操作用户账户
     */     
    @ApiModelProperty(value = "操作用户账户")
    private String operateUserAccount;
        
    /**
     * 耗时时间(ms)
     */     
    @ApiModelProperty(value = "耗时时间(ms)")
    private Long timeConsuming;
        
    /**
     * 访问类型
     */     
    @ApiModelProperty(value = "访问类型")
    private Integer accessType;
        
    /**
     * 请求参数
     */     
    @ApiModelProperty(value = "请求参数")
    private String requestParam;
        
    /**
     * 请求结果
     */     
    @ApiModelProperty(value = "请求结果")
    private String requestResult;
        
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
     * 访问结果
     */     
    @ApiModelProperty(value = "访问结果")
    private Integer accessResult;
        
    /**
     * 备注
     */     
    @ApiModelProperty(value = "备注")
    private String remark;
        
    /**
     * 添加时间
     */     
    @ApiModelProperty(value = "添加时间")
    private LocalDateTime gmtCreate;
    
    public SysHiOperateCreateDto() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysHiOperateCreateDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("accessUrl=" + accessUrl)
                .add("accessServer=" + accessServer)
                .add("operateUserId=" + operateUserId)
                .add("operateUserAccount=" + operateUserAccount)
                .add("timeConsuming=" + timeConsuming)
                .add("accessType=" + accessType)
                .add("requestParam=" + requestParam)
                .add("requestResult=" + requestResult)
                .add("errorCode=" + errorCode)
                .add("errorMessage=" + errorMessage)
                .add("accessResult=" + accessResult)
                .add("remark=" + remark)
                .add("gmtCreate=" + gmtCreate)
                .toString();
    }
}
