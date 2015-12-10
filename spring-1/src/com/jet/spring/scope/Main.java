package com.jet.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jet.spring.autowire.Address;
import com.jet.spring.autowire.Car;
import com.jet.spring.autowire.Person;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
	
		Car car = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		System.out.println(car == car2);
	}
}
