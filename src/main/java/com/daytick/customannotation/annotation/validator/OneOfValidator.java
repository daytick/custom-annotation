package com.daytick.customannotation.annotation.validator;

import com.daytick.customannotation.annotation.OneOf;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OneOf注解对应的validator，需要实现ConstraintValidator<OneOf, Integer>
 * 第1个泛型：要处理的注解
 * 第2个泛型：可处理的类型
 *
 * @author ly
 * @since 2020/12/25 11:40 AM
 */
public class OneOfValidator implements ConstraintValidator<OneOf, Object> {

    // 合法的数值
    private List<Integer> legalIntList;
    // 合法的字符串
    private List<String> legalStrList;

    /**
     * 初始化操作
     *
     * @param constraintAnnotation 该validator要处理的注解
     */
    @Override
    public void initialize(OneOf constraintAnnotation) {
        legalIntList = Arrays.stream(constraintAnnotation.intValue()).boxed().collect(Collectors.toList());
        legalStrList = Arrays.asList(constraintAnnotation.strValue());
    }

    /**
     * 具体校验逻辑
     *
     * @param value   @OneOf标记的属性接收值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof Integer) {
            return legalIntList.contains(value);
        }
        if (value instanceof String) {
            return legalStrList.contains(value);
        }
        return false;
    }
}
