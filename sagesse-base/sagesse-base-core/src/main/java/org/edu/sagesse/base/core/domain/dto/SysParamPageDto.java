package org.edu.sagesse.base.core.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.dto.PageableDto;

import java.util.StringJoiner;

/**
 * <p>系统参数表数据分页查询层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysParam
 * @see SysParamQueryDto
 * @since 2022-12-01 09:53:29
 */
@Setter
@Getter
public class SysParamPageDto extends SysParamQueryDto implements PageableDto {
    private static final long serialVersionUID = -28824946428514905L;

    public static final SysParamPageDto EMPTY = new SysParamPageDto();

    public SysParamPageDto() {
    }

    /**
     * 当前页
     */
    private Integer currPage;

    /**
     * 页大小
     */
    private Integer pageSize;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysParamPageDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("paramName=" + paramName)
                .add("paramCode=" + paramCode)
                .add("paramValue=" + paramValue)
                .add("dataStatusSet=" + dataStatusSet)
                .add("currPage=" + currPage)
                .add("pageSize=" + pageSize)
                .toString();
    }
}
