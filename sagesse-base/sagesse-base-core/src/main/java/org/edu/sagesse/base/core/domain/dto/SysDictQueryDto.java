package org.edu.sagesse.base.core.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;

import java.util.Set;
import java.util.StringJoiner;

/**
 * <p>系统字典详情表数据查询层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysDict
 * @since 2022-12-01 10:30:07
 */
@Setter
@Getter
public class SysDictQueryDto extends AbstractDto {
    private static final long serialVersionUID = 487799391735991726L;

    public static final SysDictQueryDto EMPTY = new SysDictQueryDto();

    public SysDictQueryDto() {
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
     * 字典名称
     */
    protected String dictName;
    /**
     * 字典值
     */
    protected String dictValue;
    /**
     * 数据状态
     */
    protected Set<Integer> dataStatusSet;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDictQueryDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("dictName=" + dictName)
                .add("dictValue=" + dictValue)
                .toString();
    }
}
