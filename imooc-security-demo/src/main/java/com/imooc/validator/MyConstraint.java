package com.imooc.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义注解
 * @author Administrator
 *
 */
@Target({ElementType.METHOD, ElementType.FIELD})//注解可以标注的位置
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)//指定注解的执行类，指定的这个类会进行注解任务执行
public @interface MyConstraint {
	
	String message() default "{org.hibernate.validator.constraints.NotBlank.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
