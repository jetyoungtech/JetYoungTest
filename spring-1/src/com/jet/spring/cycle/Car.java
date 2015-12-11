package com.jet.spring.cycle;

public class Car {

	public Car(){
		System.out.println("Car`s Contructor");
		
	}
	
	private String brand;
	
	public void setBrand(String brand) {
		System.out.println("setBrand");
		this.brand = brand;
	}
	
	public void init(){
		System.out.println("init.....");
	}
	
	public void destroy(){
		System.out.println("destroy.....");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
	
}
