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

//�������������һ�����棺��Ҫ�Ѹ������IOC�����У�������Ϊһ������
@Aspect
@Component
public class LoggingAspect {
	
	//�����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰ
	@Before("execution(* com.jet.spring.aop.impl.*.*(int, int))")
	public void beforeMethod(JoinPoint joinpoint){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" begins with" + args);
	}
	//��Ŀ�귽��ִ�к������Ƿ����쳣����ִ�е�֪ͨ
	//�ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ��
	@After("execution(* com.jet.spring.aop.impl.*.*(int, int))")
	public void afterMethod(JoinPoint joinpoint){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" after with" + args);
	}
	
	/**
	 * �ڷ�������������ִ�е�֪ͨ
	 * ����֪ͨ�ǿ��Է��ʷ����ķ���ֵ��
	 * @param joinpoint
	 */
	@AfterReturning(value="execution(* com.jet.spring.aop.impl.*.*(int, int))", returning="result")
	public void afterReturningMethod(JoinPoint joinpoint, Object result){
		String methodName = joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+ methodName +" ends with" + result);
	}
	
	
	/**
	 * �ڷ��������쳣ʱ��Ŀ�귽��
	 * ���Է��ʵ��쳣������ָ���ڳ����ض��쳣ʱ��ִ��֪ͨ����
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
	 * ����֪ͨ��ҪЯ�� ProceedingJoinPoint �Ĳ��������л���֪ͨ�����ڶ�̬�������ȫ����
	 * ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 * @param pjd
	 */
	@Around("execution(* com.jet.spring.aop.impl.*.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("The method " + methodName + "begin with " + Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//����֪ͨ
			System.out.println("The method "+ methodName +"ends with" + result);	
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//�쳣֪ͨ
			System.out.println("The method"+ methodName +" occurs exception: "+ e);
			throw new RuntimeException(e);
			
		}
		
		
		//����֪ͨ
		System.out.println("The method" + methodName +"ends");
		return 100;
	}
	
	

}
