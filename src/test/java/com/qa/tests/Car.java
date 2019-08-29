package com.qa.tests;

public class Car {
	
	private int door;
	private String brand;
	
	
	public Car()
	{
		
	}
	
	public Car(int door,String brand){
		
		this.door=door;
		this.brand=brand;
		
	}
	
	
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	

}
