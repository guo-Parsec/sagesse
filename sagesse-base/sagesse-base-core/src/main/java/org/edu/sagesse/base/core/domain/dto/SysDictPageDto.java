package org.edu.sagesse.base.core.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.dto.PageableDto;

import java.util.StringJoiner;

/**
 * <p>系统字典详情表数据分页查询层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysDict
 * @see SysDictQueryDto
 * @since 2022-12-01 10:30:07
 */
@Setter
@Getter
public class SysDictPageDto extends SysDictQueryDto implements PageableDto {
    private static final long serialVersionUID = 991958765842121531L;

    public static final SysDictPageDto EMPTY = new SysDictPageDto();

    public SysDictPageDto() {
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
        return new StringJoiner(", ", SysDictPageDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("dictName=" + dictName)
                .add("dictValue=" + dictValue)
                .add("currPage=" + currPage)
                .add("pageSize=" + pageSize)
                .toString();
    }
}
