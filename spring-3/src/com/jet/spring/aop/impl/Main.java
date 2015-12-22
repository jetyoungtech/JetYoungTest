package com.jet.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//1. ����Spring IOC ����
		
				ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				
				//2. ��IOC�����л�ȡbean��ʵ��
				AtithmeticCalculator atithmeticCalculator = ctx.getBean(AtithmeticCalculator.class);
				
				//3. ʹ��Bean
				int result = atithmeticCalculator.add(3, 6);
				System.out.println("result:" + result);
				
				result = atithmeticCalculator.div(12, 6);
				System.out.println("result:" + result);
				
	}
}
