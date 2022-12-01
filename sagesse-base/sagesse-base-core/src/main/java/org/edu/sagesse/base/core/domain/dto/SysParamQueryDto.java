package org.edu.sagesse.base.core.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;

import java.util.Set;
import java.util.StringJoiner;

/**
 * <p>系统参数表数据查询层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysParam
 * @since 2022-12-01 10:00:22
 */
@Setter
@Getter
public class SysParamQueryDto extends AbstractDto {
    private static final long serialVersionUID = -19297423817869787L;

    public static final SysParamQueryDto EMPTY = new SysParamQueryDto();

    public SysParamQueryDto() {
    }

    /**
     * 主键
     */
    protected Long id;
    /**
     * 类别码
     */
    protected String categoryCode;
    /**
     * 类别名称
     */
    protected String categoryName;
    /**
     * 参数名称
     */
    protected String paramName;
    /**
     * 参数码
     */
    protected String paramCode;
    /**
     * 参数值
     */
    protected String paramValue;
    /**
     * 数据状态
     */
    protected Set<Integer> dataStatusSet;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParamQueryDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("paramName=" + paramName)
                .add("paramCode=" + paramCode)
                .add("paramValue=" + paramValue)
                .add("dataStatusSet=" + dataStatusSet)
                .toString();
    }
}
