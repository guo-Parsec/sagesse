package org.edu.sagesse.base.core.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.edu.sagesse.data.base.domain.dto.AbstractDto;

import java.util.StringJoiner;

/**
 * <p>系统字典详情表数据展示层实体信息</p>
 *
 * @author guocq
 * @see org.edu.sagesse.base.core.domain.entity.SysDict
 * @since 2022-12-01 10:30:07
 */
@Setter
@Getter
public class SysDictCreateDto extends AbstractDto {
    private static final long serialVersionUID = -75616375900879020L;

    public static final SysDictCreateDto EMPTY = new SysDictCreateDto();

    public SysDictCreateDto() {
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
     * 字典名称
     */
    private String dictName;

    /**
     * 字典值
     */
    private String dictValue;

    /**
     * 排序
     */
    private Integer sort;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDictCreateDto.class.getSimpleName() + "[", "]")
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("dictName=" + dictName)
                .add("dictValue=" + dictValue)
                .add("sort=" + sort)
                .toString();
    }
}
