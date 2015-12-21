package com.jet.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明成一个切面：需要把该类放入IOC容器中，在声明为一个生面
@Aspect
@Component
public class LoggingAspect {
	
	//声明该方法是一个前置通知：在目标方法开始之前
	@Before("execution(* com.jet.spring.aop.impl.*.*(int, int))")
	public void beforeMethod(JoinPoint joinpoint){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" begins with" + args);
	}
	//在目标方法执行后（无论是否发生异常），执行的通知
	//在后置通知中还不能方法目标方法执行的结果
	@After("execution(* com.jet.spring.aop.impl.*.*(int, int))")
	public void afterMethod(JoinPoint joinpoint){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" after with" + args);
	}

}
