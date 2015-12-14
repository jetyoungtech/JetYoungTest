package com.jet.spring.aop.helloworld;

public class Main {
	
	public static void main(String[] args) {
		
		AtithmeticCalculator target = new AtithmeticCalculatorImpl(); 
		AtithmeticCalculator proxy =  new AtithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		int result = proxy.add(1, 2);
		System.out.println("--" + result + "--");
		result = proxy.div(4, 2);
		System.out.println("--" + result + "--");
		
	}

}
