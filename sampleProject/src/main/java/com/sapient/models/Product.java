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


	public Product() {
		super();
		// TODO Auto-generated constructor stub
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + qty;
		result = prime * result + Float.floatToIntBits(unitPrice);
		result = prime * result + Float.floatToIntBits(volPrice);
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (count != other.count)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (qty != other.qty)
			return false;
		if (Float.floatToIntBits(unitPrice) != Float.floatToIntBits(other.unitPrice))
			return false;
		if (Float.floatToIntBits(volPrice) != Float.floatToIntBits(other.volPrice))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", unitPrice=" + unitPrice + ", volPrice=" + volPrice + ", volume=" + volume
				+ ", qty=" + qty + ", count=" + count + "]";
	}
	
	
}
