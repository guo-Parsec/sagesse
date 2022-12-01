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
public class SysDictPutDto extends AbstractDto {
    private static final long serialVersionUID = -28450405810109633L;

    public static final SysDictPutDto EMPTY = new SysDictPutDto();

    public SysDictPutDto() {
    }

    /**
     * 主键
     */
    private Long id;

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

    /**
     * 数据状态
     */
    private Integer dataStatus;

    @Override
    public String toString() {
        return new StringJoiner(", ", SysDictPutDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("categoryCode=" + categoryCode)
                .add("categoryName=" + categoryName)
                .add("dictName=" + dictName)
                .add("dictValue=" + dictValue)
                .add("sort=" + sort)
                .add("dataStatus=" + dataStatus)
                .toString();
    }
}
