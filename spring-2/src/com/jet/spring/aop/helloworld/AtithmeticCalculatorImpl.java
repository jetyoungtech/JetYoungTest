package com.jet.spring.aop.helloworld;

public class AtithmeticCalculatorImpl implements AtithmeticCalculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		int result = i / j;
		return result;
	}

}
