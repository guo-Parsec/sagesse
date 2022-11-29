package org.edu.sagesse.data.base.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>数据分页查询参数</p>
 *
 * @author guocq
 */
@Setter
@Getter
public abstract class AbstractPageDto extends AbstractDto {
    private static final long serialVersionUID = -6661248706029458282L;

    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    @Min(value = 0, message = "当前页不能小于0")
    @ApiModelProperty(value = "当前页")
    protected Integer currPage;

    /**
     * 页大小
     */
    @NotNull(message = "页大小不能为空")
    @Min(value = 0, message = "页大小不能小于0")
    @ApiModelProperty(value = "页大小")
    protected Integer pageSize;
}
