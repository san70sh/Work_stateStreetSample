package com.sapient.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import com.sapient.models.Product;



public class LoadPricesTest {
	
	private Map<String, Product> tmap1;
	PointOfSaleTerminal terminal;
	
	
	@Before
	public void init() {
	
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		tmap1 = terminal.loadPrices();
	}
	
	
	
	@Test
	public final void testLoadPrices() {
		Map<String, Product> testMap = new HashMap<>();
		Product p1 = new Product("A1",1.25f,"V",3.00f,3);
		Product p2 = new Product("3-Q",4.25f,"NA",4.25f,1);
		Product p3 = new Product("45K11",1.00f,"V",5.00f,6);
		Product p4 = new Product("X1",0.75f,"NA",0.75f,1);
		testMap.put("A1", p1);
		testMap.put("3-Q", p2);
		testMap.put("45K11", p3);
		testMap.put("X1", p4);
		assertThat(tmap1, is(testMap));
		
	}

}
