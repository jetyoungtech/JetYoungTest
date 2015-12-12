package com.jet.spring.bean.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person person = (Person) ctx.getBean("person5");
		
		System.out.println(person);
		
		NewPerson newperson = (NewPerson) ctx.getBean("person4");
		System.out.println(newperson);
		
		DataSource datasource = ctx.getBean(DataSource.class);
		System.out.println(datasource.getProperties());
	}

}
