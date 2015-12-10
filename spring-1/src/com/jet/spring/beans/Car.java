package com.jet.spring.beans;

public class Car {
	
	private String band;
	private String corp;
	private double price;
	private int maxSpeed;
	
	public void setPrice(double price) {
		this.price = price;
	}

	public Car(String band, String corp, double price) {
		super();
		this.band = band;
		this.corp = corp;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [band=" + band + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}

	public Car(String band, String corp, int maxSpeed) {
		super();
		this.band = band;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}
	
	
	
	
	

}
