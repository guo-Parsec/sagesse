package org.edu.sagesse.common.support.helper;

import com.google.common.collect.Maps;
import org.edu.sagesse.common.util.ArrayUtil;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * spel表达式辅助类
 *
 * @author guocq
 */
public class SpelHelper {

    /**
     * <p>解析表达式字符串</p>
     *
     * @param expressionString 表达式字符串
     * @param varMap           传递的参数
     * @param tClass           结果的类对象
     * @return T
     * @author guocq
     * @date 2022/12/1 11:20
     */
    public static <T> T parse(String expressionString, Map<String, Object> varMap, Class<T> tClass) {
        ExpressionParser parser = new SpelExpressionParser();
        // SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        varMap.forEach(context::setVariable);
        return parser.parseExpression(expressionString).getValue(context, tClass);
    }

    /**
     * <p>构建方法的参数与返回值map,参数的key即为参数名称，返回值的key是result</p>
     *
     * @param method 方法
     * @param args   方法参数
     * @param result 方法结果
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author guocq
     * @date 2022/12/1 11:29
     */
    public static Map<String, Object> buildMethodVarMap(Method method, Object[] args, Object result) {
        Assert.notNull(method, "method不能为null");
        Assert.notEmpty(args, "args不能为空");
        // 获取被拦截方法参数名列表(使用Spring支持类库)
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        if (ArrayUtil.isEmpty(parameterNames)) {
            return Maps.newHashMap();
        }
        Map<String, Object> varMap = Maps.newHashMapWithExpectedSize(parameterNames.length + 1);
        for (int i = 0; i < parameterNames.length; i++) {
            varMap.put(parameterNames[i], args[i]);
        }
        if (result != null) {
            varMap.put("result", result);
        }
        return varMap;
    }
}
