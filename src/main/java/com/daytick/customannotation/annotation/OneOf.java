package com.daytick.customannotation.annotation;

import com.daytick.customannotation.annotation.validator.OneOfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用该注解的属性只能为特定值之一
 *
 * @author ly
 * @since 2020/12/25 11:37 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OneOfValidator.class)
public @interface OneOf {
    // 允许的值（int类型）
    int[] intValue() default {};

    // 允许的值（String类型）
    String[] strValue() default {};

    // 提示信息
    String message() default "参数不符合要求！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
