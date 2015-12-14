package com.jet.spring.aop.helloworld;

public class AtithmeticCalculatorLoggingImpl implements AtithmeticCalculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The mehtod add begins with[" +i +","+ j + "]");
		int result = i + j;
		System.out.println("The mehtod add ends with[" +i +","+ j + "]");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The mehtod sub begins with[" +i +","+ j + "]");
		int result = i - j;
		System.out.println("The mehtod sub ends with[" +i +","+ j + "]");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The mehtod mul begins with[" +i +","+ j + "]");
		int result = i * j;
		System.out.println("The mehtod mul ends with[" +i +","+ j + "]");
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The mehtod div begins with[" +i +","+ j + "]");
		int result = i / j;
		System.out.println("The mehtod div ends with[" +i +","+ j + "]");
		return result;
	}

}
