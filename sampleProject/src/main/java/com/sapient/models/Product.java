package com.sapient.models;

public class Product {

	String name;
	float unitPrice, volPrice;
	String volume;
	int qty,count;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


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


	public void setName(String name) {
		this.name = name;
	}


	public float getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}


	public float getVolPrice() {
		return volPrice;
	}


	public void setVolPrice(float volPrice) {
		this.volPrice = volPrice;
	}


	public String getVolume() {
		return volume;
	}


	public void setVolume(String volume) {
		this.volume = volume;
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


	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", unitPrice=" + unitPrice + ", volume=" + volume + ", volPrice=" + volPrice +
				 ", qty=" + qty + "]";
	}
	
	public void updateCount(boolean reset) {
		if (reset) {
			this.count = 0;
		} else {
			this.count++;
		}
	}
	
}
