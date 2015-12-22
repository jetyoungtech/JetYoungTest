package com.jet.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	/**
	 * 在方法正常结束后执行的通知
	 * 返回通知是可以访问方法的返回值的
	 * @param joinpoint
	 */
	@AfterReturning(value="execution(* com.jet.spring.aop.impl.*.*(int, int))", returning="result")
	public void afterReturningMethod(JoinPoint joinpoint, Object result){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" ends with" + result);
	}
	
	
	/**
	 * 在方法出现异常时的目标方法
	 * 可以访问到异常对象且指定在出现特定异常时再执行通知代码
	 * @param joinpoint
	 * @param ex
	 */
	
	@AfterThrowing(value="execution(* com.jet.spring.aop.impl.*.*(int, int))", throwing="ex")
	public void afterThrowingMethod(JoinPoint joinpoint, Exception ex){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" occurs excetion: with" + ex);
	}
	
	/**
	 * 环绕通知需要携带 ProceedingJoinPoint 的参数，其中环绕通知类似于动态代理里的全过程
	 * ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 * @param pjd
	 */
	@Around("execution(* com.jet.spring.aop.impl.*.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method " + methodName + "begin with " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//返回通知
			System.out.println("The method "+ methodName +"ends with" + result);	
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//异常通知
			System.out.println("The method"+ methodName +" occurs exception: "+ e);
			throw new RuntimeException(e);
			
		}
		
		
		//后置通知
		System.out.println("The method" + methodName +"ends");
		return 100;
	}
	
	

}
