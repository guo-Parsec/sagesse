package org.edu.sagesse.generate.domain.dto;

import com.google.common.collect.Maps;
import org.edu.sagesse.generate.domain.entity.ColumnInfo;
import org.edu.sagesse.generate.domain.entity.ITypeMapping;
import org.edu.sagesse.generate.support.enums.DefaultTypeMapping;

import java.util.Map;

/**
 * <p>字段配置传输层</p>
 *
 * @author guocq
 * @since 2022/11/30
 **/
public class ColumnConfigDto {
    private ColumnInfo columnInfo;

    private ITypeMapping typeMapping;

    private Map<String, Object> ext;

    public ColumnConfigDto() {
    }

    public ColumnConfigDto(ColumnInfo columnInfo, ITypeMapping typeMapping) {
        this.columnInfo = columnInfo;
        this.typeMapping = typeMapping;
    }

    public ColumnConfigDto(ColumnInfo columnInfo, ITypeMapping typeMapping, Map<String, Object> ext) {
        this.columnInfo = columnInfo;
        this.typeMapping = typeMapping;
        this.ext = ext;
    }

    public static ColumnConfigDto buildDto(ColumnInfo columnInfo) {
        String type = columnInfo.getType();
        DefaultTypeMapping defaultTypeMapping = DefaultTypeMapping.find(type);
        return new ColumnConfigDto(columnInfo, defaultTypeMapping, Maps.newHashMap());
    }
}
