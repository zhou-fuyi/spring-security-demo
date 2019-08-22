package com.imooc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 两个泛型类型，第一个为该注解任务执行类的注解，也就是指定这个类进行任务执行的那个注解，第二个泛型为这个注解使用的类型，可以是String（那么注解只对String有效）等
 * @author Administrator
 * 
 * 实现了ConstraintValidator spring会自动管理该类  
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

//	在这里可以使用spring环境，可以使用@Autowared等
	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		System.out.println("initialize");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println(value);
		System.out.println("isValid");
		return false;
	}

}
