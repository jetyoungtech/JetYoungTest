package com.jet.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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

}
