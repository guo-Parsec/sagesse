package org.edu.sagesse.base.core.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;

import java.util.StringJoiner;

/**
 * <p>系统参数表数据展示层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysParam
 * @since 2022-12-01 09:53:29
 */
@Setter
@Getter
public class SysParamCreateDto extends AbstractDto {
    private static final long serialVersionUID = 593868901751905532L;

    public static final SysParamCreateDto EMPTY = new SysParamCreateDto();

    public SysParamCreateDto() {
    }

    /**
     * 类别码
     */
    private String categoryCode;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 参数码
     */
    private String paramCode;

    /**
     * 参数值
     */
    private String paramValue;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParamCreateDto.class.getSimpleName() + "[", "]")
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("paramName=" + paramName)
                .add("paramCode=" + paramCode)
                .add("paramValue=" + paramValue)
                .toString();
    }
}
