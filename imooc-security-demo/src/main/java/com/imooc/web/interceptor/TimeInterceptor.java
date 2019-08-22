package com.imooc.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {

	//访问方法之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod)handler).getMethod().getName());
		request.setAttribute("time", new Date().getTime());
		return true;
	}

	//方法访问完毕，进入after之前，如果业务方法异常，那么不会进入这个方法
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("time interceptor 耗时: " + (new Date().getTime() - (Long)request.getAttribute("time")));
		System.out.println("postHandle");
	}

	
	//访问方法之后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("time interceptor 耗时: " + (new Date().getTime() - (Long)request.getAttribute("time")));
		System.out.println("ex is " + ex);
		System.out.println("afterCompletion");
	}

}
