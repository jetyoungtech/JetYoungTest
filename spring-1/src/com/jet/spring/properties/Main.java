package com.jet.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jet.spring.autowire.Address;
import com.jet.spring.autowire.Person;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
	/*	
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		
		address = (Address) ctx.getBean("address2");
		System.out.println(address);*/
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
