package com.sapient.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.sapient.models.Product;


public class UpdatePriceTest {
	private PointOfSaleTerminal terminal = new PointOfSaleTerminal();
	private float totalPrice = 0.00f;
	private Map<String, Product> tmap1;
	
	@Before
	public void init() {
	
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		tmap1 = terminal.loadPrices();
	}
	
	@Test
	public void test() {
		terminal.loadPrices();
		List<String> cart1 = new ArrayList<>();
		for(int i=0; i<7;i++) {
			cart1.add("45K11");
		}
		cart1.add("E");
		for(int i=0;i<cart1.size();i++) {
		}
		
		assertEquals("5.00", totalPrice);
	}

}
