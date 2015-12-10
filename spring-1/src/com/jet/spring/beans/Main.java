package com.jet.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main (String[] arg){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloWorld hw = (HelloWorld) ctx.getBean("helloworld");
		
		//HelloWorld hw1 = ctx.getBean(HelloWorld.class);
		hw.hello();
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person person = (Person) ctx.getBean("person2");
		System.out.println(person);
	}
	
}
