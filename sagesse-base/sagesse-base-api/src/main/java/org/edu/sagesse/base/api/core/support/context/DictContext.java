package org.edu.sagesse.base.api.core.support.context;

import com.google.common.collect.Maps;
import org.edu.sagesse.base.api.core.domain.vo.Dict;
import org.edu.sagesse.base.api.core.feign.SysDictFeign;
import org.edu.sagesse.common.support.helper.SpringBeanHelper;
import org.edu.sagesse.common.support.logger.SaLogger;
import org.edu.sagesse.common.support.logger.SaLoggerFactory;
import org.edu.sagesse.common.support.rest.Carrier;
import org.edu.sagesse.common.util.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>数据字典上下文</p>
 *
 * @author guocq
 * @since 2022/11/28
 **/
public class DictContext {
    private static final SaLogger LOGGER = SaLoggerFactory.getLogger(DictContext.class);

    private static final Map<String, List<Dict>> CATEGORY_DICT_MAPPING = Maps.newHashMapWithExpectedSize(16);

    /**
     * <p>字典转换</p>
     *
     * @param categoryCode 类别码
     * @param dictValue    字典值
     * @return java.lang.String
     * @author guocq
     * @date 2022/11/28 17:43
     */
    public static String convert(String categoryCode, Integer dictValue) {
        return convert(categoryCode, StringUtil.toString(dictValue));
    }

    /**
     * <p>字典转换</p>
     *
     * @param categoryCode 类别码
     * @param dictValue    字典值
     * @return {@link String}
     * @author hedwing
     * @since 2022/11/28
     */
    public static String convert(String categoryCode, String dictValue) {
        if (StringUtil.isBlank(categoryCode) || StringUtil.isBlank(dictValue)) {
            LOGGER.error("categoryCode与dictValue不能为空");
            return null;
        }
        List<Dict> dictList = CATEGORY_DICT_MAPPING.get(categoryCode);
        if (dictList == null) {
            SysDictFeign dictFeign = SpringBeanHelper.getBean(SysDictFeign.class);
            Carrier<List<Dict>> carrier = dictFeign.findDictName(categoryCode);
            dictList = Carrier.getSuccessData(carrier);
            CATEGORY_DICT_MAPPING.put(categoryCode, dictList);
        }
        return dictList.stream()
                .filter(dict -> Objects.equals(dictValue, dict.getDictValue()))
                .findFirst()
                .map(Dict::getDictName)
                .orElse(StringUtil.EMPTY);
    }

    /**
     * <p>清除指定字典类别缓存</p>
     *
     * @param category 类别码
     * @author guocq
     * @date 2022/11/29 9:45
     */
    public static void clear(String category) {
        if (StringUtil.isBlank(category)) {
            LOGGER.warn("category={}不能为空", category);
            return;
        }
        if (!CATEGORY_DICT_MAPPING.containsKey(category)) {
            LOGGER.warn("未在缓存中找到字典类别码为{}的缓存", category);
            return;
        }
        CATEGORY_DICT_MAPPING.remove(category);
    }

    /**
     * <p>清除所有字典类别缓存</p>
     *
     * @author guocq
     * @date 2022/11/29 9:45
     */
    public static void clear() {
        CATEGORY_DICT_MAPPING.clear();
    }
}
