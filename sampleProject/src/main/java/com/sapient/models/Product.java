package com.sapient.models;

public class Product {

	private String name;
	private float unitPrice, volPrice;
	private String volume;
	private int qty,count;
	
	
	public Product(String name, float unitPrice, String volume, float volPrice, int qty) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.volume = volume;
		this.volPrice = volPrice;
		this.qty = qty;
		this.count = 0;
	}


	public String getName() {
		return name;
	}


	public float getUnitPrice() {
		return unitPrice;
	}


	public float getVolPrice() {
		return volPrice;
	}


	public String getVolume() {
		return volume;
	}


	public int getCount() {
		return count;
	}

	
	public void setCount(int count) {
		this.count = count;
	}


	public int getQty() {
		return qty;
	}
	
	
}
