package com.jet.spring.beans;

public class HelloWorld {
	
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void hello(){
		System.out.println("Hello" + name);
	}
	

}