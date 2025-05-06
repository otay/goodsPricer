package com.unify.model;

public class Product {
	

	private  String name;
	private  double price;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

	public Product (String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product: name ='"+
					name + "' Price : "+price;
	}
}
