package com.jet.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AtithmeticCalculatorLoggingProxy {
	
	//Ҫ����Ķ���
	private AtithmeticCalculator target;
	
	public AtithmeticCalculatorLoggingProxy(AtithmeticCalculator target) {
		super();
		this.target = target;
	}
	
	public AtithmeticCalculator getLoggingProxy() {
		
		AtithmeticCalculator proxy = null;
		
		
		
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces = new Class[]{AtithmeticCalculator.class};
		
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h = new InvocationHandler(){
			
			/**
			 * proxy:���ڷ��ص��Ǹ��������һ������£���invoke�����ж������øö���
			 * method�����ڱ����õķ���
			 * args�����÷���ʱ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				String methodName = method.getName();
				System.out.println("The method" + methodName + "begins with" + Arrays.asList(args));
				//ִ�з���
				Object result =  method.invoke(target, args); 
				System.out.println("The method" + methodName + "ends with" +result);
				return result;
			}
		};
		proxy = (AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
		
	}

	

}
