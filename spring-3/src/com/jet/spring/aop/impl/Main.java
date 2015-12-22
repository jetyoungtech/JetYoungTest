package com.jet.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//1. 创建Spring IOC 容器
		
				ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				
				//2. 从IOC容器中获取bean的实例
				AtithmeticCalculator atithmeticCalculator = ctx.getBean(AtithmeticCalculator.class);
				
				//3. 使用Bean
				int result = atithmeticCalculator.add(3, 6);
				System.out.println("result:" + result);
				
				result = atithmeticCalculator.div(12, 6);
				System.out.println("result:" + result);
				
	}
}
