package com.imooc.web.aspect;

import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	@Around("execution(* com.imooc.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("time aspect start");
		long time = new Date().getTime();
		Object[] args = pjp.getArgs();
		for(Object arg : args) {
			System.out.println("arg is " + arg);
		}
		Object object = pjp.proceed();
		System.out.println(ReflectionToStringBuilder.toString(object, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println("time aspect 耗时: " + (new Date().getTime() - time));
		System.out.println("time aspect end");
		return object;
	}
	

}
